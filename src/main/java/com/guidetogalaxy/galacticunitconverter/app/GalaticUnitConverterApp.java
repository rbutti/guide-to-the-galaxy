package com.guidetogalaxy.galacticunitconverter.app;

import java.util.List;

import com.guidetogalaxy.galacticunitconverter.domain.ConverterResult;
import com.guidetogalaxy.galacticunitconverter.facade.InputReaderFacade;
import com.guidetogalaxy.galacticunitconverter.facade.OutputWriterFacade;
import com.guidetogalaxy.galacticunitconverter.facade.impl.ConsoleOutputWriterFacadeImpl;
import com.guidetogalaxy.galacticunitconverter.facade.impl.FileInputReaderFacadeImpl;
import com.guidetogalaxy.galacticunitconverter.service.GalacticUnitConverterService;
import com.guidetogalaxy.galacticunitconverter.service.impl.GalacticUnitConverterServiceImpl;

/**
 * Entry class for the Application
 * 
 * @author Ravikiran Butti
 *
 */
public class GalaticUnitConverterApp {

	public static void main(String[] args) {

		InputReaderFacade readInput = new FileInputReaderFacadeImpl();
		GalacticUnitConverterService service = new GalacticUnitConverterServiceImpl();
		OutputWriterFacade writeOutput = new ConsoleOutputWriterFacadeImpl();

		String filePath = "input.txt";

		//If an input file is provided as command line argument use it
		if (args.length != 0) {
			filePath = args[0];
		}

		try {

			//Read inputs
			List<String> inputs = readInput.readInput(filePath);
			
			//process inputs
			ConverterResult result = service.processInput(inputs);
			
			//write output
			writeOutput.processOutput(result);
		} catch (Exception e) {
			System.err.println(
					"An exception has been raised, Either due to invalid input or due to reading the file, quiting the program "
							+ e);
		}
	}
}
