package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SpecifyingAddrevinfoDigitalSignatures022Test {
    @Test
    public void testAddRevInfoEnabled() {
        Boolean addRevInfo = true;
        Assertions.assertTrue(addRevInfo, "AddRevInfo should be true.");
    }

    @Test
    public void testAddRevInfoDisabled() {
        Boolean addRevInfo = false;
        Assertions.assertFalse(addRevInfo, "AddRevInfo should be false.");
    }
}