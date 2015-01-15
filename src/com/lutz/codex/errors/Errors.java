package com.lutz.codex.errors;

public class Errors {

	public static void throwError(CodexError error) {

		System.err.println(error.getClass().getSimpleName() + ": "
				+ error.getMessage());

		for (CodexStackTraceElement sTE : error.getStackTrace()) {

			if (sTE.hasCustomMessage()) {

				System.err.println("\t" + sTE.getCustomMessage());

			} else {

				System.err.println("\terror in " + sTE.getErroredClass()
						+ " at line " + sTE.getErroredLine() + " in function "
						+ sTE.getErroredFunction());
			}
		}
	}
}
