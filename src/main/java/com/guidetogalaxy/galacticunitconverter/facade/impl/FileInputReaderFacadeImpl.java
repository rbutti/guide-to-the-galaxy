package com.guidetogalaxy.galacticunitconverter.facade.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.guidetogalaxy.galacticunitconverter.facade.InputReaderFacade;

public class FileInputReaderFacadeImpl implements InputReaderFacade {

	/**
     * reads and process the input file
     *
     * @param fileName
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
