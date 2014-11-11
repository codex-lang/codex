package com.lutz.codex.interpreter;

import java.io.File;
import java.util.Scanner;

import com.lutz.codex.syntax.TokenInfo;
import com.lutz.codex.syntax.Tokens;

public class CodexInterpreter {

	public static CodexTokenList parseFileToTokenList(File f) {

		String fileContents = "";

		try {

			Scanner fileReader = new Scanner(f);

			while (fileReader.hasNextLine()) {

				String value = fileReader.nextLine();
				
				if(value.contentEquals("") || value == null){
					
					value = "\n";
				}
				
				fileContents += value;
			}

			fileReader.close();

			CodexTokenList tokenList = new CodexTokenList();

			char[] chars = fileContents.toCharArray();

			String currentReading = "";

			String currentReserved = "";

			TokenInfo savedPrevToken = null;

			int currentIndex = 0;

			while (currentIndex < chars.length) {

				char current = chars[currentIndex];

				if (!Tokens.isReserved(current)
						&& !Character.isWhitespace(current)) {

					currentReserved = currentReserved.trim();

					if (!currentReserved.contentEquals("")) {

						TokenInfo ti = Tokens
								.parseReservedCharToken(currentReserved);

						if (ti.getToken() != Tokens.UNKNOWN) {

							tokenList.addToken(ti);

							currentReserved = "";

						} else {

							tokenList.addToken(savedPrevToken);

							currentReserved = Character.toString(current);
						}
					}

					currentReading += current;

				} else {

					currentReading = currentReading.trim();

					if (!currentReading.contentEquals("")) {

						tokenList.addToken(new TokenInfo(Tokens.STRING_VALUE,
								currentReading));

						currentReading = "";
					}

					if (!Character.isWhitespace(current)) {

						currentReserved += current;

						TokenInfo toSave = Tokens
								.parseReservedCharToken(currentReserved.trim());

						if (toSave.getToken() != Tokens.UNKNOWN) {

							savedPrevToken = toSave;
						}
					}
				}

				currentIndex++;
			}

			return tokenList;

		} catch (Exception e) {

			e.printStackTrace();

			return null;
		}
	}
}
