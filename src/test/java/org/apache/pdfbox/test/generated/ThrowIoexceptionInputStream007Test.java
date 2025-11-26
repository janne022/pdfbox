package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class ThrowIoexceptionInputStream007Test {

    @Test
    public void testUnexpectedEndOfStream() throws IOException {
        byte[] malformedPdfBytes = new byte[] { (byte) 0x25, (byte) 0x50, (byte) 0x44, (byte) 0x46, (byte) 0x2d }; // Incomplete PDF header
        ByteArrayInputStream inputStream = new ByteArrayInputStream(malformedPdfBytes);

        IOException thrown = Assertions.assertThrows(IOException.class, () -> {
            PDDocument.load(inputStream);
        }, "IOException should be thrown for truncated stream");

        String message = thrown.getMessage();
        Assertions.assertTrue(message.contains("unexpected end of stream"), "Error message should indicate unexpected end of stream");
    }

    @Test
    public void testValidStreamDoesNotThrow() throws IOException {
        // A minimal valid PDF header
        byte[] validPdfBytes = new byte[] { (byte) 0x25, (byte) 0x50, (byte) 0x44, (byte) 0x46, (byte) 0x2d, (byte) 0x31, (byte) 0x2e, (byte) 0x30, (byte) 0x0a, (byte) 0x25, (byte) 0x02, (byte) 0x01, (byte) 0x02, (byte) 0x03, (byte) 0x0a };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(validPdfBytes);

        try {
            PDDocument.load(inputStream);
            Assertions.assertTrue(true);
        } catch (IOException e) {
            Assertions.assertFalse(true, "IOException should not be thrown for valid stream: " + e.getMessage());
        }
    }
}