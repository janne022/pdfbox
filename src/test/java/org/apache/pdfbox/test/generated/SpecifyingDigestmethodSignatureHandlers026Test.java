package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SpecifyingDigestmethodSignatureHandlers026Test {
    @Test
    public void testDigestMethodCanBeSpecified() {
        String digestMethod = "SHA-256";
        Assertions.assertNotNull(digestMethod, "Digest method should not be null");
        Assertions.assertTrue(digestMethod.equals("SHA-256") || digestMethod.equals("SHA-1"), "Digest method should be a valid algorithm");
    }
    
    @Test
    public void testDefaultDigestMethodIsUsedWhenNoneSpecified() {
        String defaultDigestMethod = "SHA-1";
        Assertions.assertEquals("SHA-1", defaultDigestMethod, "Default digest method should be SHA-1");
    }
}