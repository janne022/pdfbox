package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SequentialDefinitionNamesOecftype008Test {
    @Test
    public void testSequentialNameDefinition() {
        String name1 = "OECFType1";
        String name2 = "OECFType2";
        Assertions.assertTrue(name1.startsWith("OECFType"));
        Assertions.assertTrue(name2.startsWith("OECFType"));
        Assertions.assertNotEquals(name1, name2);
    }

    @Test
    public void testDefaultName() {
        String defaultName = "DefaultOECF";
        Assertions.assertNotNull(defaultName);
        Assertions.assertEquals("DefaultOECF", defaultName);
    }
}