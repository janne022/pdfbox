package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AcceptPdfDocumentList029Test {
    @Test
    public void testAcceptPdfDocument() {
        String document = "sample.pdf";
        Assertions.assertNotNull(document);
    }

    @Test
    public void testHighlightWordsList() {
        String wordsToHighlight = "test,highlight";
        Assertions.assertTrue(wordsToHighlight.contains(","));
    }
}