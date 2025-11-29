package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PerformCaseInsensitiveMatching027Test {
    @Test
    public void testCaseInsensitiveHighlighting() {
        String text = "HelloWorld";
        String searchTerm = "hello";
        boolean exists = text.toLowerCase().contains(searchTerm.toLowerCase());
        Assertions.assertTrue(exists);
    }
    
    @Test
    public void testDifferentCaseMatching() {
        String text = "PDFBox";
        String searchTerm = "PDF";
        boolean exists = text.toLowerCase().contains(searchTerm.toLowerCase());
        Assertions.assertTrue(exists);
    }
}