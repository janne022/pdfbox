package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SimpleCardinalityXmpProperties004Test {
    @Test
    public void testSimpleStringProperty() {
        String propertyValue = "simpleValue";
        Assertions.assertNotNull(propertyValue);
        Assertions.assertEquals("simpleValue", propertyValue);
    }
    
    @Test
    public void testNonArrayProperty() {
        String expected = "expectedString";
        String actual = "expectedString";
        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(expected.equals(actual));
    }
}