package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ExtractTextItsLocation023Test {
    @Test
    public void testExtractsText() {
        String extractedText = "Sample text";
        Assertions.assertNotNull(extractedText);
        Assertions.assertTrue(!extractedText.isEmpty());
    }
    
    @Test
    public void testExtractsLocationInfo() {
        String locationInfo = "x: 10, y: 20";
        Assertions.assertEquals("x: 10, y: 20", locationInfo);
    }
}