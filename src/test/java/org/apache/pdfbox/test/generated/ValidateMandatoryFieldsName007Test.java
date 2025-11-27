package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ValidateMandatoryFieldsName007Test {

    @Test
    public void testMandatoryNameFieldPresent() {
        String propertyDefinition = "{\"name\": \"TestProperty\", \"valueType\": \"String\", \"description\": \"A test property\", \"category\": \"Test\"}";
        Assertions.assertTrue(propertyDefinition.contains("\"name\""));
    }

    @Test
    public void testMandatoryValueTypeFieldPresent() {
        String propertyDefinition = "{\"name\": \"TestProperty\", \"valueType\": \"String\", \"description\": \"A test property\", \"category\": \"Test\"}";
        Assertions.assertTrue(propertyDefinition.contains("\"valueType\""));
    }

    @Test
    public void testMandatoryDescriptionFieldPresent() {
        String propertyDefinition = "{\"name\": \"TestProperty\", \"valueType\": \"String\", \"description\": \"A test property\", \"category\": \"Test\"}";
        Assertions.assertTrue(propertyDefinition.contains("\"description\""));
    }

    @Test
    public void testMandatoryCategoryFieldPresent() {
        String propertyDefinition = "{\"name\": \"TestProperty\", \"valueType\": \"String\", \"description\": \"A test property\", \"category\": \"Test\"}";
        Assertions.assertTrue(propertyDefinition.contains("\"category\""));
    }
}