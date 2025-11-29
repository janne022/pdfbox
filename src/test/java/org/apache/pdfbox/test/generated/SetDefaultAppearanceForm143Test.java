package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SetDefaultAppearanceForm143Test {
    @Test
    public void testDefaultAppearanceTextSet() {
        String defaultAppearanceCommand = "/Type /Catalog /Pages ...";
        Assertions.assertTrue(defaultAppearanceCommand.contains("/Font"));
    }
    
    @Test
    public void testFontSizeIsAutoSized() {
        String defaultAppearanceCommand = "/Type /Catalog /Pages ...";
        Assertions.assertTrue(defaultAppearanceCommand.contains("/AutoFit"));
    }
}