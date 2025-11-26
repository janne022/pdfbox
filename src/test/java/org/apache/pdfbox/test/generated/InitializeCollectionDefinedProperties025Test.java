package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.pdfbox.structuredtype.StructuredType;
import org.apache.pdfbox.structuredtype.StructuredType.Builder;
import java.util.Collection;

public class InitializeCollectionDefinedProperties025Test {

    @Test
    public void testDefinedPropertiesCollectionInitialization() throws Exception {
        StructuredType structuredType = new Builder("TestType").build();
        Collection<?> definedProperties = structuredType.getDefinedProperties();
        assertNotNull(definedProperties, "Defined properties collection should not be null.");
        assertTrue(definedProperties.isEmpty(), "Defined properties collection should be initially empty.");
    }

    @Test
    public void testAddingDefinedProperty() throws Exception {
        StructuredType structuredType = new Builder("TestType").build();
        String propertyName = "testProperty1";
        structuredType.addDefinedProperty(propertyName);
        Collection<?> definedProperties = structuredType.getDefinedProperties();
        assertNotNull(definedProperties, "Defined properties collection should not be null after adding.");
        assertFalse(definedProperties.isEmpty(), "Defined properties collection should not be empty after adding.");
        assertTrue(definedProperties.contains(propertyName), "Defined properties collection should contain the added property.");
    }

    @Test
    public void testMultipleDefinedProperties() throws Exception {
        StructuredType structuredType = new Builder("TestType").build();
        String propertyName1 = "prop1";
        String propertyName2 = "prop2";
        structuredType.addDefinedProperty(propertyName1);
        structuredType.addDefinedProperty(propertyName2);
        Collection<?> definedProperties = structuredType.getDefinedProperties();
        assertNotNull(definedProperties, "Defined properties collection should not be null with multiple properties.");
        assertEquals(2, definedProperties.size(), "Defined properties collection should contain two properties.");
        assertTrue(definedProperties.contains(propertyName1), "Collection should contain the first property.");
        assertTrue(definedProperties.contains(propertyName2), "Collection should contain the second property.");
    }
}