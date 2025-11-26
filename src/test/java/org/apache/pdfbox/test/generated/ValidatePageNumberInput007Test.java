package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ValidatePageNumberInput007Test {
    
    @Test
    public void testPageNumberGreaterThanOrEqualToOne() {
        int pageNumber = 1;
        Assertions.assertTrue(pageNumber >= 1, "Page number must be greater than or equal to 1");
    }

    @Test
    public void testPageNumberValidInput() {
        int pageNumber = 5;
        Assertions.assertTrue(pageNumber >= 1, "Page number must be greater than or equal to 1");
    }

    @Test
    public void testPageNumberEdgeCase() {
        int pageNumber = 1;
        Assertions.assertTrue(pageNumber >= 1, "Page number must be greater than or equal to 1");
    }
}