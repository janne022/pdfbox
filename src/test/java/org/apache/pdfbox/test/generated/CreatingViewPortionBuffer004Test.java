package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CreatingViewPortionBuffer004Test {
    @Test
    public void testCreatePortionViewNotNull() {
        String buffer = "sample buffer";
        String portionView = buffer;
        Assertions.assertNotNull(portionView);
    }
    
    @Test
    public void testPortionViewContent() {
        String buffer = "abcdef";
        String portionView = buffer;
        Assertions.assertEquals("abcdef", portionView);
    }
}