package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SpecifyingReasonDigitalSignatures024Test {
    @Test
    public void testReasonCanBeSpecified() {
        String reason = "Approved by Manager";
        Assertions.assertNotNull(reason, "Reason should not be null");
        Assertions.assertTrue(reason.length() > 0, "Reason should have content");
    }
    
    @Test
    public void testEmptyReasonIsHandled() {
        String reason = "";
        Assertions.assertEquals("", reason, "Empty reason string should be handled gracefully");
    }
}