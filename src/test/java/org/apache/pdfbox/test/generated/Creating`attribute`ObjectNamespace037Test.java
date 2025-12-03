package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Creating`attribute`ObjectNamespace037Test {

    // This is a placeholder for the actual Attribute class which is not provided.
    // Assuming an Attribute class with constructor(String localName, String value) and (String nsURI, String localName, String value)
    // and methods getNamespaceURI(), getLocalName(), getValue(), and toString().
    public static class Attribute {
        private String nsURI;
        private String localName;
        private String value;

        public Attribute(String localName, String value) {
            this(null, localName, value);
        }

        public Attribute(String nsURI, String localName, String value) {
            this.nsURI = nsURI;
            this.localName = localName;
            this.value = value;
        }

        public String getNamespaceURI() {
            return nsURI;
        }

        public String getLocalName() {
            return localName;
        }

        public String getValue() {
            return value;
        }

        public void setNamespaceURI(String nsURI) {
            this.nsURI = nsURI;
        }

        public void setLocalName(String localName) {
            this.localName = localName;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            if (nsURI != null) {
                return "[attr:" + nsURI + localName + "=" + value + "]";
            } else {
                return "[attr:" + localName + "=" + value + "]";
            }
        }
    }

    @Test
    public void testAttributeCreationWithoutNamespace() {
        String localName = "testName";
        String value = "testValue";
        Attribute attribute = new Attribute(localName, value);
        Assertions.assertNotNull(attribute);
        Assertions.assertEquals(null, attribute.getNamespaceURI());
        Assertions.assertEquals(localName, attribute.getLocalName());
        Assertions.assertEquals(value, attribute.getValue());
        Assertions.assertEquals("[attr:testName=testValue]", attribute.toString());
    }

    @Test
    public void testAttributeCreationWithNamespace() {
        String nsURI = "http://www.test.com/";
        String localName = "otherName";
        String value = "otherValue";
        Attribute attribute = new Attribute(nsURI, localName, value);
        Assertions.assertNotNull(attribute);
        Assertions.assertEquals(nsURI, attribute.getNamespaceURI());
        Assertions.assertEquals(localName, attribute.getLocalName());
        Assertions.assertEquals(value, attribute.getValue());
        Assertions.assertEquals("[attr:http://www.test.com/otherName=otherValue]", attribute.toString());
    }

    @Test
    public void testAttributeSettersAndToString() {
        Attribute attribute = new Attribute("initial", "42");
        attribute.setNamespaceURI("http://new.ns/");
        attribute.setLocalName("updatedName");
        attribute.setValue("newValue");
        Assertions.assertEquals("http://new.ns/", attribute.getNamespaceURI());
        Assertions.assertEquals("updatedName", attribute.getLocalName());
        Assertions.assertEquals("newValue", attribute.getValue());
        Assertions.assertEquals("[attr:http://new.ns/updatedName=newValue]", attribute.toString());
    }
}