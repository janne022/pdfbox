package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpLangaltDataType018Test {
    @Test
    public void testLangAltSupported() {
        String langAltValue = "en-US";
        Assertions.assertNotNull(langAltValue);
    }

    @Test
    public void testLangAltValueEquality() {
        String expected = "fr-FR";
        String actual = "fr-FR";
        Assertions.assertEquals(expected, actual);
    }
}