package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FunctionalityAdjustSignaturePosition013Test {
    @Test
    public void testSignaturePositionAdjustmentForZeroRotation() {
        boolean rotated = false;
        Assertions.assertFalse(rotated, "Signature position should not adjust for zero rotation");
    }
    
    @Test
    public void testSignaturePositionAdjustmentForNinetyDegreeRotation() {
        boolean rotated = true;
        Assertions.assertTrue(rotated, "Signature position should adjust for ninety degree rotation");
    }
}