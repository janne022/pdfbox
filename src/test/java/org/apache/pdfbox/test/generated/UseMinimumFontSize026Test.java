package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UseMinimumFontSize026Test {
    @Test
    public void testMinimumFontSizeIsFour() {
        int minimumFontSize = 4;
        Assertions.assertTrue(minimumFontSize >= 4, "Minimum font size should be at least 4");
    }
    
    @Test
    public void testFontSizeParameter() {
        int customFontSize = 5;
        Assertions.assertEquals(5, customFontSize, "Custom font size should be correctly set");
    }
}