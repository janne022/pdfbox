package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FactoryMethodsCreatingInstances019Test {
    @Test
    public void testBooleanFactory() {
        Boolean value = Boolean.TRUE;
        Assertions.assertNotNull(value);
        Assertions.assertEquals(true, value);
    }

    @Test
    public void testIntegerFactory() {
        Integer value = Integer.valueOf(100);
        Assertions.assertNotNull(value);
        Assertions.assertEquals(100, value.intValue());
    }

    @Test
    public void testTextFactory() {
        String value = "Hello";
        Assertions.assertNotNull(value);
        Assertions.assertEquals("Hello", value);
    }
}