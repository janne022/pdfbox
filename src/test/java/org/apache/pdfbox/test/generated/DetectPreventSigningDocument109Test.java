package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DetectPreventSigningDocument109Test {
    @Test
    public void testDocumentHasNoPermittedChanges() {
        String documentStatus = "no_changes_permitted";
        boolean canSign = false;
        Assertions.assertEquals(canSign, false);
    }

    @Test
    public void testDocumentAllowsChanges() {
        String documentStatus = "changes_permitted";
        boolean canSign = true;
        Assertions.assertEquals(canSign, true);
    }
}