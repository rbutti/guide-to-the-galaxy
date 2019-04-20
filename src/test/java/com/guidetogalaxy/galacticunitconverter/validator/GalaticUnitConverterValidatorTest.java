package com.guidetogalaxy.galacticunitconverter.validator;

import org.junit.Assert;
import org.junit.Test;


public class GalaticUnitConverterValidatorTest {
    @Test
    public void testValidateRoman() throws Exception {
        Assert.assertEquals(2006 ,GalacticUnitConverterValidator.validateRoman("MMVI"));
        Assert.assertEquals(1944 ,GalacticUnitConverterValidator.validateRoman("MCMXLIV"));
        Assert.assertEquals(1000 ,GalacticUnitConverterValidator.validateRoman("M"));
        Assert.assertEquals(900 ,GalacticUnitConverterValidator.validateRoman("CM"));
        Assert.assertEquals(3 ,GalacticUnitConverterValidator.validateRoman("III"));
        Assert.assertEquals(1903 ,GalacticUnitConverterValidator.validateRoman("MCMIII"));
    }
}
