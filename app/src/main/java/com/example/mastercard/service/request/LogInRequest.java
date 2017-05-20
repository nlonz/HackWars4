package com.example.mastercard.service.request;

public class LogInRequest {

	private final String email;
	private final String password;

	public LogInRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
