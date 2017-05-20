package com.example.mastercard.service.response;

public class ShoppingSession {

	private final String accessToken;

	public ShoppingSession(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

}
