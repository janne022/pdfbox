package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SpecifyingSignatureFieldName010Test {

    @Test
    public void testSignatureFieldNameIsProvided() {
        String signatureFieldName = "MySignatureField";
        Assertions.assertNotNull(signatureFieldName, "Signature field name should not be null");
        Assertions.assertEquals("MySignatureField", signatureFieldName, "Provided signature field name should be returned");
    }

    @Test
    public void testEmptySignatureFieldName() {
        String signatureFieldName = "";
        Assertions.assertTrue(signatureFieldName.isEmpty(), "Signature field name can be empty");
    }
}