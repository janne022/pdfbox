package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MethodRetrieveElementsArrayproperty022Test {
    @Test
    public void testRetrieveAllElementsNotNull() {
        String arrayProperty = "element1,element2,element3";
        Assertions.assertNotNull(arrayProperty);
    }
    
    @Test
    public void testRetrieveAllElementsCorrectCount() {
        String arrayProperty = "element1,element2,element3";
        String[] elements = arrayProperty.split(",");
        int expectedCount = 3;
        Assertions.assertEquals(expectedCount, elements.length);
    }
}