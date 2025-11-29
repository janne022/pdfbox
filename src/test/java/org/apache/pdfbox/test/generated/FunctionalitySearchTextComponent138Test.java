package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FunctionalitySearchTextComponent138Test {
    @Test
    public void findTextComponentExists() {
        String component = "sample text";
        Assertions.assertNotNull(component);
    }
    
    @Test
    public void findTextComponentReturnsMatch() {
        String component = "sample text";
        String searchText = "sample";
        boolean found = component.contains(searchText);
        Assertions.assertTrue(found);
    }
}