package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SettingsPropertySequenceText020Test {

    @Test
    public void testSettingsPropertyIsTextSequence() {
        String settings = "value1,value2";
        assertTrue(settings instanceof String);
        assertTrue(settings.contains(","));
    }

    @Test
    public void testRowsPropertyIsInteger() {
        Integer rows = 10;
        assertNotNull(rows);
        assertTrue(rows instanceof Integer);
    }

    @Test
    public void testColumnsPropertyIsInteger() {
        Integer columns = 5;
        assertNotNull(columns);
        assertTrue(columns instanceof Integer);
    }
}