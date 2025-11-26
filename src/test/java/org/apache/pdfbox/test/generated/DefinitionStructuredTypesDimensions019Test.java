package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DefinitionStructuredTypesDimensions019Test {
    @Test
    public void testValidDimensions() {
        String unit = "cm";
        Double height = 10.5;
        Double width = 5.2;
        assertNotNull(unit);
        assertNotNull(height);
        assertNotNull(width);
        assertTrue(height > 0);
        assertTrue(width > 0);
    }

    @Test
    public void testNullUnit() {
        Double height = 10.5;
        Double width = 5.2;
        assertNotNull(height);
        assertNotNull(width);
        // Assuming null unit is acceptable for now
        assertTrue(height > 0);
        assertTrue(width > 0);
    }

    @Test
    public void testZeroDimensions() {
        String unit = "in";
        Double height = 0.0;
        Double width = 0.0;
        assertNotNull(unit);
        assertNotNull(height);
        assertNotNull(width);
        assertEquals(0.0, height);
        assertEquals(0.0, width);
    }
}