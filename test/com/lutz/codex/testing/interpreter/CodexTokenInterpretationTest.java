package com.lutz.codex.testing.interpreter;

import com.lutz.codex.interpreter.CodexInterpreter;
import com.lutz.codex.interpreter.CodexTokenList;
import com.lutz.codex.syntax.TokenInfo;
import com.lutz.codex.syntax.Tokens;
import com.lutz.codex.testing.CodexTest;
import com.lutz.codex.testing.CodexTester;

public class CodexTokenInterpretationTest extends CodexTest {

	@Override
	public void runTest() {

		CodexTokenList tokens = CodexInterpreter
				.parseFileToTokenList(CodexTester
						.getTestingFile("token-interp-test"));
		tokens = CodexInterpreter.parseSecondLevel(tokens);

		System.out.println("----------------------------------------");

		for (TokenInfo t : tokens) {

			System.out.print("|| "
					+ Tokens.getNameForToken(t.getToken()).toUpperCase() + ":"
					+ t.getTokenData() + "\n");
		}
	}
}
