package com.lutz.codex.syntax;

public class Tokens {

	// --------------
	// SPECIAL TOKENS
	// --------------

	public static final Token NULL_VALUE = new Token("null_value", -1); // The
																		// value
																		// 'null'
	public static final Token UNKNOWN = new Token("unknown", 0); // Any unknown
																	// token

	// ----------------
	// SYNTACTIC TOKENS
	// ----------------

	// PUNCTUATION

	public static final Token LEFT_CURLY_BRACE = new Token("left_curly_brace",
			"{", 10); // The '{'
	public static final Token RIGHT_CURLY_BRACE = new Token(
			"right_curly_brace", "}", 11); // The '}'
	public static final Token LEFT_PARENTHESIS = new Token("left_parenthesis",
			"(", 12); // The '('
	public static final Token RIGHT_PARENTHESIS = new Token(
			"right_parenthesis", ")", 13); // The ')'
	public static final Token LEFT_SQUARE_BRACE = new Token(
			"left_square_brace", "[", 14); // The '['
	public static final Token RIGHT_SQUARE_BRACE = new Token(
			"right_square_brace", "]", 15); // The ']'
	public static final Token SEMICOLON = new Token("semicolon", ";", 16); // The
																			// ';'
																			// (statement
																			// end)
	public static final Token VAR_DEF = new Token("var_def", "$", 17); // The
																		// '$'
																		// variable
																		// declaration
	public static final Token QUOTATION_MARK = new Token("quotation_mark",
			"\"", 18); // The '"' literal string
	// declarator
	public static final Token COLON = new Token("colon", ":", 19); // The ':'
																	// declaration
																	// descriptor
	public static final Token COMMA = new Token("comma", ",", 20); // The
																	// multi-purpose
																	// ','
																	// character
	public static final Token EQUAL_SIGN = new Token("equal_sign", "=", 21); // The
																				// '='
																				// used
																				// for
																				// setting
																				// values
	public static final Token HASH_SYMBOL = new Token("hash_symbol", "#", 22); // The
																				// '#'
																				// used
																				// for
																				// certain
	// declarations
	public static final Token PERIOD = new Token("period", ".", 23); // The '.'
																		// punctuation
																		// mark

	// COMPARISONS

	public static final Token EQUAL_TO = new Token("equal_to", "==", 25); // The
																			// '=='
																			// comparison
	public static final Token GREATER_THAN = new Token("greater_than", ">", 26); // The
																					// '>'
																					// comparison
	public static final Token LESS_THAN = new Token("less_than", "<", 27); // The
																			// '<'
																			// comparison
	public static final Token GREATER_THAN_EQUAL_TO = new Token(
			"greater_than_equal_to", ">=", 28); // The '>=' comparison
	public static final Token LESS_THAN_EQUAL_TO = new Token(
			"less_than_equal_to", "<=", 29); // The '<=' comparison
	public static final Token NOT_EQUAL_TO = new Token("not_equal_to", "!=", 30); // The
																					// '!='
																					// comparison
	public static final Token NEGATION = new Token("negation", "!", 31); // The
																			// '!'
																			// negation

	// KEYWORDS

	public static final Token FUNCTION_DEF = new Token("function_def", 35); // The
																			// 'func'
																			// definition
	public static final Token INCLUDE_DEF = new Token("include_def", 36); // The
																			// '#include'
																			// inclusion
	// definition

	// LOOPS

	public static final Token IF_DEF = new Token("if", 40); // The 'if'
															// statement
	public static final Token ELSEIF_DEF = new Token("elseif", 41); // The
																	// 'elseif'
																	// statement
	public static final Token ELSE_DEF = new Token("else", 42); // The 'else'
																// statement
	public static final Token FOR_LOOP_DEF = new Token("for_loop", 43); // The
																		// 'for'
																		// loop
																		// definition
	public static final Token WHILE_LOOP_DEF = new Token("while_loop", 44); // The
																			// 'while'
																			// loop
																			// definition

	// ----
	// MATH
	// ----

	// SINGLE NUMBER OPERATORS

	public static final Token PLUS_PLUS = new Token("plus_plus", "++", 55); // The
																			// token
																			// for
																			// any
	// '++'
	public static final Token MINUS_MINUS = new Token("minus_minus", "--", 56); // The
																				// token
																				// for
																				// any
	// '--'

	// MULTI-NUMBER OPERATORS

	public static final Token PLUS = new Token("plus", "+", 70); // The '+'
																	// operator
	public static final Token MINUS = new Token("minus", "-", 71); // The '-'
																	// operator
	public static final Token MULTIPLY = new Token("multiply", "*", 72); // The
																			// '*'
																			// operator
	public static final Token DIVIDE = new Token("divide", "/", 73); // The '/'
																		// operator
	public static final Token MODULUS = new Token("modulus", "%", 74); // The
																		// '%'
																		// operator
	public static final Token PLUS_EQUALS = new Token("plus_equals", "+=", 75); // The
																				// '+='
																				// operator
	public static final Token MINUS_EQUALS = new Token("minus_equals", "-=", 76); // The
																					// '-='
																					// operator
	public static final Token MULTIPLY_EQUALS = new Token("multiply_equals",
			"*=", 77); // The '*=' operator
	public static final Token DIVIDE_EQUALS = new Token("divide_equals", "/=",
			78); // The '/=' operator
	public static final Token MODULUS_EQUALS = new Token("modulus_equals",
			"%=", 79); // The '%=' operator

	// -----------
	// MISC TOKENS
	// -----------

	public static final Token FUNCTION_NAME = new Token("function_name", 90); // The
																				// token
																				// type
																				// representing
	// a
	// function name
	public static final Token VARIABLE_NAME = new Token("variable_name", 91); // The
																				// token
																				// type
																				// representing
	// a
	// variable name
	public static final Token STRING_VALUE = new Token("string_value", 100); // The
																				// token
																				// type
																				// representing
	// a
	// misc. string

	// -------------
	// MISC RESERVED
	// -------------

	public static final Token LINE_COMMENT = new Token("line_comment", "//",
			110);
	public static final Token MULTILINE_COMMENT_OPEN = new Token("multiline_comment_open", "/*",
			111);
	public static final Token MULTILINE_COMMENT_CLOSE = new Token("multiline_comment_close", "*/",
			112);

	// ----------------
	// CHARACTER ARRAYS
	// ----------------

	public static final char[] RESERVED_CHARS = new char[] { '{', '}', '(',
			')', '[', ']', ',', '$', '\"', '=', '>', '<', '!', '#', '+', '-',
			'*', '/', '%', ';', ':', '.' };

	public static TokenInfo constructTokenInfo(Token token, Object data) {

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

		for (Token t : Token.getTokenList()) {

			if (t.getReservedChar().equalsIgnoreCase(token)) {

				return new TokenInfo(t);
			}
		}

		return new TokenInfo(Tokens.UNKNOWN);
	}

	public static String getNameForToken(Token token) {

		return token.getReadable();
	}
}
