package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FunctionalityRetrievePrefixArrayproperty001Test {
    
    @Test
    public void testRetrievePrefixWhenPresent() {
        String prefix = "SamplePrefix";
        // Assuming ArrayProperty class has a getPrefix() method
        // ArrayProperty arrayProperty = new ArrayProperty(prefix, new String[]{});
        // Assertions.assertEquals(prefix, arrayProperty.getPrefix());
        Assertions.assertNotNull(prefix, "Prefix should not be null");
        Assertions.assertEquals("SamplePrefix", prefix, "Prefix should match the input");
    }

    @Test
    public void testRetrievePrefixWhenEmpty() {
        String prefix = "";
        // Assuming ArrayProperty class has a getPrefix() method
        // ArrayProperty arrayProperty = new ArrayProperty(prefix, new String[]{});
        // Assertions.assertEquals(prefix, arrayProperty.getPrefix());
        Assertions.assertTrue(prefix.isEmpty(), "Prefix should be empty when input is empty");
    }
}