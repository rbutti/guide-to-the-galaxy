package com.guidetogalaxy.galacticunitconverter.facade.impl;

import org.junit.Test;

import com.guidetogalaxy.galacticunitconverter.domain.ConverterResult;
import com.guidetogalaxy.galacticunitconverter.facade.OutputWriterFacade;

public class ConsoleOutputWriterFacadeImplTest {
	
	OutputWriterFacade writeOutput = new ConsoleOutputWriterFacadeImpl();


	  @Test
	    public void testProcessOut_ValidResult(){
	       ConverterResult result = new ConverterResult();
	       result.addInputQuestion("how many Credits is glob prok Silver ?");
	       result.addOutputValue("42");
	       writeOutput.processOutput(result);
	    }
	  
	  @Test
	    public void testProcessOut_EmptyResult(){
	       ConverterResult result = new ConverterResult();
	       writeOutput.processOutput(result);
	    }
}
