package com.guidetogalaxy.galacticunitconverter.service;

import java.util.List;

import com.guidetogalaxy.galacticunitconverter.domain.ConverterResult;

/**
 * Service interface of Galactic Unit Converter
 * 
 * @author Ravikiran Butti
 *
 */
public interface GalacticUnitConverterService {

	/**
	 * Concrete implementation of this method should process the input lines and
	 * return the results
	 * 
	 * @param inputLines - inputs to process
	 * @return - Results
	 * @throws Exception - exception thrown if there is an error
	 */
	public ConverterResult processInput(List<String> inputLines) throws Exception;
}
