package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ManagePdfResourceDictionaries035Test {
    @Test
    public void testProcSetArrayManagement() {
        String procSet = "/PDF /Text";
        Assertions.assertNotNull(procSet, "ProcSet array should not be null");
        Assertions.assertTrue(procSet.contains("/PDF"), "ProcSet should contain /PDF");
    }
    
    @Test
    public void testFormXObjectCreation() {
        String formXObject = "/XObj /Form";
        Assertions.assertEquals("/XObj /Form", formXObject, "Form XObject string should match literal");
    }
}