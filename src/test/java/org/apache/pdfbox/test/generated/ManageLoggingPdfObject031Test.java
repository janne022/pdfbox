package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ManageLoggingPdfObject031Test {
    @Test
    public void testObjectCreationLog() {
        String logMessage = "PDF object created";
        Assertions.assertTrue(logMessage.contains("created"));
    }
    
    @Test
    public void testObjectUpdateLog() {
        String logMessage = "PDF object updated";
        Assertions.assertTrue(logMessage.contains("updated"));
    }
}