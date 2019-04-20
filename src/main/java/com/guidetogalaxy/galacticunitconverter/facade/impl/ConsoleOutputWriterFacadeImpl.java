package com.guidetogalaxy.galacticunitconverter.facade.impl;

import com.guidetogalaxy.galacticunitconverter.constant.Constant;
import com.guidetogalaxy.galacticunitconverter.domain.ConverterResult;
import com.guidetogalaxy.galacticunitconverter.facade.OutputWriterFacade;

/**
 * An implementation of {@linkplain OutputWriterFacade} to write result to
 * console
 * 
 * @author Ravikiran Butti
 *
 */
public class ConsoleOutputWriterFacadeImpl implements OutputWriterFacade {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.guidetogalaxy.galacticunitconverter.facade.OutputWriterFacade#
	 * processOutput(com.guidetogalaxy.galacticunitconverter.domain.ConverterResult)
	 */
	public void processOutput(ConverterResult converterResult) {

		// input nums equals output nums
		for (int i = 0; i < converterResult.getInputQuestions().size(); i++) {

			// result to console
			StringBuilder result = new StringBuilder();

			String question = converterResult.getInputQuestions().get(i);
			String output = converterResult.getOutputValues().get(i);

			if (output == Constant.NO_IDEA || Double.valueOf(output).intValue() == -1) {
				// invalid request
				result.append(Constant.NO_IDEA);
			} else {
				if (question.startsWith(Constant.HOW_MUCH_IS)) {
					// results of value of the galactic units
					result.append(question.substring(Constant.HOW_MUCH_IS.length(), question.length() - 1).trim());
					result.append(Constant.IS);
					result.append(Double.valueOf(output).intValue());
				} else if (question.startsWith(Constant.HOW_MANY_CREDITS_IS)) {
					// results of credit of the galactic units
					result.append(
							question.substring(Constant.HOW_MANY_CREDITS_IS.length(), question.length() - 1).trim());
					result.append(Constant.IS);
					result.append(Double.valueOf(output).intValue());
					result.append(Constant.CREDITS);
				} else {
					// invalid request
					result.append(Constant.NO_IDEA);
				}
			}

			System.out.println(result.toString());
		}
	}

}
