package com.lutz.codex.syntax;

public class TokenInfo {

	private int token;
	
	private Object tokenData;
	
	public TokenInfo(int token, Object tokenData){
		
		this.token = token;
		this.tokenData = tokenData;
	}
	
	public int getToken(){
		
		return token;
	}
	
	public Object getTokenData(){
		
		return tokenData;
	}
}
