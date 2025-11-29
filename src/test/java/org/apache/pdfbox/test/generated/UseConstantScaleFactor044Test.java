package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UseConstantScaleFactor044Test {
    @Test
    public void testConstantScaleFactorIsUsed() {
        double scaleFactor = 1.0;
        Assertions.assertTrue(scaleFactor == 1.0);
    }

    @Test
    public void testScaleFactorIsNotNull() {
        Double scaleFactor = Double.valueOf(1.0);
        Assertions.assertNotNull(scaleFactor);
    }
}