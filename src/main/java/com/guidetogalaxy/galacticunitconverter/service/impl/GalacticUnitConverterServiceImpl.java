package com.guidetogalaxy.galacticunitconverter.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guidetogalaxy.galacticunitconverter.constant.Constant;
import com.guidetogalaxy.galacticunitconverter.domain.ConverterResult;
import com.guidetogalaxy.galacticunitconverter.domain.RomanNumbers;
import com.guidetogalaxy.galacticunitconverter.service.GalacticUnitConverterService;
import com.guidetogalazy.galacticunitconverter.validator.RomanValidator;

public class GalacticUnitConverterServiceImpl implements GalacticUnitConverterService {

	private Map<String, RomanNumbers> unitToRomanMapping = new HashMap<>();
	private Map<String, Double> unitsToCreditMapping = new HashMap<>();

	/**
	 * Parses the input line by line and decides the type of request and
	 * appropriately forwards the request
	 *
	 * @param line
	 * @throws Exception
	 */
	public ConverterResult processInput(List<String> inputLines) throws Exception {

		ConverterResult result = new ConverterResult();
		inputLines.stream().forEach(line -> {
			// split by whitespace
			String[] inputs = line.split(" ");

			if (line.startsWith(Constant.HOW_MANY_CREDITS_IS)) {
				result.addInputQuestion(line);
				result.addOutputValue(
						String.valueOf(generateCreditValue(Arrays.copyOfRange(inputs, 4, inputs.length - 1))));
			} else if (line.startsWith(Constant.HOW_MUCH_IS)) {
				result.addInputQuestion(line);
				result.addOutputValue(String
						.valueOf(generateGalacticUnitToNumericValue(Arrays.copyOfRange(inputs, 3, inputs.length - 1))));
			} else if (line.contains(Constant.IS) && !line.contains(Constant.CREDITS)) {
				mapInterGalacticToRomanUnits(inputs);
			} else if (line.contains(Constant.IS) && line.contains(Constant.CREDITS)) {
				try {
					generateObjectSoldPerUnitMap(inputs);
				} catch (Exception e) {
					throw new RuntimeException("Failed to Map the Galatic Units to Credits", e);
				}
			} else {
				result.addInputQuestion(line);
				result.addOutputValue(Constant.NO_IDEA);
			}

		});

		return result;
	}

	/**
	 * Receives inputs of the form "glob is I" maps the alien language to the
	 * RomanType
	 *
	 * @param arr
	 */
	private void mapInterGalacticToRomanUnits(String[] arr) {
		try {
			unitToRomanMapping.put(arr[0], RomanNumbers.valueOf(arr[2]));
		} catch (IllegalArgumentException e) {
			System.out.println("This type of RomanNumbers is not defined, exiting the program " + e);
		}
	}

	/**
	 * Receives input of the form "glob glob Silver is 34 Credits" Creates a map of
	 * the object sold and (value/unit) returns -1 in case of a validation error
	 *
	 * @param arr
	 * @return
	 * @throws Exception
	 */
	private int generateObjectSoldPerUnitMap(String[] arr) throws Exception {
		StringBuilder romanNumeral = new StringBuilder();
		int i;
		for (i = 0; i < arr.length; i++) {
			RomanNumbers romanNumbers = unitToRomanMapping.get(arr[i]);
			if (romanNumbers != null) {
				romanNumeral.append(romanNumbers.getDisplayValue());
			} else {
				break;
			}
		}

		// example romanNumbers is MMVI
		int value = RomanValidator.validateRoman(romanNumeral.toString());
		if (value == -1) {
			return -1;
		}
		String objectName = arr[i];
		int credit = Integer.parseInt(arr[i + 2]);

		unitsToCreditMapping.put(objectName, (double) credit / value);
		return 1;
	}

	/**
	 * Receives input of the form "pish tegj glob glob" for questions like "how much
	 * is pish tegj glob glob ?" returns -1 in case of validation exception
	 *
	 * @param arr
	 * @return
	 * @throws Exception
	 */
	private int generateGalacticUnitToNumericValue(String[] arr) {

		try {
			String romanNumeral = generateRomanFromGalacticUnit(arr);

			if (romanNumeral == null) {
				return -1;
			}

			return RomanValidator.validateRoman(romanNumeral);
		} catch (Exception e) {
			return -1;
		}

	}

	/**
	 * Receives input of the form "glob prok Silver" for questions like "how many
	 * Credits is glob prok Silver ?" returns -1 in case of validation exception
	 *
	 * @param arr
	 * @return
	 * @throws Exception
	 */
	private Double generateCreditValue(String[] arr) {
		int currentValue = generateGalacticUnitToNumericValue(Arrays.copyOfRange(arr, 0, arr.length - 1));

		if (currentValue == -1) {
			return (double) -1;
		}

		return currentValue * unitsToCreditMapping.get(arr[arr.length - 1]);
	}

	/**
	 * a utils method to generate RomanNumbers string from Alien input
	 *
	 * @param arr
	 * @return
	 */
	private String generateRomanFromGalacticUnit(String[] arr) {
		StringBuilder romanNumeral = new StringBuilder();
		int i;
		for (i = 0; i < arr.length; i++) {
			RomanNumbers romanNumbers = unitToRomanMapping.get(arr[i]);
			if (romanNumbers != null) {
				romanNumeral.append(romanNumbers.getDisplayValue());
			} else {
				break;
			}
		}

		if (i != arr.length) {
			return null;
		}

		return romanNumeral.toString();
	}

}
