package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RetrievalPdchoiceOptionValues024Test {
    @Test
    public void testRetrieveStringOptionValue() {
        String optionValue = "SampleText";
        Assertions.assertNotNull(optionValue);
        Assertions.assertEquals("SampleText", optionValue);
    }
    
    @Test
    public void testRetrieveArrayOptionValue() {
        String[] optionValue = {"Value1", "Value2"};
        Assertions.assertNotNull(optionValue);
        Assertions.assertEquals(2, optionValue.length);
        Assertions.assertEquals("Value1", optionValue[0]);
        Assertions.assertEquals("Value2", optionValue[1]);
    }
}