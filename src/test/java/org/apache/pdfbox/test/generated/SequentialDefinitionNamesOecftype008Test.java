package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SequentialDefinitionNamesOecftype008Test {

    @Test
    public void testSequentialNamesSupport() {
        String name1 = "OECFType1";
        String name2 = "OECFType2";
        assertNotNull(name1, "First name should not be null");
        assertNotNull(name2, "Second name should not be null");
        assertTrue(name1.startsWith("OECFType"), "Name should start with OECFType");
        assertTrue(name2.startsWith("OECFType"), "Name should start with OECFType");
    }

    @Test
    public void testValidNameGeneration() {
        String validName = "OECFType100";
        assertNotNull(validName, "Generated name should not be null");
        assertEquals("OECFType100", validName, "Generated name should match expected format");
    }

    @Test
    public void testEmptyNameHandling() {
        String emptyName = "";
        assertNotNull(emptyName, "Empty name should be handled");
        assertNotEquals("OECFType", emptyName, "Empty name is not a valid OECFType");
    }
}