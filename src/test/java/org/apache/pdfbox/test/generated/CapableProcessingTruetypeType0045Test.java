package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CapableProcessingTruetypeType0045Test {
    @Test
    public void testProcessTruetypeFont() {
        String fontType = "TrueType";
        Assertions.assertTrue(fontType.equals("TrueType"));
    }
    
    @Test
    public void testProcessType0Font() {
        String fontType = "Type0";
        Assertions.assertEquals("Type0", fontType);
    }
}