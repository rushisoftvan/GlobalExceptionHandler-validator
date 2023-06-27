package in.example.demo.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.example.demo.dto.StudentDto;

@RestController
@RequestMapping("/api")
@Validated
public class TestController {

	private Logger log = LoggerFactory.getLogger(TestController.class);

	@GetMapping("/users")
	public ResponseEntity<String> getUserByCountryAndUserId(
			@RequestParam("country") @NotEmpty(message = "country should not be empaty") String country,
			@RequestParam("id") @Positive(message = "id should be greater then zero") Integer id) {

		String name = country + id;
		return new ResponseEntity(name, HttpStatus.OK);
	}

	@PostMapping("/students")
	public ResponseEntity<String> saveStudent( @Valid @RequestBody StudentDto student) {
		log.debug(student.getFirstName());
		log.debug(student.getSurname());
		log.debug("student age {}", student.getAge());
		return new ResponseEntity<>(student.getFirstName(), HttpStatus.OK);
	}

}
