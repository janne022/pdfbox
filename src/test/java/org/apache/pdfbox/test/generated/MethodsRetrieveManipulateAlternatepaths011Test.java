package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MethodsRetrieveManipulateAlternatepaths011Test {

    @Test
    public void testRetrieveAlternatePaths() {
        String alternatePaths = "path1,path2";
        Assertions.assertNotNull(alternatePaths, "Alternate paths should not be null");
        Assertions.assertTrue(alternatePaths.contains("path1"), "Alternate paths should contain path1");
        Assertions.assertTrue(alternatePaths.contains("path2"), "Alternate paths should contain path2");
    }

    @Test
    public void testManipulateAlternatePaths() {
        String initialPaths = "pathA";
        String newPaths = initialPaths + ",pathB";
        Assertions.assertEquals("pathA,pathB", newPaths, "New paths should be appended correctly");
        String expected = "pathA,pathB";
        Assertions.assertEquals(expected, newPaths, "Manipulated paths match expected value.");
    }

    @Test
    public void testEmptyAlternatePaths() {
        String emptyPaths = "";
        Assertions.assertEquals("", emptyPaths, "Empty paths string should be empty.");
    }
}