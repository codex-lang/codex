package com.lutz.codex.syntax;

public class Tokens {
	
	// --------------
	// SPECIAL TOKENS
	// --------------	
	
	public static final int NULL_VALUE = -1;				// The value 'null' 
	
	// ----------------
	// SYNTACTIC TOKENS
	// ----------------
	
	// PUNCTUATION
	
	public static final int LEFT_CURLY_BRACE = 10;			// The '{'
	public static final int RIGHT_CURLY_BRACE = 11;			// The '}'
	public static final int LEFT_PARENTHESIS = 12;			// The '('
	public static final int RIGHT_PARENTHESIS = 13;			// The ')'
	public static final int LEFT_SQUARE_BRACE = 14;			// The '['
	public static final int RIGHT_SQUARE_BRACE = 15;		// The ']'
	public static final int SEMICOLON = 16;					// The ';' (statement end)
	public static final int VAR_DEF = 17;					// The '$' variable declaration
	
	// COMPARISONS
	
	public static final int EQUAL_TO = 18;					// The '=' comparison
	public static final int GREATER_THAN = 19;				// The '>' comparison
	public static final int LESS_THAN = 20;					// The '<' comparison
	public static final int GREATER_THAN_EQUAL_TO = 21;		// The '>=' comparison
	public static final int LESS_THAN_EQUAL_TO = 22;		// The '<=' comparison
	public static final int NOT_EQUAL_TO = 18;				// The '!=' comparison
	
	// KEYWORDS
	
	public static final int FUNCTION_DEF = 30;				// The 'func' definition
	public static final int INCLUDE_DEF = 31;				// The '#include' inclusion definition
	
	// LOOPS
	
	public static final int IF_DEF = 40;					// The 'if' statement
	public static final int ELSEIF_DEF = 41;				// The 'elseif' statement
	public static final int ELSE_DEF = 42;					// The 'else' statement
	public static final int FOR_LOOP_DEF = 43;				// The 'for' loop definition
	public static final int WHILE_LOOP_DEF = 44;			// The 'while' loop definition
	
	// ----
	// MATH
	// ----
	
	// SINGLE NUMBER OPERATORS
	
	public static final int PLUS_PLUS_PRE = 60;				// The '++' operator coming before a variable
	public static final int PLUS_PLUS_POST = 61;			// The '++' operator coming after a variable
	public static final int MINUS_MINUS_PRE = 62;			// The '--' operator coming before a variable
	public static final int MINUS_MINUS_POST = 63;			// The '--' operator coming after a variable
	
	// MULTI-NUMBER OPERATORS
	
	public static final int PLUS = 70;						// The '+' operator
	public static final int MINUS = 71;						// The '-' operator
	public static final int MULTIPLY = 72;					// The '*' operator
	public static final int DIVIDE = 73;					// The '/' operator
	public static final int MODULUS = 74;					// The '%' operator
	public static final int PLUS_EQUALS = 75;				// The '+=' operator
	public static final int MINUS_EQUALS = 76;				// The '-=' operator
	public static final int MULTIPLY_EQUALS = 77;			// The '*=' operator
	public static final int DIVIDE_EQUALS = 78;				// The '/=' operator
	public static final int MODULUS_EQUALS = 79;			// The '%=' operator
	
	// -----------
	// MISC TOKENS
	// -----------
	
	public static final int FUNCTION_NAME = 90;				// The token type representing a function name
	public static final int VARIABLE_NAME = 91;				// The token type representing a variable name
	public static final int STRING_VALUE = 100;				// The token type representing a misc. string
	
	public static TokenInfo constructTokenInfo(int token, Object data){
		
		return new TokenInfo(token, data);
	}
}
