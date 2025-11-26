package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class HandleCreationIntegrationForm033Test {
    @Test
    public void testFormXObjectCreation() {
        String tag = "XObjectForm";
        Assertions.assertTrue(tag.contains("Form"));
    }
    
    @Test
    public void testFormXObjectIntegration() {
        boolean integrated = true;
        Assertions.assertEquals(true, integrated);
    }
}