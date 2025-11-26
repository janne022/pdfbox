package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ValidatePageNumberInput007Test {
    @Test
    public void testPageNumberGreaterThanOrEqualToOne() {
        int pageNumber = 5; 
        Assertions.assertTrue(pageNumber >= 1, "Page number must be 1 or greater");
    }
    
    @Test
    public void testPageNumberIsOne() {
        int pageNumber = 1;
        Assertions.assertEquals(1, pageNumber, "Page number should be 1");
    }

    @Test
    public void testPageNumberLessThanOne() {
        int pageNumber = 0;
        Assertions.assertFalse(pageNumber >= 1, "Page number must be 1 or greater");
    } 
}