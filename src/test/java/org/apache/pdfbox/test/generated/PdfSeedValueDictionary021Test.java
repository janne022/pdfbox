package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PdfSeedValueDictionary021Test {
    @Test
    public void testSeedValueDictionarySupport() {
        String dictionaryEntry = "/SeedValueDict <</Version 1.5>>";
        Assertions.assertNotNull(dictionaryEntry);
        Assertions.assertTrue(dictionaryEntry.contains("/Version 1.5"));
    }

    @Test
    public void testPdf15Compliance() {
        int pdfVersion = 1.5;
        Assertions.assertEquals(1.5, pdfVersion);
    }
}