package com.lutz.codex.syntax;


public class Tokens {

	// --------------
	// SPECIAL TOKENS
	// --------------

	public static final int NULL_VALUE = -1; // The value 'null'
	public static final int UNKNOWN = 0; // Any unknown token

	// ----------------
	// SYNTACTIC TOKENS
	// ----------------

	// PUNCTUATION

	public static final int LEFT_CURLY_BRACE = 10; // The '{'
	public static final int RIGHT_CURLY_BRACE = 11; // The '}'
	public static final int LEFT_PARENTHESIS = 12; // The '('
	public static final int RIGHT_PARENTHESIS = 13; // The ')'
	public static final int LEFT_SQUARE_BRACE = 14; // The '['
	public static final int RIGHT_SQUARE_BRACE = 15; // The ']'
	public static final int SEMICOLON = 16; // The ';' (statement end)
	public static final int VAR_DEF = 17; // The '$' variable declaration
	public static final int QUOTATION_MARK = 18; // The '"' literal string
													// declaration
	public static final int COLON = 19; // The ':' declaration descriptor
	public static final int COMMA = 20; // The multi-purpose ',' character
	public static final int EQUAL_SIGN = 21; // The '=' used for setting values
	public static final int HASH_SYMBOL = 22; // The '#' used for certain
												// declarations

	// COMPARISONS

	public static final int EQUAL_TO = 25; // The '=' comparison
	public static final int GREATER_THAN = 26; // The '>' comparison
	public static final int LESS_THAN = 27; // The '<' comparison
	public static final int GREATER_THAN_EQUAL_TO = 28; // The '>=' comparison
	public static final int LESS_THAN_EQUAL_TO = 29; // The '<=' comparison
	public static final int NOT_EQUAL_TO = 30; // The '!=' comparison
	public static final int NEGATION = 31; // The '!' negation

	// KEYWORDS

	public static final int FUNCTION_DEF = 35; // The 'func' definition
	public static final int INCLUDE_DEF = 36; // The '#include' inclusion
												// definition

	// LOOPS

	public static final int IF_DEF = 40; // The 'if' statement
	public static final int ELSEIF_DEF = 41; // The 'elseif' statement
	public static final int ELSE_DEF = 42; // The 'else' statement
	public static final int FOR_LOOP_DEF = 43; // The 'for' loop definition
	public static final int WHILE_LOOP_DEF = 44; // The 'while' loop definition

	// ----
	// MATH
	// ----

	// SINGLE NUMBER OPERATORS

	public static final int PLUS_PLUS = 55; // The intermediate token for any
											// '++'
	public static final int MINUS_MINUS = 56; // The intermediate token for any
												// '--'
	public static final int PLUS_PLUS_PRE = 60; // The '++' operator coming
												// before a variable
	public static final int PLUS_PLUS_POST = 61; // The '++' operator coming
													// after a variable
	public static final int MINUS_MINUS_PRE = 62; // The '--' operator coming
													// before a variable
	public static final int MINUS_MINUS_POST = 63; // The '--' operator coming
													// after a variable

	// MULTI-NUMBER OPERATORS

	public static final int PLUS = 70; // The '+' operator
	public static final int MINUS = 71; // The '-' operator
	public static final int MULTIPLY = 72; // The '*' operator
	public static final int DIVIDE = 73; // The '/' operator
	public static final int MODULUS = 74; // The '%' operator
	public static final int PLUS_EQUALS = 75; // The '+=' operator
	public static final int MINUS_EQUALS = 76; // The '-=' operator
	public static final int MULTIPLY_EQUALS = 77; // The '*=' operator
	public static final int DIVIDE_EQUALS = 78; // The '/=' operator
	public static final int MODULUS_EQUALS = 79; // The '%=' operator

	// -----------
	// MISC TOKENS
	// -----------

	public static final int FUNCTION_NAME = 90; // The token type representing a
												// function name
	public static final int VARIABLE_NAME = 91; // The token type representing a
												// variable name
	public static final int STRING_VALUE = 100; // The token type representing a
												// misc. string

	// ----------------
	// CHARACTER ARRAYS
	// ----------------

	public static final char[] RESERVED_CHARS = new char[] { '{', '}', '(',
			')', '[', ']', ',', '$', '\"', '=', '>', '<', '!', '#', '+', '-',
			'*', '/', '%' };

	public static TokenInfo constructTokenInfo(int token, Object data) {

		return new TokenInfo(token, data);
	}

	public static boolean isReserved(char c) {

		for (char ch : RESERVED_CHARS) {

			if (ch == c) {

				return true;
			}
		}

		return false;
	}

