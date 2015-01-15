package com.lutz.codex.debugging;

import java.util.List;
import java.util.ArrayList;

public class Debugger {

	private static List<String> strings = new ArrayList<String>();
	
	public static void addStringToList(String string){
		
		strings.add(string);
	}
	
	public static void print(){
		
		for(String string : strings){
			
			System.out.println(string);
		}
		
		strings.clear();
	}
}
