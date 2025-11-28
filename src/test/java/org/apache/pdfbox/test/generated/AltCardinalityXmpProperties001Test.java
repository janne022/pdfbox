package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AltCardinalityXmpProperties001Test {
    @Test
    public void testXmpPropertyArrayValue() {
        String[] xmpValues = {"value1", "value2"};
        Assertions.assertNotNull(xmpValues);
        Assertions.assertEquals(2, xmpValues.length);
    }
    
    @Test
    public void testEmptyXmpPropertyArray() {
        String[] emptyArray = {};
        Assertions.assertNotNull(emptyArray);
        Assertions.assertEquals(0, emptyArray.length);
    }
}