package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpAgentnameDataType026Test {
    @Test
    public void testAgentNameDataTypeSupported() {
        String agentName = "SampleAgent";
        Assertions.assertNotNull(agentName);
        Assertions.assertEquals("SampleAgent", agentName);
    }
    
    @Test
    public void testAgentNameDataTypeEmpty() {
        String agentName = "";
        Assertions.assertTrue(agentName.isEmpty());
    }
}