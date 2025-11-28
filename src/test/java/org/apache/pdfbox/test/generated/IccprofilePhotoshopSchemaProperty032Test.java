package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class IccprofilePhotoshopSchemaProperty032Test {
    @Test
    public void testIccProfilePropertyExists() {
        String iccProfileProperty = "ICMProfile";
        Assertions.assertNotNull(iccProfileProperty);
        Assertions.assertEquals("ICMProfile", iccProfileProperty);
    }

    @Test
    public void testIccProfilePropertyType() {
        String iccProfileProperty = "ICMProfile";
        Assertions.assertTrue(iccProfileProperty instanceof String);
    }
}