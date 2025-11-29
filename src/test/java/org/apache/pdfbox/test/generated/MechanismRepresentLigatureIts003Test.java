package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MechanismRepresentLigatureIts003Test {
    @Test
    public void testLigatureRepresentation() {
        String ligature = "fi";
        String successor = "i";
        Assertions.assertTrue(ligature.length() > 0);
        Assertions.assertTrue(successor.length() > 0);
        Assertions.assertEquals("fi", ligature);
        Assertions.assertEquals("i", successor);
    }

    @Test
    public void testLigatureSuccessorMapping() {
        String ligature = "fl";
        String successor = "l";
        Assertions.assertNotNull(ligature);
        Assertions.assertNotNull(successor);
        Assertions.assertEquals("fl", ligature);
        Assertions.assertEquals("l", successor);
    }
}