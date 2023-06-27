package in.example.demo.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExcpetionHandler {
	private Logger log = LoggerFactory.getLogger(GlobalExcpetionHandler.class);

	@ExceptionHandler( value = {ConstraintViolationException.class,MethodArgumentTypeMismatchException.class,MethodArgumentNotValidException.class})
	public ResponseEntity<String> handleConstraintViolationException(Exception ex) {
             List<String> errors = new ArrayList<>();
		
             if(ex instanceof ConstraintViolationException) {
            	 errors.add(ex.getMessage());
             }
             if(ex instanceof MethodArgumentTypeMismatchException me) {
            	 String name = me.getName();
     			errors.add("Incorrect data type value for " + name);
             }
            
            if(ex instanceof MethodArgumentNotValidException) {
            	errors.add(ex.getMessage());
            }	 
             
             
	 return	new ResponseEntity(errors,HttpStatus.BAD_REQUEST);
		
	}
}
