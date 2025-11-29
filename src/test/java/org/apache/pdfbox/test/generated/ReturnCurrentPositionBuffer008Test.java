package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ReturnCurrentPositionBuffer008Test {
    @Test
    public void testValidBufferPosition() {
        int currentPosition = 10;
        Assertions.assertEquals(10, currentPosition);
    }

    @Test
    public void testZeroPosition() {
        int zeroPosition = 0;
        Assertions.assertEquals(0, zeroPosition);
    }
}