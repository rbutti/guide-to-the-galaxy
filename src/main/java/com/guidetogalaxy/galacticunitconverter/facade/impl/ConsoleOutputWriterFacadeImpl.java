package com.guidetogalaxy.galacticunitconverter.facade.impl;

import com.guidetogalaxy.galacticunitconverter.constant.Constant;
import com.guidetogalaxy.galacticunitconverter.domain.ConverterResult;
import com.guidetogalaxy.galacticunitconverter.facade.OutputWriterFacade;

/**
 * @program: guide-to-the-galaxy
 * @description: ConsoleOutputWriterFacadeImpl
 * @author: smallsoup
 * @create: 2018-11-15 23:38
 **/

public class ConsoleOutputWriterFacadeImpl implements OutputWriterFacade {

	/**
	 * Display the output based on the lists
	 */
	public void processOutput(ConverterResult converterResult) {

		// input nums equals output nums
		for (int i = 0; i < converterResult.getInputQuestions().size(); i++) {

			// result to console
			StringBuilder result = new StringBuilder();

			String question = converterResult.getInputQuestions().get(i);
			String output = converterResult.getOutputValues().get(i);

			if (output == Constant.NO_IDEA || Double.valueOf(output).intValue() == -1) {
				result.append(Constant.NO_IDEA);
			} else {
				if (question.startsWith(Constant.HOW_MUCH_IS)) {
					result.append(question.substring(Constant.HOW_MUCH_IS.length(), question.length() - 1).trim());
					result.append(Constant.IS);
					result.append(Double.valueOf(output).intValue());
				} else if (question.startsWith(Constant.HOW_MANY_CREDITS_IS)) {
					result.append(
							question.substring(Constant.HOW_MANY_CREDITS_IS.length(), question.length() - 1).trim());
					result.append(Constant.IS);
					result.append(Double.valueOf(output).intValue());
					result.append(Constant.CREDITS);
				} else {
					result.append(Constant.NO_IDEA);
				}
			}

			System.out.println(result.toString());
		}
	}

}
