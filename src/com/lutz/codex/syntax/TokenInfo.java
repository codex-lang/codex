package com.lutz.codex.syntax;

public class TokenInfo {

	private Token token;

	private Object tokenData;

	public TokenInfo(Token token) {

		this(token, null);
	}

	public TokenInfo(Token token, Object tokenData) {

		this.token = token;
		this.tokenData = tokenData;
	}

	public Token getToken() {

		return token;
	}

	public Object getTokenData() {

		return tokenData;
	}
}
