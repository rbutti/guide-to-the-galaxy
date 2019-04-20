package com.guidetogalaxy.galacticunitconverter.facade;

import com.guidetogalaxy.galacticunitconverter.domain.ConverterResult;

/**
 * Facade class to write application output
 * 
 * @author Ravikiran Butti
 *
 */
public interface OutputWriterFacade {

	/**
	 * Concrete implementation of this method should write the output to a sink
	 * 
	 * @param result - Output to be written
	 */
	public void processOutput(ConverterResult result);
}
