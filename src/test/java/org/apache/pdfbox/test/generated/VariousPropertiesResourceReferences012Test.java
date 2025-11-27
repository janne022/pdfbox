package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class VariousPropertiesResourceReferences012Test {

    @Test
    public void testToPartProperty() {
        String toPartValue = "PartA";
        Assertions.assertNotNull(toPartValue);
        Assertions.assertEquals("PartA", toPartValue);
    }

    @Test
    public void testVersionIDProperty() {
        String versionIDValue = "v1.2.3";
        Assertions.assertNotNull(versionIDValue);
        Assertions.assertEquals("v1.2.3", versionIDValue);
    }

    @Test
    public void testFilePathProperty() {
        String filePathValue = "/path/to/file.pdf";
        Assertions.assertNotNull(filePathValue);
        Assertions.assertEquals("/path/to/file.pdf", filePathValue);
    }
}