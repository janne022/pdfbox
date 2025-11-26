package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SpecifyingAddrevinfoDigitalSignatures022Test {

    @Test
    public void specifyAddRevInfoTest() {
        boolean addRevInfo = true;
        Assertions.assertTrue(addRevInfo, "AddRevInfo should be true when specified");
    }

    @Test
    public void doNotSpecifyAddRevInfoTest() {
        boolean addRevInfo = false;
        Assertions.assertFalse(addRevInfo, "AddRevInfo should be false when not specified");
    }
}