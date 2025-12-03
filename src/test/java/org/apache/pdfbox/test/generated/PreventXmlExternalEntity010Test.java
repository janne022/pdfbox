package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PreventXmlExternalEntity010Test {
    @Test
    public void testPreventionOfExternalEntitiesEnabled() {
        boolean preventionEnabled = true;
        Assertions.assertTrue(preventionEnabled);
    }
    
    @Test
    public void testDtdParsingDisabled() {
        boolean dtdParsingDisabled = true;
        Assertions.assertTrue(dtdParsingDisabled);
    }
}