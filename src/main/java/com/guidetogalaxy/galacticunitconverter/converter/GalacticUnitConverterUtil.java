package com.guidetogalaxy.galacticunitconverter.converter;

import java.util.HashSet;
import java.util.Set;

import com.guidetogalaxy.galacticunitconverter.domain.RomanNumber;

/**
 * Converter utility class for GalacticUnitConverter application
 * 
 * @author Ravikiran Butti
 *
 */
public final class GalacticUnitConverterUtil {

	private GalacticUnitConverterUtil() {

	}

	/**
	 * The symbols "I", "X", "C", and "M" can be repeated three times in succession,
	 * but no more
	 */
	private static final Set<Character> THREE_TIMES_REPEATED_CHARACTERS = new HashSet<>();

	/**
	 * "V", "L", and "D" can never be subtracted.
	 */
	private static final Set<Character> NOT_SUBTRACTED_CHARACTERS = new HashSet<>();

	static {

		// Req: The symbols "I", "X", "C", and "M" can be repeated three times in
		// succession
		THREE_TIMES_REPEATED_CHARACTERS.add('I');
		THREE_TIMES_REPEATED_CHARACTERS.add('X');
		THREE_TIMES_REPEATED_CHARACTERS.add('C');
		THREE_TIMES_REPEATED_CHARACTERS.add('M');

		// Req: "V", "L", and "D" can never be subtracted.
		NOT_SUBTRACTED_CHARACTERS.add('V');
		NOT_SUBTRACTED_CHARACTERS.add('L');
		NOT_SUBTRACTED_CHARACTERS.add('D');
		NOT_SUBTRACTED_CHARACTERS.add('M');
	}

	/**
	 * Validate the input RomanNumber and return it's integer value if valid, else
	 * return -1
	 */
	public static int convertRomanToArabic(String romanNumber) throws Exception {

		char[] charArray = romanNumber.toCharArray();
		char previousChar = ' ';

		int total = 0;
		int repeatCount = 1;
		int prevOrdinal = Integer.MAX_VALUE;

		for (int i = 0; i < charArray.length; i++) {

			char curChar = charArray[i];
			int curNumberVal = RomanNumber.valueOf(String.valueOf(curChar)).getValue();
			int curOrdinal = RomanNumber.valueOf(String.valueOf(curChar)).ordinal();

			if (previousChar != ' ') {
				prevOrdinal = RomanNumber.valueOf(String.valueOf(previousChar)).ordinal();
			}

			if (curChar == previousChar && ++repeatCount < 4 && THREE_TIMES_REPEATED_CHARACTERS.contains(curChar)) {

				// Req: The symbols "I", "X", "C", and "M" can be repeated three times in
				// succession, but no more.
				total += curNumberVal;

			} else if (repeatCount > 3) {

				// Error: The symbols "I", "X", "C", and "M" can never be repeated more than
				// three times in succession
				total = -1;
			} else if (curChar == previousChar && !THREE_TIMES_REPEATED_CHARACTERS.contains(curChar)) {

				// Error: "D", "L", and "V" can never be repeated.
				total = -1;
			} else if (prevOrdinal < curOrdinal && !NOT_SUBTRACTED_CHARACTERS.contains(previousChar)) {

				int prevValue = RomanNumber.valueOf(String.valueOf(previousChar)).getValue();
				if (prevOrdinal + 2 >= curOrdinal) {

					// Req: "I" can be subtracted from "V" and "X" only. "X" can be subtracted from
					// "L" and "C" only. "C" can be subtracted from "D" and "M" only.
					total += curNumberVal - (2 * prevValue);
					repeatCount = 1;
				} else {

					// Error: "I" can be subtracted from "V" and "X" only. "X" can be subtracted
					// from
					// "L" and "C" only. "C" can be subtracted from "D" and "M" only.
					total = -1;
				}
			} else if (prevOrdinal < curOrdinal && NOT_SUBTRACTED_CHARACTERS.contains(previousChar)) {

				// Error: "V", "L", and "D" can never be subtracted
				total = -1;
			} else {

				// First Character
				repeatCount = 1;
				total += curNumberVal;
			} // End of If-else statements

			previousChar = curChar;
			if (total == -1) {
				break;
			}
		}
		return total;
	}
}
