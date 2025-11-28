package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SupplementalcategoriesPhotoshopSchemaProperty028Test {
    @Test
    public void testSupplementalCategoriesPropertyExists() {
        String propertyName = "SupplementalCategories";
        Assertions.assertNotNull(propertyName, "The SupplementalCategories property should exist.");
    }
    
    @Test
    public void testSupplementalCategoriesPropertyType() {
        String propertyType = "Text";
        Assertions.assertEquals("Text", propertyType, "The SupplementalCategories property should be of Text type.");
    }

    @Test
    public void testSupplementalCategoriesPropertyCardinality() {
        boolean isSimpleCardinality = true;
        Assertions.assertTrue(isSimpleCardinality, "The SupplementalCategories property should have simple cardinality.");
    }
}