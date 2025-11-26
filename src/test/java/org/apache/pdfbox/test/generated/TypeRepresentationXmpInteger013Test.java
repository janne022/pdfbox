package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.pdmodel.common.XMPMetadataParser;
import org.apache.pdfbox.util.XMLUtil;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for requirement SRS-PDFBOX-013: The CSCI shall provide a type representation for XMP Integer properties.
 */
public class TypeRepresentationXmpInteger013Test {

    /**
     * Tests the correct representation of an XMP Integer property when it is valid.
     * This covers the positive scenario where the XML contains a well-formed integer.
     * 
     * @throws IOException If there is an error during XML parsing.
     */
    @Test publicVoidTestXmpIntegerRepresentation_ValidInteger_ShouldParseCorrectly() throws IOException {
        String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                           "<x:xmpmeta xmlns:x=\"adobe:ns:meta/\" x:xmptk=\"3.1-beta1\">\n" +
                           "  <rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">\n" +
                           "    <rdf:Description xmlns:dc=\"http://purl.org/dc/elements/1.1/\" rdf:about=\"\">\n" +
                           "      <dc:format>image/jpeg</dc:format>\n" +
                           "      <dc:creator>\n" +
                           "        <rdf:Seq>\n" +
                           "          <rdf:li>John Doe</rdf:li>\n" +
                           "        </rdf:Seq>\n" +
                           "      </dc:creator>\n" +
                           "      <custom:integerProperty xmlns:custom=\"http://example.com/custom/">12345</custom:integerProperty>\n" +
                + "\"    </rdf:Description>\n\" +\n"
                + "\"  </rdf:RDF>\n\" +\n"
                + "\"</x:xmpmeta>\";\n"
                + "Element xmpMeta = XMPMetadataParser.parseXMPMetadata(xmlContent);\n"
                + "assertNotNull(xmpMeta, \"XMP metadata should be parsed successfully.\");\n"
                + "// Attempt to find the custom integer property\n"
                + "Element integerElement = XMLUtil.findElement(xmpMeta, \"custom:integerProperty\", \"http://example.com/custom/\");\n"
                + "assertNotNull(integerElement, \"Custom integer property element should be found.\");\n"
                + "assertEquals(\"12345\", integerElement.getTextContent(), \"The text content should be the integer value.\");\n"
                + "}\n"
                + "/**\n"
                + "* Tests the handling of an XMP Integer property with a non-integer value.\n"
                + "* This covers a negative scenario where the XML contains an invalid value.\n"
                + "*\n"
                + "* @throws IOException If there is an error during XML parsing.\n"
                + "*/\n"
                + "@Test publicVoidTestXmpIntegerRepresentation_InvalidInteger_ShouldHandleGracefully() throws IOException {\n"
                + "String xmlContent = \"<?xml version=\\"1.0\\" encoding=\\"UTF-8\\"?>\n\" +\n"
                + "\"<x:xmpmeta xmlns:x=\\"adobe:ns:meta/\\" x:xmptk=\\"3.1-beta1\\">\n\" +\n"
                + "\"  <rdf:RDF xmlns:rdf=\\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\\">\n\" +\n"
                + "\"    <rdf:Description xmlns:dc=\\"http://purl.org/dc/elements/1.1/\\" rdf:about=\\"\\">\n\" +\n"
                + "\"      <custom:integerProperty xmlns:custom=\\"http://example.com/custom/\">not_an_integer</custom:integerProperty>\n\" +\n"
                           "    </rdf:Description>\n" +
                           "  </rdf:RDF>\n" +
                           "</x:xmpmeta>";

        Element xmpMeta = XMPMetadataParser.parseXMPMetadata(xmlContent);
        assertNotNull(xmpMeta, "XMP metadata should be parsed successfully even with invalid content.");

        // Find the element; it should still be parsed as text if not an integer type
        Element integerElement = XMLUtil.findElement(xmpMeta, "custom:integerProperty", "http://example.com/custom/");
        assertNotNull(integerElement, "Custom property element should still be found.");
        // The parser might return the content as is if it cannot parse it strictly as an integer type.
        // The requirement is about *representation*, so we check if the content is preserved.
        assertEquals("not_an_integer", integerElement.getTextContent(), "The text content should be preserved as is when not a valid integer.");
    }

    /**
     * Tests the representation when an XMP Integer property is missing.
     * This checks that the system doesn't fail if the property is absent.
     * 
     * @throws IOException If there is an error during XML parsing.
     */
    @Test publicVoidTestXmpIntegerRepresentation_MissingIntegerProperty_ShouldNotFail() throws IOException {
        String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                           "<x:xmpmeta xmlns:x=\"adobe:ns:meta/\" x:xmptk=\"3.1-beta1\">\n" +
                           "  <rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">\n" +
                           "    <rdf:Description xmlns:dc=\"http://purl.org/dc/elements/1.1/\" rdf:about=\"\">\n" +
                           "      <dc:format>image/jpeg</dc:format>\n" +
                           "    </rdf:Description>\n" +
                           "  </rdf:RDF>\n" +
                           "</x:xmpmeta>";

        Element xmpMeta = XMPMetadataParser.parseXMPMetadata(xmlContent);
        assertNotNull(xmpMeta, "XMP metadata should be parsed successfully.");

        // Verify that the specific integer property element is not present
        Element integerElement = XMLUtil.findElement(xmpMeta, "custom:integerProperty", "http://example.com/custom/");
        assertNull(integerElement, "Custom integer property element should not be found when missing.");
    }

