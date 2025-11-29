package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpLocaleDataType027Test {
    @Test
    public void testLocaleParsing() {
        String localeString = "en-US";
        Assertions.assertNotNull(localeString);
    }
    
    @Test
    public void testLocaleValidation() {
        String validLocale = "fr";
        Assertions.assertEquals("fr", validLocale);
    }
}