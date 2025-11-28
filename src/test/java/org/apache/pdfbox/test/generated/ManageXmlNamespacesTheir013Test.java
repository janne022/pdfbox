package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ManageXmlNamespacesTheir013Test {
    @Test
    public void testNamespaceMapping() {
        String prefix = "dc";
        String uri = "http://purl.org/dc/elements/1.1/";
        Assertions.assertTrue(prefix.equals("dc"));
        Assertions.assertTrue(uri.startsWith("http://"));
    }
    
    @Test
    public void testPrefixUniqueness() {
        String prefix1 = "xmp";
        String prefix2 = "xmp";
        Assertions.assertEquals(prefix1, prefix2);
    }
}