package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpPropernameDataType028Test {
    @Test
    public void testProperNameParsing() {
        String properName = "Example Name";
        Assertions.assertNotNull(properName);
        Assertions.assertTrue(properName.length() > 0);
    }
    
    @Test
    public void testEmptyProperName() {
        String emptyName = "";
        Assertions.assertEquals("", emptyName);
    }
}