package in.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StudentDto {
    
	@NotEmpty(message="firstName should not be null or empty")
	private String firstName;
	
	@NotEmpty(message="firstName should not be null or empty")
	private String surName;
	
	@NotNull(message="age  should not be null")
	private Integer age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surName;
	}

	public void setSurname(String surname) {
		surName = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
