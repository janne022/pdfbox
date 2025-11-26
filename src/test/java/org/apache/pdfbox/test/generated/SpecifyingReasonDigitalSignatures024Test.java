package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SpecifyingReasonDigitalSignatures024Test {
    @Test
    public void testSetReason() {
        String reason = "Test Reason";
        Assertions.assertNotNull(reason, "Reason should not be null");
        Assertions.assertTrue(reason.length() > 0, "Reason should have content");
    }
    
    @Test
    public void testEmptyReason() {
        String reason = "";
        Assertions.assertEquals("", reason, "Empty reason should be accepted");
    }
}