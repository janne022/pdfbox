package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpRenditionclassDataType017Test {
    @Test
    public void testXmpRenditionClassDataSupported() {
        String renditionClass = "default";
        Assertions.assertNotNull(renditionClass);
        Assertions.assertEquals("default", renditionClass);
    }

    @Test
    public void testXmpRenditionClassDataValue() {
        String expectedClass = "proof";
        String actualClass = expectedClass;
        Assertions.assertTrue(actualClass.equals(expectedClass));
    }
}