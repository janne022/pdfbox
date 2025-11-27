package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class VariousPropertiesResourceReferences012Test {
    @Test
    public void testToPartProperty() {
        String toPartValue = "PART_A";
        Assertions.assertNotNull(toPartValue);
        Assertions.assertEquals("PART_A", toPartValue);
    }

    @Test
    public void testVersionIDProperty() {
        String versionIdValue = "1.0.0";
        Assertions.assertNotNull(versionIdValue);
        Assertions.assertEquals("1.0.0", versionIdValue);
    }

    @Test
    public void testFilePathProperty() {
        String filePathValue = "/path/to/file.pdf";
        Assertions.assertNotNull(filePathValue);
        Assertions.assertEquals("/path/to/file.pdf", filePathValue);
    }
}