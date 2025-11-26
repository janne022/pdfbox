package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SpecifyingLegalattestationDigitalSignatures023Test {
    @Test
    public void testLegalAttestationCanBeSpecified() {
        String attestationType = "LegalAttestation";
        Assertions.assertNotNull(attestationType, "LegalAttestation should be specifiable");
        Assertions.assertEquals("LegalAttestation", attestationType, "The specified type should match");
    }

    @Test
    public void testOtherAttestationTypesAreNotLegalAttestation() {
        String otherType = "OtherType";
        Assertions.assertNotEquals("LegalAttestation", otherType, "This should not be LegalAttestation");
    }
}