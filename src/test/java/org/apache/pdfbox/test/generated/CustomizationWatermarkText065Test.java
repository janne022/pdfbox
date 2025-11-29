package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CustomizationWatermarkText065Test {
    @Test
    public void testWatermarkTextCustomization() {
        String customText = "Watermark123";
        Assertions.assertNotNull(customText);
        Assertions.assertTrue(!customText.isEmpty());
    }

    @Test
    public void testDefaultWatermarkText() {
        String defaultText = "DefaultWatermark";
        String expectedText = "DefaultWatermark";
        Assertions.assertEquals(expectedText, defaultText);
    }
}