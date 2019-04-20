package com.guidetogalaxy.galacticunitconverter.facade;

import java.util.List;

/**
 * Facade class to read application input
 * 
 * @author Ravikiran Butti
 *
 */
public interface InputReaderFacade {

	/**
	 * Concrete implementation of this method should implement logic to read input
	 * from source
	 * 
	 * @param source - Source to read input
	 * @return - Read input
	 * @throws Exception - If any error occurs while reading input
	 */
	public List<String> readInput(String source) throws Exception;
}
