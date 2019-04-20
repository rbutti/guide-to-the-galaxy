package com.guidetogalaxy.galacticunitconverter.service;

import java.util.List;

import com.guidetogalaxy.galacticunitconverter.domain.ConverterResult;

public interface GalacticUnitConverterService {

	public ConverterResult processInput(List<String> inputLines) throws Exception ;
}
