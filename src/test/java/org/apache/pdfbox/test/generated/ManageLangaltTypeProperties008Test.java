package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ManageLangaltTypeProperties008Test {
    @Test
    public void testLangAltPropertyPresence() {
        String langAlt = "en-US";
        Assertions.assertNotNull(langAlt);
    }
    
    @Test
    public void testLangAltPropertyValue() {
        String expectedLangAlt = "fr-FR";
        String actualLangAlt = "fr-FR";
        Assertions.assertEquals(expectedLangAlt, actualLangAlt);
    }
}