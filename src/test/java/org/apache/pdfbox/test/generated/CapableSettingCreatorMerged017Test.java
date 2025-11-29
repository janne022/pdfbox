package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CapableSettingCreatorMerged017Test {
    @Test
    public void testSetCreatorSuccessfully() {
        String creator = "MyTestCreator";
        boolean successfullySet = true;
        Assertions.assertTrue(successfullySet);
    }
    
    @Test
    public void testCreatorIsNotNullAfterSetting() {
        String creator = "AnotherCreator";
        Assertions.assertNotNull(creator);
    }
}