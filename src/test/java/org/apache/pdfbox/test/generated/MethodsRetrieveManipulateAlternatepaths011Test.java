package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MethodsRetrieveManipulateAlternatepaths011Test {
    @Test
    public void testRetrieveAlternatePaths() {
        String alternatePaths = "path1,path2";
        Assertions.assertNotNull(alternatePaths);
        Assertions.assertTrue(alternatePaths.contains(","));
    }
    
    @Test
    public void testManipulateAlternatePaths() {
        String alternatePaths = "initialPath";
        alternatePaths = alternatePaths + ",newPath";
        Assertions.assertEquals("initialPath,newPath", alternatePaths);
    }
}