	public static TokenInfo parseReservedCharToken(String token) {

		switch (token) {

		case "{":

			return new TokenInfo(Tokens.LEFT_CURLY_BRACE);

		case "}":

			return new TokenInfo(Tokens.RIGHT_CURLY_BRACE);

		case "(":

			return new TokenInfo(Tokens.LEFT_PARENTHESIS);

		case ")":

			return new TokenInfo(Tokens.RIGHT_PARENTHESIS);

		case "[":

			return new TokenInfo(Tokens.LEFT_SQUARE_BRACE);

		case "]":

			return new TokenInfo(Tokens.RIGHT_SQUARE_BRACE);

		case ",":

			return new TokenInfo(Tokens.COMMA);

		case "$":

			return new TokenInfo(Tokens.VAR_DEF);

		case "\"":

			return new TokenInfo(Tokens.QUOTATION_MARK);

		case "=":

			return new TokenInfo(Tokens.EQUAL_SIGN);

		case "==":

			return new TokenInfo(Tokens.EQUAL_TO);

		case ">":

			return new TokenInfo(Tokens.GREATER_THAN);

		case ">=":

			return new TokenInfo(Tokens.GREATER_THAN_EQUAL_TO);

		case "<":

			return new TokenInfo(Tokens.LESS_THAN);

		case "<=":

			return new TokenInfo(Tokens.LESS_THAN_EQUAL_TO);

		case "!":

			return new TokenInfo(Tokens.NEGATION);

		case "!=":

			return new TokenInfo(Tokens.NOT_EQUAL_TO);

		case "#":

			return new TokenInfo(Tokens.HASH_SYMBOL);

		case "+":

			return new TokenInfo(Tokens.PLUS);

		case "++":

			return new TokenInfo(Tokens.PLUS_PLUS);

		case "+=":

			return new TokenInfo(Tokens.PLUS_EQUALS);

		case "-":

			return new TokenInfo(Tokens.MINUS);

		case "--":

			return new TokenInfo(Tokens.MINUS_MINUS);

		case "-=":

			return new TokenInfo(Tokens.MINUS_EQUALS);

		case "*":

			return new TokenInfo(Tokens.MULTIPLY);

		case "*=":

			return new TokenInfo(Tokens.MULTIPLY_EQUALS);

		case "/":

			return new TokenInfo(Tokens.DIVIDE);

		case "/=":

			return new TokenInfo(Tokens.DIVIDE_EQUALS);

		case "%":

			return new TokenInfo(Tokens.MODULUS);

		case "%=":

			return new TokenInfo(Tokens.MODULUS_EQUALS);

		default:

			return new TokenInfo(Tokens.UNKNOWN);
		}
	}

	public static String getNameForToken(int token) {

		// TODO Make sure to add any tokens to this list for String names

		switch (token) {

		case NULL_VALUE:

			return "NULL_VALUE";

		case UNKNOWN:

			return "UNKNOWN";

		case LEFT_CURLY_BRACE:

			return "LEFT_CURLY_BRACE";

		case RIGHT_CURLY_BRACE:

			return "RIGHT_CURLY_BRACE";

		case LEFT_PARENTHESIS:

			return "LEFT_PARENTHESIS";

		case RIGHT_PARENTHESIS:

			return "RIGHT_PARENTHESIS";

		case LEFT_SQUARE_BRACE:

			return "LEFT_SQUARE_BRACE";

		case RIGHT_SQUARE_BRACE:

			return "RIGHT_SQUARE_BRACE";

		case SEMICOLON:

			return "SEMICOLON";

		case VAR_DEF:

			return "VAR_DEF";

		case QUOTATION_MARK:

			return "QUOTATION_MARK";

		case COLON:

			return "COLON";

		case COMMA:

			return "COMMA";

		case EQUAL_SIGN:

			return "EQUAL_SIGN";

		case HASH_SYMBOL:

			return "HASH_SYMBOL";

		case EQUAL_TO:

			return "EQUAL_TO";

		case GREATER_THAN:

			return "GREATER_THAN";

		case LESS_THAN:

			return "LESS_THAN";

		case GREATER_THAN_EQUAL_TO:

			return "GREATER_THAN_EQUAL_TO";

		case LESS_THAN_EQUAL_TO:

			return "LESS_THAN_EQUAL_TO";

		case NOT_EQUAL_TO:

			return "NOT_EQUAL_TO";

		case NEGATION:

			return "NEGATION";

		case FUNCTION_DEF:

			return "FUNCTION_DEF";

		case INCLUDE_DEF:

			return "INCLUDE_DEF";

		case IF_DEF:

			return "IF_DEF";

		case ELSEIF_DEF:

			return "ELSEIF_DEF";

		case ELSE_DEF:

			return "ELSE_DEF";

		case FOR_LOOP_DEF:

			return "FOR_LOOP_DEF";

		case WHILE_LOOP_DEF:

			return "WHILE_LOOP_DEF";

		case PLUS_PLUS:

			return "PLUS_PLUS";

		case MINUS_MINUS:

			return "MINUS_MINUS";

		case PLUS_PLUS_PRE:

			return "PLUS_PLUS_PRE";

		case PLUS_PLUS_POST:

			return "PLUS_PLUS_POST";

		case MINUS_MINUS_PRE:

			return "MINUS_MINUS_PRE";

		case MINUS_MINUS_POST:

			return "MINUS_MINUS_POST";

		case PLUS:

			return "PLUS";

		case MINUS:

			return "MINUS";

		case MULTIPLY:

			return "MULTIPLY";

		case DIVIDE:

			return "DIVIDE";

		case MODULUS:

			return "MODULUS";

		case PLUS_EQUALS:

			return "PLUS_EQUALS";

		case MINUS_EQUALS:

			return "MINUS_EQUALS";

		case MULTIPLY_EQUALS:

			return "MULTIPLY_EQUALS";

		case DIVIDE_EQUALS:

			return "DIVIDE_EQUALS";

		case MODULUS_EQUALS:

			return "MODULUS_EQUALS";

		case FUNCTION_NAME:

			return "FUNCTION_NAME";

		case VARIABLE_NAME:

			return "VARIABLE_NAME";

		case STRING_VALUE:

			return "STRING_VALUE";

		default:

			return getNameForToken(Tokens.UNKNOWN);
		}
	}
}
