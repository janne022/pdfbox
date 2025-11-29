package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SerializeSimplePropertiesTheir041Test {
    @Test
    public void testSerializationOfSimpleProperty() {
        String propertyName = "sampleProperty";
        String propertyValue = "sampleValue";
        String expected = "<property name=\"sampleProperty\">sampleValue</property>";
        String actual = serialize(propertyName, propertyValue);
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    public void testSerializationWithEmptyValue() {
        String propertyName = "emptyProperty";
        String propertyValue = "";
        String expected = "<property name=\"emptyProperty\"/>";
        String actual = serialize(propertyName, propertyValue);
        Assertions.assertEquals(expected, actual);
    }
    
    private String serialize(String name, String value) {
        if (value == null || value.isEmpty()) {
            return "<property name=\"" + name + "\"/>";
        } else {
            return "<property name=\"" + name + "\">" + value + "</property>";
        }
    }
}