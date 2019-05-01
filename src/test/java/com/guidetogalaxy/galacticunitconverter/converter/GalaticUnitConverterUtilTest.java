package com.guidetogalaxy.galacticunitconverter.converter;

import org.junit.Assert;
import org.junit.Test;

import com.guidetogalaxy.galacticunitconverter.converter.GalacticUnitConverterUtil;


public class GalaticUnitConverterUtilTest {
	
    @Test
    public void testValidateRoman() throws Exception {
    	
        Assert.assertEquals(2006 ,GalacticUnitConverterUtil.convertRomanToArabic("MMVI"));
        Assert.assertEquals(1944 ,GalacticUnitConverterUtil.convertRomanToArabic("MCMXLIV"));
        Assert.assertEquals(1000 ,GalacticUnitConverterUtil.convertRomanToArabic("M"));
        Assert.assertEquals(900 ,GalacticUnitConverterUtil.convertRomanToArabic("CM"));
        Assert.assertEquals(3 ,GalacticUnitConverterUtil.convertRomanToArabic("III"));
        Assert.assertEquals(1903 ,GalacticUnitConverterUtil.convertRomanToArabic("MCMIII"));
    }
}
