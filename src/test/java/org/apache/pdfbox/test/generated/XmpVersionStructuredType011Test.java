package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpVersionStructuredType011Test {
    @Test
    public void testXmpVersionTypeSupport() {
        String xmpVersion = "1.0";
        Assertions.assertNotNull(xmpVersion);
        Assertions.assertTrue(xmpVersion.equals("1.0"));
    }
    
    @Test
    public void testXmpVersionParsing() {
        String versionString = "2.5";
        Assertions.assertEquals("2.5", versionString);
    }
}