package com.lutz.codex.testing;

import java.io.File;

import com.lutz.codex.testing.interpreter.CodexTokenInterpretationTest;

public class CodexTester {

	public static final CodexTest TOKEN_INTERPRETATION_TEST = new CodexTokenInterpretationTest();
	
	public static void main(String[] args){
		
		TOKEN_INTERPRETATION_TEST.runTest();
	}
	
	public static File getTestingFile(String name){
		
		return new File("test-files/"+name+".cdx");
	}
}
