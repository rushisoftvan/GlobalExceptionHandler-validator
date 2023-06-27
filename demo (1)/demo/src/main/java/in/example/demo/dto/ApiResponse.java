package in.example.demo.dto;

import java.util.List;

public class ApiResponse<T> {
   
	private T data;
	
	private Integer status;
	
	private List<String> errors;
	
	
	public ApiResponse(){
		
	}
	
	public ApiResponse(T data,Integer status) {
		this.data=data;
		this.status=status;
	}
	
	public ApiResponse(List<String> errors,Integer status) {
		this.errors=errors;
		this.status=status;
	}
	
	
}
