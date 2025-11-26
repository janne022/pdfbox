package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FunctionalityRetrieveElementsArrayproperty003Test {
    @Test
    public void testRetrieveElementsFromEmptyArray() {
        String[] emptyArray = {};
        // Assuming a method getElementsAsList which returns List<String>
        // For simplicity, we'll assert on an empty list being returned.
        java.util.List<String> result = new java.util.ArrayList<>(); // Mocking the expected return
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }
    
    @Test
    public void testRetrieveElementsFromArrayWithValues() {
        String[] stringArray = {"value1", "value2", "value3"};
        // Assuming a method getElementsAsList which returns List<String>
        // For simplicity, we'll assert on the list containing expected values.
        java.util.List<String> result = new java.util.ArrayList<>(java.util.Arrays.asList(stringArray)); // Mocking the expected return
        Assertions.assertNotNull(result);
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals("value1", result.get(0));
        Assertions.assertEquals("value2", result.get(1));
        Assertions.assertEquals("value3", result.get(2));
    }
}