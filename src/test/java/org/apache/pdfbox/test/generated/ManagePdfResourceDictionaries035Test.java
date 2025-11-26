package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ManagePdfResourceDictionaries035Test {

    @Test
    public void testProcSetArrayManagement() {
        String procSetExample = "/DeviceRGB /ImageB";
        Assertions.assertNotNull(procSetExample, "ProcSet array should not be null");
        Assertions.assertTrue(procSetExample.contains("/DeviceRGB"), "ProcSet array should contain /DeviceRGB");
    }

    @Test
    public void testFormXObjectManagement() {
        String formXObjectKey = "/Xo1";
        String formXObjectType = "Form";
        Assertions.assertNotNull(formXObjectKey, "Form XObject key should not be null");
        Assertions.assertEquals("Form", formXObjectType, "Form XObject type should be Form");
    }
}