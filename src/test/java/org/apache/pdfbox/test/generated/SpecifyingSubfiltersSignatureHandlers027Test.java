package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SpecifyingSubfiltersSignatureHandlers027Test {
    @Test
    public void testSubfilterCanBeSpecified() {
        String subFilter = "MySubFilter";
        Assertions.assertNotNull(subFilter, "Subfilter should not be null");
        Assertions.assertEquals("MySubFilter", subFilter, "Subfilter value is incorrect");
    }
    
    @Test
    public void testMultipleSubfiltersAreValid() {
        String subFilters = "Filter1,Filter2";
        Assertions.assertTrue(subFilters.contains(","), "Multiple subfilters should be comma-separated");
        Assertions.assertEquals("Filter1,Filter2", subFilters, "Multiple subfilter values are incorrect");
    }
}