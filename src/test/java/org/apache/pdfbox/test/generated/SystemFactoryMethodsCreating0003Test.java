package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SystemFactoryMethodsCreating0003Test {

    @Test
    public void testBooleanFactoryMethod() {
        Boolean value = Boolean.TRUE;
        Assertions.assertNotNull(value);
        Assertions.assertTrue(value);
    }

    @Test
    public void testIntegerFactoryMethod() {
        Integer value = Integer.valueOf(10);
        Assertions.assertNotNull(value);
        Assertions.assertEquals(10, value.intValue());
    }

    @Test
    public void testTextFactoryMethod() {
        String value = "simple text";
        Assertions.assertNotNull(value);
        Assertions.assertEquals("simple text", value);
    }
}