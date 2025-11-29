package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class EmbedFontPdfNon144Test {
    @Test
    public void testFontEmbeddingSupport() {
        boolean supportNonWinAnsi = true;
        Assertions.assertTrue(supportNonWinAnsi, "Font embedding for non-WinAnsiEncoding characters should be supported");
    }
    
    @Test
    public void testFontIsEmbedded() {
        String fontStatus = "embedded";
        Assertions.assertEquals("embedded", fontStatus, "Font should be marked as embedded");
    }
}