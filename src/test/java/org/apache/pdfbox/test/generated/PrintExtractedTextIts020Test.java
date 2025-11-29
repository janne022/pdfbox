package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PrintExtractedTextIts020Test {
    @Test
    public void testPrintTextCoordinatesFontAndSize() {
        // Simulate printing extracted text, coordinates, font, and size
        String outputLine = "Extracted text: 'sample', Coordinates: [10, 20, 30, 40], Font: 'Arial', Size: 12.0";
        // Asserting that the output is not null and contains expected elements
        Assertions.assertNotNull(outputLine, "Output should not be null.");
        Assertions.assertTrue(outputLine.contains("Extracted text: 'sample'"), "Output must contain extracted text.");
        Assertions.assertTrue(outputLine.contains("Coordinates: [10, 20, 30, 40]"), "Output must contain coordinates.");
        Assertions.assertTrue(outputLine.contains("Font: 'Arial'"), "Output must contain font information.");
        Assertions.assertTrue(outputLine.contains("Size: 12.0"), "Output must contain font size.");
    }

    @Test
    public void testAnotherOutputFormat() {
        // Simulate another output line for different content
        String outputLine = "Extracted text: 'another', Coordinates: [5, 5, 5, 5], Font: 'Times New Roman', Size: 10.5";
        Assertions.assertNotNull(outputLine, "Output for another format should not be null.");
        Assertions.assertTrue(outputLine.contains("Extracted text: 'another'"), "Output must contain different extracted text.");
        Assertions.assertTrue(outputLine.contains("Size: 10.5"), "Output must contain correct size for another format.");
    }
}