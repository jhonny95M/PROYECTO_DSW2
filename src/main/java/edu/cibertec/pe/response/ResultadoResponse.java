package edu.cibertec.pe.response;

import lombok.Data;

@Data
public class ResultadoResponse {
	private int statusCode;
	private String message;
	public ResultadoResponse(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}
	public ResultadoResponse() {}

}
