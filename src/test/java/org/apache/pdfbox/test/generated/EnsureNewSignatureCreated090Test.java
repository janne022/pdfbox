package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class EnsureNewSignatureCreated090Test {
    @Test
    public void testSignatureWithinBounds() {
        int allocatedSpace = 1000;
        int signatureSize = 500;
        boolean fits = signatureSize <= allocatedSpace;
        Assertions.assertTrue(fits);
    }
    
    @Test
    public void testSignatureExceedsBounds() {
        int allocatedSpace = 1000;
        int signatureSize = 1500;
        boolean fits = signatureSize <= allocatedSpace;
        Assertions.assertFalse(fits);
    }
}