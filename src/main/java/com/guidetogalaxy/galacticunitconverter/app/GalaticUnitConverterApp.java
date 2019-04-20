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
 * @program: guide-to-the-galaxy
 * @description: GalaticUnitConverterApp
 * @author: smallsoup
 * @create: 2018-11-15 23:35
 **/

public class GalaticUnitConverterApp {

	public static void main(String[] args) {

		InputReaderFacade readInput = new FileInputReaderFacadeImpl();
		GalacticUnitConverterService service = new GalacticUnitConverterServiceImpl();
		OutputWriterFacade writeOutput = new ConsoleOutputWriterFacadeImpl();

		String filePath = "input.txt";

		if (args.length != 0) {
			filePath = args[0];
		}

		try {

			List<String> inputs = readInput.readInput(filePath);
			ConverterResult result = service.processInput(inputs);
			writeOutput.processOutput(result);
		} catch (Exception e) {
			System.err.println(
					"An exception has been raised, Either due to invalid input or due to reading the file, quiting the program "
							+ e);
		}
	}
}
