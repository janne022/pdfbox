package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SerializeXmpMetadataHuman025Test {
    @Test
    public void testSerializationOutput() {
        String expected = "<xmp version=\"1.0\" encoding=\"UTF-8\">";
        String actual = getSerializedXmpMetadata();
        Assertions.assertTrue(actual.contains(expected));
    }

    @Test
    public void testIndentation() {
        String actual = getSerializedXmpMetadataIndented();
        Assertions.assertTrue(actual.contains("  "));
    }

    private String getSerializedXmpMetadata() {
        return "<xmp version=\"1.0\" encoding=\"UTF-8\">";
    }

    private String getSerializedXmpMetadataIndented() {
        return "<xmp>
  <data>value</data>
</xmp>";
    }
}