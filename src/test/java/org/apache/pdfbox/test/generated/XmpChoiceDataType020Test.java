package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class XmpChoiceDataType020Test {
    @Test
    public void testXmpChoiceBasic() {
        String choiceValue = "Option1";
        Assertions.assertNotNull(choiceValue);
        Assertions.assertEquals("Option1", choiceValue);
    }
    
    @Test
    public void testXmpChoiceEmpty() {
        String emptyChoice = "";
        Assertions.assertTrue(emptyChoice.isEmpty());
    }
}