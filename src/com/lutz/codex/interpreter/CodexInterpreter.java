package com.lutz.codex.interpreter;

import java.io.File;
import java.util.Scanner;

import com.lutz.codex.errors.CodexStackTraceElement;
import com.lutz.codex.interpreter.errors.SyntaxError;
import com.lutz.codex.syntax.TokenInfo;
import com.lutz.codex.syntax.Tokens;

public class CodexInterpreter {

	private static boolean lineComment = false, multiLineComment = false;

	private static CodexTokenList tokenList = new CodexTokenList();

	private static boolean holdEndComment = false, endCommentNext = false;

	public static CodexTokenList parseFileToTokenList(File f) {

		String fileContents = "";

		try {

			Scanner fileReader = new Scanner(f);

			while (fileReader.hasNextLine()) {

				String value = fileReader.nextLine();

				value += "\n";

				System.out.print(value);

				fileContents += value;
			}

			fileReader.close();

			char[] chars = fileContents.toCharArray();

			int currentLine = 1;

			String currentRead = "", currentReserved = "";

			TokenInfo saved = null;

			for (int currentIndex = 0; currentIndex < chars.length; currentIndex++) {

				char c = chars[currentIndex];

				if (Tokens.isReserved(c) || Character.isWhitespace(c)) {

					if (!currentRead.contentEquals("")) {

						TokenInfo save = new TokenInfo(Tokens.STRING_VALUE,
								currentRead.trim());

						addToken(save);

						currentRead = "";
					}

					if (!Character.isWhitespace(c)) {

						currentReserved += c;

						TokenInfo save = Tokens
								.parseReservedCharToken(currentReserved.trim());

						if (save.getToken() != Tokens.UNKNOWN) {

							saved = save;

						} else if (saved != null) {

							addToken(saved);

							saved = null;

							currentReserved = Character.toString(c);

							TokenInfo newSave = Tokens
									.parseReservedCharToken(Character
											.toString(c));

							if (newSave.getToken() != Tokens.UNKNOWN) {

								saved = newSave;
							}

						} else {

							SyntaxError error = new SyntaxError(
									"Unknown syntax token '"
											+ currentReserved.trim() + "'");

							error.addStackTraceElement(new CodexStackTraceElement(
									currentLine, "<parse tokens>", f.getName()
											.substring(
													0,
													f.getName()
															.lastIndexOf('.'))));

							error.throwError();
						}
					}

				} else {

					if (!currentReserved.contentEquals("")) {

						TokenInfo save = Tokens
								.parseReservedCharToken(currentReserved.trim());

						if (save.getToken() != Tokens.UNKNOWN) {

							addToken(save);

							saved = null;

							currentReserved = "";

						} else if (saved != null) {

							addToken(saved);

							currentReserved = "";

							saved = null;

						} else {

							SyntaxError error = new SyntaxError(
									"Unknown syntax token '"
											+ currentReserved.trim() + "'");

							error.addStackTraceElement(new CodexStackTraceElement(
									currentLine, "<parse tokens>", f.getName()
											.substring(
													0,
													f.getName()
															.lastIndexOf('.'))));

							error.throwError();
						}
					}

					currentRead += c;
				}

				if (c == '\n' || c == '\r') {

					currentLine++;

					if (lineComment) {

						endCommentNext = true;
					}
				}
			}

			if (saved != null) {

				addToken(saved);
			}

			return tokenList;

		} catch (Exception e) {

			e.printStackTrace();

			return null;
		}
	}

	private static void addToken(TokenInfo info) {

		if (!lineComment && !multiLineComment) {

			if (info.getToken() == Tokens.LINE_COMMENT) {

				lineComment = true;

				return;

			} else if (info.getToken() == Tokens.MULTILINE_COMMENT_OPEN) {

				multiLineComment = true;

				return;

			}

			tokenList.addToken(info);

		} else {

			if (info.getToken() == Tokens.MULTILINE_COMMENT_CLOSE) {

				multiLineComment = false;

				return;
			}

			if (endCommentNext) {

				endCommentNext = false;

				if (lineComment) {

					lineComment = false;
				}
			}
		}
	}

	public static CodexTokenList parseSecondLevel(CodexTokenList list) {

		CodexTokenList result = new CodexTokenList();

		while (list.hasNextToken()) {

			TokenInfo t = list.getNextToken();

			if (t.getToken() == Tokens.STRING_VALUE) {

				if (t.getTokenData().toString().equals("if")) {

					result.addToken(new TokenInfo(Tokens.IF_DEF));

				} else if (t.getTokenData().toString().equals("for")) {

					result.addToken(new TokenInfo(Tokens.FOR_LOOP_DEF));

				} else if (t.getTokenData().toString().equals("while")) {

					result.addToken(new TokenInfo(Tokens.WHILE_LOOP_DEF));

				} else {

					result.addToken(t);
				}

			} else if (t.getToken() == Tokens.HASH_SYMBOL) {

				if (list.isNextToken(Tokens.STRING_VALUE)) {

					if (list.isNextTokenData("include")) {

						list.getNextToken();

						result.addToken(new TokenInfo(Tokens.INCLUDE_DEF));
						
					}else{
						
						result.addToken(t);
					}					
					
				}else{
					
					result.addToken(t);
				}

			} else {

				result.addToken(t);
			}
		}

		return result;
	}

	public static void reset() {

		lineComment = false;
		multiLineComment = false;
		tokenList = new CodexTokenList();
	}
}
