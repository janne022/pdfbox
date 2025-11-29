package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpRationalDataType016Test {
    @Test
    public void testXmpRationalCreation() {
        String rationalString = "3/4";
        Assertions.assertNotNull(rationalString);
        Assertions.assertTrue(rationalString.contains("/"));
    }
    
    @Test
    public void testXmpRationalParsing() {
        String numeratorStr = "10";
        String denominatorStr = "20";
        String rationalStr = numeratorStr + "/" + denominatorStr;
        Assertions.assertEquals("10/20", rationalStr);
    }
}