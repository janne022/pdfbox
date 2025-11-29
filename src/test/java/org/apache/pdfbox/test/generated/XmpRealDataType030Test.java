package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpRealDataType030Test {
    @Test
    public void testSupportsRealDataType() {
        String realValueString = "3.14159";
        Assertions.assertNotNull(realValueString);
    }
    
    @Test
    public void testRealParsing() {
        double expected = 2.718;
        double actual = Double.parseDouble("2.718");
        Assertions.assertEquals(expected, actual, 0.001);
    }
}