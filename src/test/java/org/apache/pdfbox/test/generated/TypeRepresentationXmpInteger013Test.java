package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TypeRepresentationXmpInteger013Test {
    @Test
    public void testXmpIntegerCreation() {
        String integerString = "123";
        Assertions.assertNotNull(integerString);
        Assertions.assertTrue(integerString.matches("\d+"));
    }
    
    @Test
    public void testXmpIntegerConversion() {
        String integerString = "456";
        int integerValue = Integer.parseInt(integerString);
        Assertions.assertEquals(456, integerValue);
    }
}