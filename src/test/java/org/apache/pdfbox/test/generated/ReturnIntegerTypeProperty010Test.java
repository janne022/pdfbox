package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReturnIntegerTypeProperty010Test {

    @Test
    public void testIntegerAsStringReturn() {
        Integer intValue = 123;
        String stringValue = String.valueOf(intValue);
        assertNotNull(stringValue);
        assertEquals("123", stringValue);
        assertEquals(String.class, stringValue.getClass());
    }

    @Test
    public void testIntegerAsObjectReturn() {
        Integer intValue = 456;
        assertNotNull(intValue);
        assertEquals(Integer.class, intValue.getClass());
    }

    @Test
    public void testZeroAsInteger() {
        Integer intValue = 0;
        String stringValue = String.valueOf(intValue);
        assertNotNull(stringValue);
        assertEquals("0", stringValue);
        assertEquals(Integer.class, intValue.getClass());
    }
}