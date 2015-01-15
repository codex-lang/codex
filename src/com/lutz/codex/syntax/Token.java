package com.lutz.codex.syntax;

import java.util.List;
import java.util.ArrayList;

public class Token {

	private static List<Token> tokens = new ArrayList<Token>();

	private int identNum;

	private boolean reserved;

	private String readable, reservedChar;

	public Token(String readable, int identNum) {

		this.identNum = identNum;
		this.readable = readable;
		this.reserved = false;
		this.reservedChar = "";
		
		this.addToTokenList();
	}

	public Token(String readable, String reservedChar, int identNum) {

		this.identNum = identNum;
		this.readable = readable;
		this.reserved = true;
		this.reservedChar = reservedChar;
		
		this.addToTokenList();
	}
	
	private void addToTokenList(){
		
		tokens.add(this);
	}

	public String getReadable() {

		return readable;
	}

	public String getReservedChar() {

		return reservedChar;
	}

	public boolean isReserved() {

		return reserved;
	}

	public int getTokenNumber() {

		return identNum;
	}

	public static Token[] getTokenList() {

		return tokens.toArray(new Token[] {});
	}
}
