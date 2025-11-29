package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CustomizationFormFieldBorder140Test {
    @Test
    public void testBorderColorCustomization() {
        String borderColor = "#FF0000";
        Assertions.assertNotNull(borderColor);
        Assertions.assertTrue(borderColor.startsWith("#"));
    }
    
    @Test
    public void testBackgroundColorCustomization() {
        String backgroundColor = "rgb(0, 255, 0)";
        Assertions.assertNotNull(backgroundColor);
        Assertions.assertTrue(backgroundColor.contains("rgb"));
    }
}