package com.app.ErrorResponses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
	private int statusCode;
	private String msg;
	public ErrorResponse(int statusCode, String msg) {
		this.statusCode = statusCode;
		this.msg = msg;
	}
	
}
