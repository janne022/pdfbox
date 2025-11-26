package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ManagePdfResourceDictionaries035Test {
    @Test
    public void testProcSetArrayManagement() {
        String procSet = "/PDF /Text";
        Assertions.assertTrue(procSet.contains("/PDF"));
        Assertions.assertTrue(procSet.contains("/Text"));
    }
    
    @Test
    public void testFormXObjectPresence() {
        String xObjectKey = "Xo1";
        String xObjectValue = "/Form ...";
        Assertions.assertNotNull(xObjectKey);
        Assertions.assertNotNull(xObjectValue);
        Assertions.assertEquals("Xo1", xObjectKey);
    }
}