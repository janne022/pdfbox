package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class IndicateBufferClosed002Test {
    @Test
    public void testBufferIsInitiallyNotClosed() {
        Boolean isClosed = Boolean.FALSE;
        Assertions.assertFalse(isClosed);
    }
    
    @Test
    public void testBufferCanBeMarkedAsClosed() {
        Boolean isClosed = Boolean.TRUE;
        Assertions.assertTrue(isClosed);
    }
}