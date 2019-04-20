package com.guidetogalaxy.galacticunitconverter.facade.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.guidetogalaxy.galacticunitconverter.facade.InputReaderFacade;

/**
 * An implementation of {@linkplain InputReaderFacade} to read inputs from a
 * file
 * 
 * @author Ravikiran Butti
 *
 */
public class FileInputReaderFacadeImpl implements InputReaderFacade {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.guidetogalaxy.galacticunitconverter.facade.InputReaderFacade#readInput(
	 * java.lang.String)
	 */
	public List<String> readInput(String fileName) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		List<String> inputQuestions = new ArrayList<String>();
		try {
			String line;
			while ((line = br.readLine()) != null) {
				inputQuestions.add(line.trim());
			}

		} catch (IOException e) {
			System.err.println("Input file not found exception " + e);
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return inputQuestions;
	}
}
