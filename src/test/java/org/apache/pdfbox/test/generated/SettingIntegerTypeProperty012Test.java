package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SettingIntegerTypeProperty012Test {

    // Mock class to simulate setting an Integer property
    private static class MockObject {
        private Integer intValue;

        public void setIntValue(Object value) {
            if (value instanceof String) {
                this.intValue = Integer.parseInt((String) value);
            } else if (value instanceof Integer) {
                this.intValue = (Integer) value;
            }
        }

        public Integer getIntValue() {
            return intValue;
        }
    }

    @Test
    public void testSetIntegerFromString() {
        MockObject obj = new MockObject();
        String intString = "123";
        obj.setIntValue(intString);
        assertNotNull(obj.getIntValue(), "Integer value should not be null when set by string.");
        assertEquals(123, obj.getIntValue(), "Integer value set by string is incorrect.");
    }

    @Test
    public void testSetIntegerFromInteger() {
        MockObject obj = new MockObject();
        Integer intValue = 456;
        obj.setIntValue(intValue);
        assertNotNull(obj.getIntValue(), "Integer value should not be null when set by Integer object.");
        assertEquals(456, obj.getIntValue(), "Integer value set by Integer object is incorrect.");
    }

    @Test
    public void testSetIntegerWithInvalidString() {
        MockObject obj = new MockObject();
        String invalidString = "abc";
        assertThrows(NumberFormatException.class, () -> obj.setIntValue(invalidString), "Setting with invalid string should throw NumberFormatException.");
    }
}