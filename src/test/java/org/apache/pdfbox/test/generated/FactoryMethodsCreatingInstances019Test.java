package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FactoryMethodsCreatingInstances019Test {
    @Test
    public void testCreateBoolean() {
        Boolean value = Boolean.valueOf(true);
        Assertions.assertNotNull(value);
        Assertions.assertTrue(value);
    }
    
    @Test
    public void testCreateInteger() {
        Integer value = Integer.valueOf(10);
        Assertions.assertNotNull(value);
        Assertions.assertEquals(10, value.intValue());
    }
    
    @Test
    public void testCreateText() {
        String value = "Sample Text";
        Assertions.assertNotNull(value);
        Assertions.assertEquals("Sample Text", value);
    }
}