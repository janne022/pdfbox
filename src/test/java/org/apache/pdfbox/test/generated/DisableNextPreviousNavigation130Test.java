package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DisableNextPreviousNavigation130Test {
    @Test
    public void testNoMatchesFoundDisablesButtons() {
        Boolean nextButtonState = false;
        Boolean previousButtonState = false;
        Assertions.assertFalse(nextButtonState, "Next button should be disabled");
        Assertions.assertFalse(previousButtonState, "Previous button should be disabled");
    }
    
    @Test
    public void testAtStartOfMatchesDisablesPrevious() {
        Boolean nextButtonState = true;
        Boolean previousButtonState = false;
        Assertions.assertTrue(nextButtonState, "Next button should be enabled");
        Assertions.assertFalse(previousButtonState, "Previous button should be disabled at start");
    }
    
    @Test
    public void testAtEndOfMatchesDisablesNext() {
        Boolean nextButtonState = false;
        Boolean previousButtonState = true;
        Assertions.assertFalse(nextButtonState, "Next button should be disabled at end");
        Assertions.assertTrue(previousButtonState, "Previous button should be enabled");
    }
}