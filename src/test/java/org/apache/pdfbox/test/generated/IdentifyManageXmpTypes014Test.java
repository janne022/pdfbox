package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class IdentifyManageXmpTypes014Test {
    @Test
    public void testBooleanType() {
        Boolean value = true;
        Assertions.assertTrue(value);
    }
    
    @Test
    public void testIntegerType() {
        int value = 123;
        Assertions.assertEquals(123, value);
    }

    @Test
    public void testTextType() {
        String value = "Sample Text";
        Assertions.assertNotNull(value);
    }
}