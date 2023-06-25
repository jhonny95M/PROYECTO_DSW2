package edu.cibertec.pe.response;

import lombok.Data;

@Data
public class ErrorResponse {
	private String title;
	private String message;
    private String details;
	public ErrorResponse(String title, String message) {
		this.title = title;
		this.message = message;
	}
}
