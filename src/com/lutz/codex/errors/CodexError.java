package com.lutz.codex.errors;

import java.util.ArrayList;
import java.util.List;

public class CodexError {

	private String message;
	
	private long timeMillis;
	
	private List<CodexStackTraceElement> stackTrace = new ArrayList<CodexStackTraceElement>();
	
	public CodexError(String message){
		
		this.message = message;
		
		timeMillis = System.currentTimeMillis();
	}
	
	public String getMessage(){
		
		return message;
	}
	
	public long getTimeMillis(){
		
		return timeMillis;
	}
	
	public void throwError(){
		
		Errors.throwError(this);
	}
	
	public void addStackTraceElement(CodexStackTraceElement cste){
		
		stackTrace.add(cste);
	}
	
	public CodexStackTraceElement[] getStackTrace(){
		
		return stackTrace.toArray(new CodexStackTraceElement[]{});
	}
}
