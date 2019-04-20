package com.guidetogalaxy.galacticunitconverter.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.guidetogalaxy.galacticunitconverter.constant.Constant;
import com.guidetogalaxy.galacticunitconverter.domain.ConverterResult;
import com.guidetogalaxy.galacticunitconverter.domain.RomanNumber;
import com.guidetogalaxy.galacticunitconverter.service.GalacticUnitConverterService;
import com.guidetogalaxy.galacticunitconverter.validator.GalacticUnitConverterValidator;

/**
 * An implementation of {@linkplain GalacticUnitConverterService} to process the
 * application inputs
 * 
 * @author Ravikiran Butti
 *
 */
public class GalacticUnitConverterServiceImpl implements GalacticUnitConverterService {

	private Map<String, RomanNumber> unitToRomanMapping = new HashMap<>();
	private Map<String, Double> unitsToCreditMapping = new HashMap<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.guidetogalaxy.galacticunitconverter.service.GalacticUnitConverterService#
	 * processInput(java.util.List)
	 */
	public ConverterResult processInput(List<String> inputLines) throws Exception {

		ConverterResult result = new ConverterResult();
		inputLines.stream().forEach(line -> {
			// split by whitespace
			String[] inputs = line.split(" ");

			switch (identifyOperations(line)) {
			case 1:
				// converts galatic units to credits
				result.addInputQuestion(line);
				result.addOutputValue(
						String.valueOf(generateCreditValue(Arrays.copyOfRange(inputs, 4, inputs.length - 1))));
				break;
			case 2:
				// convert galatic units to value
				result.addInputQuestion(line);
				result.addOutputValue(String
						.valueOf(generateGalacticUnitToNumericValue(Arrays.copyOfRange(inputs, 3, inputs.length - 1))));

				break;
			case 3:
				// map galatic units to roman numerals
				mapInterGalacticToRomanUnits(inputs);
				break;
			case 4:
				// map galatic units to creditss
				try {
					generateObjectSoldPerUnitMap(inputs);
				} catch (Exception e) {
					throw new RuntimeException("Failed to Map the Galatic Units to Credits", e);
				}
				break;
			case 5:
				// Invalid input
				result.addInputQuestion(line);
				result.addOutputValue(Constant.NO_IDEA);
			}

		});

		return result;
	}

	/**
	 * Private method to identify the operation based on input
	 * @param line : Input code
	 * @return : operation number
	 */
	private int identifyOperations(String line) {

		if (line.startsWith(Constant.HOW_MANY_CREDITS_IS)) {

			// converts galatic units to credits
			return 1;
		} else if (line.startsWith(Constant.HOW_MUCH_IS)) {
			// convert galatic units to value
			return 2;
		} else if (line.contains(Constant.IS) && !line.contains(Constant.CREDITS)) {
			// map galatic units to roman numerals

			return 3;
		} else if (line.contains(Constant.IS) && line.contains(Constant.CREDITS)) {
			// map galatic units to creditss

			return 4;
		} else {
			// Invalid input
			return 5;
		}
	}

	/**
	 * Receives inputs of the form "glob is I" maps the alien language to the
	 * RomanType
	 *
	 * @param arr
	 */
	private void mapInterGalacticToRomanUnits(String[] arr) {
		try {
			unitToRomanMapping.put(arr[0], RomanNumber.valueOf(arr[2]));
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
			RomanNumber romanNumbers = unitToRomanMapping.get(arr[i]);
			if (romanNumbers != null) {
				romanNumeral.append(romanNumbers.getDisplayValue());
			} else {
				break;
			}
		}

		// example romanNumbers is MMVI
		int value = GalacticUnitConverterValidator.validateRoman(romanNumeral.toString());
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

			return GalacticUnitConverterValidator.validateRoman(romanNumeral);
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
			RomanNumber romanNumbers = unitToRomanMapping.get(arr[i]);
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
