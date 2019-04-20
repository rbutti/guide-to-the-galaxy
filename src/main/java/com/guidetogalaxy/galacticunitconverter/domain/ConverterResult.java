package com.guidetogalaxy.galacticunitconverter.domain;

import java.util.ArrayList;
import java.util.List;

public class ConverterResult {

	private List<String> inputQuestions;
	private List<String> outputValues;

	public ConverterResult() {
		super();
		inputQuestions = new ArrayList<String>();
		outputValues = new ArrayList<String>();
	}

	public List<String> getInputQuestions() {
		return inputQuestions;
	}

	public void addInputQuestion(String inputQuestion) {
		this.inputQuestions.add(inputQuestion);
	}

	public List<String> getOutputValues() {
		return outputValues;
	}

	public void addOutputValue(String outputValue) {
		this.outputValues.add(outputValue);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inputQuestions == null) ? 0 : inputQuestions.hashCode());
		result = prime * result + ((outputValues == null) ? 0 : outputValues.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConverterResult other = (ConverterResult) obj;
		if (inputQuestions == null) {
			if (other.inputQuestions != null)
				return false;
		} else if (!inputQuestions.equals(other.inputQuestions))
			return false;
		if (outputValues == null) {
			if (other.outputValues != null)
				return false;
		} else if (!outputValues.equals(other.outputValues))
			return false;
		return true;
	}

}
