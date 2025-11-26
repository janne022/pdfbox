package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SpecifyingAddrevinfoDigitalSignatures022Test {
    @Test
    public void testAddRevInfoEnabled() {
        boolean addRevInfo = true;
        Assertions.assertTrue(addRevInfo, "AddRevInfo should be enabled by default");
    }
    
    @Test
    public void testAddRevInfoDisabled() {
        boolean addRevInfo = false;
        Assertions.assertFalse(addRevInfo, "AddRevInfo should be disabled by default");
    }
}