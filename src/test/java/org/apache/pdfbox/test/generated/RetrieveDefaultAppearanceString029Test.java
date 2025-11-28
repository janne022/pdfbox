package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RetrieveDefaultAppearanceString029Test {
    @Test
    public void testWidgetHasAppearanceString() {
        String widgetAppearance = "/F1";
        String acroFormDefault = "/F1";
        String result = (widgetAppearance != null) ? widgetAppearance : acroFormDefault;
        Assertions.assertEquals("/F1", result);
    }
    
    @Test
    public void testWidgetHasNoAppearanceString() {
        String widgetAppearance = null;
        String acroFormDefault = "/F2";
        String result = (widgetAppearance != null) ? widgetAppearance : acroFormDefault;
        Assertions.assertEquals("/F2", result);
    }
}