package com.guidetogalaxy.galacticunitconverter.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.guidetogalaxy.galacticunitconverter.domain.ConverterResult;
import com.guidetogalaxy.galacticunitconverter.service.GalacticUnitConverterService;

public class GalacticUnitConverterServiceImplTest {

	GalacticUnitConverterService service = new GalacticUnitConverterServiceImpl();

	@Test
	public void testProcessInput_EmptyInput() throws Exception {
		ConverterResult result = service.processInput(new ArrayList<String>());
		assertNotNull(result);
		assertEquals(0, result.getInputQuestions().size());
		assertEquals(0, result.getOutputValues().size());
	}

	@Test
	public void testProcessInput_NullInput() throws Exception {
		ConverterResult result = service.processInput(null);
		assertNotNull(result);

		assertEquals(0, result.getInputQuestions().size());
		assertEquals(0, result.getOutputValues().size());
	}

	@Test
	public void testProcessInput_ValidInput() throws Exception {
		List<String> input = new ArrayList<String>();
		input.add("glob is I");
		input.add("prok is V");
		input.add("pish is X");
		input.add("tegj is L");
		input.add("glob glob Silver is 34 Credits");
		input.add("glob prok Gold is 57800 Credits");
		input.add("pish pish Iron is 3910 Credits");
		input.add("how much is pish tegj glob glob ?");
		input.add("how many Credits is glob prok Silver ?");
		input.add("how many Credits is glob prok Gold ?");
		input.add("how many Credits is glob prok Iron ?");
		input.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
		ConverterResult result = service.processInput(input);
		assertNotNull(result);
		assertEquals(5, result.getInputQuestions().size());
		assertEquals(5, result.getOutputValues().size());

		assertEquals("42", result.getOutputValues().get(0));
		assertEquals("68.0", result.getOutputValues().get(1));
		assertEquals("57800.0", result.getOutputValues().get(2));
		assertEquals("782.0", result.getOutputValues().get(3));
		assertEquals("I have no idea what you are talking about", result.getOutputValues().get(4));
	}
}
