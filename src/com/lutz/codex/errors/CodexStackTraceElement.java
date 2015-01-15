package com.lutz.codex.errors;

public class CodexStackTraceElement {

	private int line;
	
	private String function, errorClass;
	
	private String customStr;
	
	private boolean custom = false;
	
	public CodexStackTraceElement(int line, String function, String errorClass){
		
		this.line = line;
		this.function = function;
		this.errorClass = errorClass;
	}
	
	public CodexStackTraceElement(String customStr){
		
		this(-1, "<null>", "<null>");
		
		this.customStr = customStr;
		this.custom = true;
	}
	
	public boolean hasCustomMessage(){
		
		return custom;
	}
	
	public String getCustomMessage(){
		
		return customStr;
	}
	
	public int getErroredLine(){
		
		return line;
	}
	
	public String getErroredFunction(){
		
		return function;
	}
	
	public String getErroredClass(){
		
		return errorClass;
	}
}
