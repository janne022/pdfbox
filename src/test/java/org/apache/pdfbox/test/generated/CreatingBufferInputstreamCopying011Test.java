package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CreatingBufferInputstreamCopying011Test {
    @Test
    public void testBufferCreationFromInputStream() {
        String sampleData = "Hello";
        byte[] buffer = sampleData.getBytes();
        Assertions.assertNotNull(buffer);
        Assertions.assertTrue(buffer.length > 0);
        Assertions.assertEquals(buffer.length, sampleData.length());
    }

    @Test
    public void testEmptyInputStream() {
        String sampleData = "";
        byte[] buffer = sampleData.getBytes();
        Assertions.assertNotNull(buffer);
        Assertions.assertEquals(0, buffer.length);
    }
}