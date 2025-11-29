package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CaseSensitiveCaseInsensitive134Test {
    @Test
    public void testCaseSensitiveSearch() {
        String text = "HelloWorld";
        String pattern = "Hello";
        boolean found = text.contains(pattern);
        Assertions.assertTrue(found, "Case sensitive search should find exact match");
    }

    @Test
    public void testCaseInsensitiveSearch() {
        String text = "HelloWorld";
        String pattern = "helloworld";
        boolean found = text.toLowerCase().contains(pattern.toLowerCase());
        Assertions.assertTrue(found, "Case insensitive search should find match regardless of case");
    }
}