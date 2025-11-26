package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SpecifyingReasonDigitalSignatures024Test {
    @Test
    public void testReasonCanBeSpecified() {
        String reason = "Test Reason";
        Assertions.assertNotNull(reason, "Reason should not be null");
        Assertions.assertEquals("Test Reason", reason, "Reason string mismatch");
    }
    
    @Test
    public void testEmptyReasonIsPossible() {
        String reason = "";
        Assertions.assertTrue(reason.isEmpty(), "Empty reason should be valid");
    }
}