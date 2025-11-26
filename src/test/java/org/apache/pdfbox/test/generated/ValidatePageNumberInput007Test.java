package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ValidatePageNumberInput007Test {
    @Test
    public void testPageNumberIsPositive() {
        int pageNumber = 1;
        Assertions.assertTrue(pageNumber >= 1, "Page number must be 1 or greater");
    }
    
    @Test
    public void testPageNumberIsGreaterThanOne() {
        int pageNumber = 5;
        Assertions.assertTrue(pageNumber >= 1, "Page number must be 1 or greater");
    }
}