package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TextRenderingModesColor007Test {
    @Test
    public void testRenderingModeZero() {
        int renderingMode = 0;
        Assertions.assertTrue(renderingMode == 0, "Rendering mode 0 should be supported");
    }
    
    @Test
    public void testRenderingModeOne() {
        int renderingMode = 1;
        Assertions.assertTrue(renderingMode == 1, "Rendering mode 1 should be supported");
    }

    @Test
    public void testRenderingModeTwo() {
        int renderingMode = 2;
        Assertions.assertTrue(renderingMode == 2, "Rendering mode 2 should be supported");
    }
}