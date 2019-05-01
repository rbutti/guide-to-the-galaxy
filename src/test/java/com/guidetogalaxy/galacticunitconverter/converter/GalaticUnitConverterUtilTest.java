package com.guidetogalaxy.galacticunitconverter.converter;

import org.junit.Assert;
import org.junit.Test;

import com.guidetogalaxy.galacticunitconverter.converter.GalacticUnitConverterUtil;


public class GalaticUnitConverterUtilTest {
	
    @Test
    public void testValidateRoman() throws Exception {
    	
        Assert.assertEquals(2006 ,GalacticUnitConverterUtil.romanToInteger("MMVI"));
        Assert.assertEquals(1944 ,GalacticUnitConverterUtil.romanToInteger("MCMXLIV"));
        Assert.assertEquals(1000 ,GalacticUnitConverterUtil.romanToInteger("M"));
        Assert.assertEquals(900 ,GalacticUnitConverterUtil.romanToInteger("CM"));
        Assert.assertEquals(3 ,GalacticUnitConverterUtil.romanToInteger("III"));
        Assert.assertEquals(1903 ,GalacticUnitConverterUtil.romanToInteger("MCMIII"));
    }
}