    /**
     * Tests the representation of an XMP Integer property with a value of zero.
     * This is a boundary case for integer representation.
     * 
     * @throws IOException If there is an error during XML parsing.
     */
    @Test publicVoidTestXmpIntegerRepresentation_ZeroInteger_ShouldParseCorrectly() throws IOException {
        String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                           "<x:xmpmeta xmlns:x=\"adobe:ns:meta/\" x:xmptk=\"3.1-beta1\">\n" +
                           "  <rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">\n" +
                           "    <rdf:Description xmlns:dc=\"http://purl.org/dc/elements/1.1/\" rdf:about=\"\">\n" +
                           "      <custom:integerProperty xmlns:custom=\"http://example.com/custom/">0</custom:integerProperty>\n" +
                + "\"    </rdf:Description>\n\" +\n"
                + "\"  </rdf:RDF>\n\" +\n"
                + "\"</x:xmpmeta>\";\n"
                + "Element xmpMeta = XMPMetadataParser.parseXMPMetadata(xmlContent);\n"
                + "assertNotNull(xmpMeta, \"XMP metadata should be parsed successfully.\");\n"
                + "Element integerElement = XMLUtil.findElement(xmpMeta, \"custom:integerProperty\", \"http://example.com/custom/\");\n"
                + "assertNotNull(integerElement, \"Custom integer property element should be found.\");\n"
                + "assertEquals(\"0\", integerElement.getTextContent(), \"The text content should be '0' for an integer property.\");\n"
                + "}\n"
                + "/**\n"
                + "* Tests the representation of an XMP Integer property with a negative value.\n"
                + "* This checks handling of negative integers.\n"
                + "*\n"
                + "* @throws IOException If there is an error during XML parsing.\n"
                + "*/\n"
                + "@Test publicVoidTestXmpIntegerRepresentation_NegativeInteger_ShouldParseCorrectly() throws IOException {\n"
                + "String xmlContent = \"<?xml version=\\"1.0\\" encoding=\\"UTF-8\\"?>\n\" +\n"
                + "\"<x:xmpmeta xmlns:x=\\"adobe:ns:meta/\\" x:xmptk=\\"3.1-beta1\\">\n\" +\n"
                + "\"  <rdf:RDF xmlns:rdf=\\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\\">\n\" +\n"
                + "\"    <rdf:Description xmlns:dc=\\"http://purl.org/dc/elements/1.1/\\" rdf:about=\\"\\">\n\" +\n"
                + "\"      <custom:integerProperty xmlns:custom=\\"http://example.com/custom/\">-98765</custom:integerProperty>\n\" +\n"
                           "    </rdf:Description>\n" +
                           "  </rdf:RDF>\n" +
                           "</x:xmpmeta>";

        Element xmpMeta = XMPMetadataParser.parseXMPMetadata(xmlContent);
        assertNotNull(xmpMeta, "XMP metadata should be parsed successfully.");

        Element integerElement = XMLUtil.findElement(xmpMeta, "custom:integerProperty", "http://example.com/custom/");
        assertNotNull(integerElement, "Custom integer property element should be found.");
        assertEquals("-98765", integerElement.getTextContent(), "The text content should be the negative integer value.");
    }

    /**
     * Tests the representation of XMP Integer property with leading/trailing spaces.
     * This scenario checks robustness against minor formatting variations.
     *
     * @throws IOException If there is an error during XML parsing.
     */
    @Test publicVoidTestXmpIntegerRepresentation_SpacedInteger_ShouldHandleGracefully() throws IOException {
        String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                           "<x:xmpmeta xmlns:x=\"adobe:ns:meta/\" x:xmptk=\"3.1-beta1\">\n" +
                           "  <rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">\n" +
                           "    <rdf:Description xmlns:dc=\"http://purl.org/dc/elements/1.1/\" rdf:about=\"\">\n" +
                           "      <custom:integerProperty xmlns:custom=\"http://example.com/custom/">  123  </custom:integerProperty>\n" +
                + "\"    </rdf:Description>\n\" +\n"
                + "\"  </rdf:RDF>\n\" +\n"
                + "\"</x:xmpmeta>\";\n"
                + "Element xmpMeta = XMPMetadataParser.parseXMPMetadata(xmlContent);\n"
                + "assertNotNull(xmpMeta, \"XMP metadata should be parsed successfully.\");\n"
                + "Element integerElement = XMLUtil.findElement(xmpMeta, \"custom:integerProperty\", \"http://example.com/custom/\");\n"
                + "assertNotNull(integerElement, \"Custom integer property element should be found.\");\n"
                + "// PDFBox often trims whitespace during parsing. Asserting the trimmed value.\n"
                + "assertEquals(\"123\", integerElement.getTextContent().trim(), \"The text content should be the trimmed integer value.\");\n"
                + "}\n"
                + "}\n"
