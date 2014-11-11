package com.lutz.codex.interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lutz.codex.syntax.TokenInfo;

public class CodexTokenList implements Iterable<TokenInfo> {

	private List<TokenInfo> tokens = new ArrayList<TokenInfo>();
	
	private int currentTokenIndex = 0;
	
	public void addToken(int token){
		
		addToken(new TokenInfo(token));
	}
	
	public void addToken(TokenInfo info){
		
		tokens.add(info);
	}
	
	public TokenInfo[] getTokens(){
		
		return tokens.toArray(new TokenInfo[]{});
	}
	
	public TokenInfo getToken(int index){
		
		if(index < tokens.size()){
			
			return tokens.get(index);
			
		}else{
			
			return null;
		}
	}
	
	public boolean hasNextToken(){
		
		return currentTokenIndex < tokens.size();
	}
	
	public TokenInfo getNextToken(){
		
		if(currentTokenIndex < tokens.size()){
		
			currentTokenIndex++;
			
			return tokens.get(currentTokenIndex);
			
		}else{
			
			return null;
		}
	}
	
	public void resetTokenIndex(){
		
		currentTokenIndex = 0;
	}

	@Override
	public Iterator<TokenInfo> iterator() {

		return tokens.iterator();
	}
}
