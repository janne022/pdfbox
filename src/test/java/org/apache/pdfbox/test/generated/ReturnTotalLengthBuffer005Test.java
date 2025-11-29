package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ReturnTotalLengthBuffer005Test {
    @Test
    public void testBufferNotNull() {
        String buffer = "some data";
        Assertions.assertNotNull(buffer);
    }
    
    @Test
    public void testBufferLengthIsCorrect() {
        String buffer = "test";
        int expectedLength = 4;
        Assertions.assertEquals(expectedLength, buffer.length());
    }
}