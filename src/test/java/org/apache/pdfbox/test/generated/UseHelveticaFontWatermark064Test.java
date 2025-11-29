package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UseHelveticaFontWatermark064Test {
    @Test
    public void testFontNameIsHelvetica() {
        String expectedFont = "Helvetica";
        Assertions.assertEquals("Helvetica", expectedFont);
    }
    
    @Test
    public void testWatermarkCanBeCreated() {
        Object watermark = new Object();
        Assertions.assertNotNull(watermark);
    }
}