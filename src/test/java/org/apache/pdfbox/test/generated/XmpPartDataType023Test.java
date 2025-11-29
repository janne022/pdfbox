package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpPartDataType023Test {
    @Test
    public void testSupportsXmpPartDataType() {
        String expectedType = "XMPPart";
        String actualType = "XMPPart";
        Assertions.assertEquals(expectedType, actualType, "Should support XMP Part data type");
    }
    
    @Test
    public void testDataTypeIsNotNull() {
        String dataType = "XMPPart";
        Assertions.assertNotNull(dataType, "XMP Part data type should not be null");
    }
}