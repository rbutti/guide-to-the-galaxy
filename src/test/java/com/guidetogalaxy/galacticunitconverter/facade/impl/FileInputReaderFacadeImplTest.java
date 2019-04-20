package com.guidetogalaxy.galacticunitconverter.facade.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import com.guidetogalaxy.galacticunitconverter.facade.InputReaderFacade;

public class FileInputReaderFacadeImplTest {

	InputReaderFacade readInput = new FileInputReaderFacadeImpl();

	@Test
	public void testReadInput_ValidSource() throws Exception {
		List<String> result = readInput.readInput("input.txt");
		assertNotNull(result);
		assertEquals(12, result.size());
		assertEquals("glob is I", result.get(0));
		assertEquals("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?", result.get(11));
	}

	@Test(expected = FileNotFoundException.class)
	public void testReadInput_InvalidSource() throws Exception {
		readInput.readInput("input_invalid.txt");

	}
}
