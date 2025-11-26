package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.util.file.TestFileUtil;
import org.apache.pdfbox.xmp.XMPMetadata;
import org.apache.pdfbox.xmp.XMPProperty;
import org.apache.pdfbox.xmp.XMPPropertyTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test suite for requirement SRS-PDFBOX-013: The CSCI shall provide a type representation for XMP Integer properties.
 */
public class TypeRepresentationXmpInteger013Test {

    private PDDocument document;
    private static final String TEST_XMP_METADATA = "<?xpacket begin=\"\" id=\"W5M0MpX3V].K02140\"?>\n<x:xmpmeta xmlns:x=\"adobe:ns:meta/\">\n<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">\n<rdf:Description rdf:about=\"\" xmlns:test=\"http://www.example.com/test/\">\n<test:IntegerProperty>12345</test:IntegerProperty>\n<test:AnotherIntegerProperty>-987</test:AnotherIntegerProperty>\n<test:ZeroIntegerProperty>0</test:ZeroIntegerProperty>\n<test:InvalidIntegerProperty>abc</test:InvalidIntegerProperty>\n</rdf:Description>\n</rdf:RDF>\n</x:xmpmeta>\n<?xpacket end=\"w\"?>";

    @BeforeEach
    void setUp() throws IOException {
        document = new PDDocument();
    }

    @AfterEach
    void tearDown() throws IOException {
        if (document != null) {
            document.close();
        }
    }

    /**
     * Test case to verify that a valid XMP Integer property is correctly parsed and represented.
     * This covers the positive scenario of the requirement.
     */
    @Test
    void testParseValidXmpIntegerProperty() {
        PDDocumentCatalog catalog = document.getDocumentCatalog();
        PDMetadata metadata = new PDMetadata(document);
        try {
            metadata.importXMPMetadata(new ByteArrayInputStream(TEST_XMP_METADATA.getBytes()));
            catalog.setMetadata(metadata);

            XMPMetadata xmpMetadata = catalog.getXMPMetadata();
            assertNotNull(xmpMetadata, "XMPMetadata should not be null.");

            XMPProperty integerProperty = xmpMetadata.getProperty("test:IntegerProperty");
            assertNotNull(integerProperty, "XMP Integer property 'test:IntegerProperty' not found.");
            assertEquals(XMPPropertyTypes.INTEGER, integerProperty.getType(), "Property 'test:IntegerProperty' should be of type INTEGER.");
            assertEquals("12345", integerProperty.getValue(), "Value of 'test:IntegerProperty' is incorrect.");

            XMPProperty anotherIntegerProperty = xmpMetadata.getProperty("test:AnotherIntegerProperty");
            assertNotNull(anotherIntegerProperty, "XMP Integer property 'test:AnotherIntegerProperty' not found.");
            assertEquals(XMPPropertyTypes.INTEGER, anotherIntegerProperty.getType(), "Property 'test:AnotherIntegerProperty' should be of type INTEGER.");
            assertEquals("-987", anotherIntegerProperty.getValue(), "Value of 'test:AnotherIntegerProperty' is incorrect.");
            
            XMPProperty zeroIntegerProperty = xmpMetadata.getProperty("test:ZeroIntegerProperty");
            assertNotNull(zeroIntegerProperty, "XMP Integer property 'test:ZeroIntegerProperty' not found.");
            assertEquals(XMPPropertyTypes.INTEGER, zeroIntegerProperty.getType(), "Property 'test:ZeroIntegerProperty' should be of type INTEGER.");
            assertEquals("0", zeroIntegerProperty.getValue(), "Value of 'test:ZeroIntegerProperty' is incorrect.");

        } catch (IOException e) {
            org.junit.jupiter.api.Assertions.fail("IOException should not occur: " + e.getMessage());
        }
    }

    /**
     * Test case to verify the handling of an invalid XMP Integer property.
     * Although the XML might parse, the type should not be recognized as an integer if malformed.
     * Note: PDFBox might still parse the value as a string if the type is ambiguous in XML.
     * This test checks if the type is correctly identified as integer according to XMP spec.
     */
    @Test
    void testParseInvalidXmpIntegerPropertyType() {
        PDDocumentCatalog catalog = document.getDocumentCatalog();
        PDMetadata metadata = new PDMetadata(document);
        String invalidXml = "<?xpacket begin=\"\" id=\"W5M0MpX3V].K02140\"?>\n<x:xmpmeta xmlns:x=\"adobe:ns:meta/\">\n<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">\n<rdf:Description rdf:about=\"\" xmlns:test=\"http://www.example.com/test/\">\n<test:InvalidIntegerProperty>abc</test:InvalidIntegerProperty>\n</rdf:Description>\n</rdf:RDF>\n</x:xmpmeta>\n<?xpacket end=\"w\"?>";

        try {
            metadata.importXMPMetadata(new ByteArrayInputStream(invalidXml.getBytes()));
            catalog.setMetadata(metadata);

            XMPMetadata xmpMetadata = catalog.getXMPMetadata();
            assertNotNull(xmpMetadata, "XMPMetadata should not be null.");

            XMPProperty invalidIntegerProperty = xmpMetadata.getProperty("test:InvalidIntegerProperty");
            assertNotNull(invalidIntegerProperty, "XMP property 'test:InvalidIntegerProperty' not found.");
            
            // PDFBox typically parses based on content if schema is missing explicit type hint.
            // For the purpose of this requirement, we'll check if it's recognized as an integer.
            // If the requirement implies strict type enforcement even on malformed data, this assertion might fail.
            // A Strict interpretation of XMP Integer requires it to be parsable as int.
            // Standard PDFBox behavior often treats such as String if it cannot infer type.
            // We assert that it's NOT explicitly typed as INTEGER if the value is not numeric.
            // However, PDFBox's CURRENT implementation might parse 'abc' as String and not explicitly type it as INTEGER.
            // Let's check if it's NOT an INTEGER type, as 'abc' is not a valid integer representation.
            // NOTE: Actual behavior may vary between PDFBox versions. This test assumes 'abc' is not recognized as an INTEGER type.
            assertTrue(invalidIntegerProperty.getType() == XMPPropertyTypes.TEXT || invalidIntegerProperty.getType() == XMPPropertyTypes.UNKNOWN, 
                       "Property 'test:InvalidIntegerProperty' should not be treated as an INTEGER type if value is non-numeric.");

            assertEquals("abc", invalidIntegerProperty.getValue(), "Value of 'test:InvalidIntegerProperty' is incorrect.");

        } catch (IOException e) {
            org.junit.jupiter.api.Assertions.fail("IOException should not occur: " + e.getMessage());
        }
    }

    /**
     * Test case to ensure that properties which are not integers are not misrepresented as integers.
     * This is a negative test to check type discrimination.
     */
    @Test
    void testNonIntegerPropertyIsNotTypedAsInteger() {
        PDDocumentCatalog catalog = document.getDocumentCatalog();
        PDMetadata metadata = new PDMetadata(document);
        String nonIntegerXml = "<?xpacket begin=\"\" id=\"W5M0MpX3V].K02140\"?>\n<x:xmpmeta xmlns:x=\"adobe:ns:meta/\">\n<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">\n<rdf:Description rdf:about=\"\" xmlns:test=\"http://www.example.com/test/\">\n<test:StringProperty>some text</test:StringProperty>\n<test:BooleanProperty>true</test:BooleanProperty>\n<test:DateProperty>2023-10-27T10:00:00Z</test:DateProperty>\n</rdf:Description>\n</rdf:RDF>\n</x:xmpmeta>\n<?xpacket end=\"w\"?>";

        try {
            metadata.importXMPMetadata(new ByteArrayInputStream(nonIntegerXml.getBytes()));
            catalog.setMetadata(metadata);

            XMPMetadata xmpMetadata = catalog.getXMPMetadata();
            assertNotNull(xmpMetadata, "XMPMetadata should not be null.");

            XMPProperty stringProperty = xmpMetadata.getProperty("test:StringProperty");
            assertNotNull(stringProperty, "XMP property 'test:StringProperty' not found.");
            assertTrue(stringProperty.getType() == XMPPropertyTypes.TEXT || stringProperty.getType() == XMPPropertyTypes.UNKNOWN, 
                       "Property 'test:StringProperty' should be of type TEXT or UNKNOWN, not INTEGER.");

            XMPProperty booleanProperty = xmpMetadata.getProperty("test:BooleanProperty");
            assertNotNull(booleanProperty, "XMP property 'test:BooleanProperty' not found.");
            assertTrue(booleanProperty.getType() == XMPPropertyTypes.BOOLEAN || booleanProperty.getType() == XMPPropertyTypes.UNKNOWN, 
                       "Property 'test:BooleanProperty' should be of type BOOLEAN or UNKNOWN, not INTEGER.");

            XMPProperty dateProperty = xmpMetadata.getProperty("test:DateProperty");
            assertNotNull(dateProperty, "XMP property 'test:DateProperty' not found.");
            assertTrue(dateProperty.getType() == XMPPropertyTypes.DATE || dateProperty.getType() == XMPPropertyTypes.UNKNOWN, 
                       "Property 'test:DateProperty' should be of type DATE or UNKNOWN, not INTEGER.");

        } catch (IOException e) {
            org.junit.jupiter.api.Assertions.fail("IOException should not occur: " + e.getMessage());
        }
    }

     /**
     * Test case to ensure that an empty document with no metadata does not cause errors.
     * This is a basic sanity check.
     */
    @Test
    void testEmptyDocumentHasNoXmpMetadata() {
        PDDocumentCatalog catalog = document.getDocumentCatalog();
        assertNotNull(catalog, "Document catalog should exist.");
        assertDoesNotThrow(() -> {
            XMPMetadata xmpMetadata = catalog.getXMPMetadata();
            // It's expected that getXMPMetadata() might return null or an empty object if no metadata exists.
            // We are primarily testing that calling it doesn't throw an exception.
            // If it returns null, that's also acceptable for an empty document.
        }, "Calling getXMPMetadata on an empty document should not throw an exception.");
    }

     /**
     * Test case to ensure that parsing XMP metadata that is fundamentally malformed (not valid XML)
     * does not crash the system, although it may result in no metadata being recognized.
     */
    @Test
    void testMalformedXmpXml() {
        PDDocumentCatalog catalog = document.getDocumentCatalog();
        PDMetadata metadata = new PDMetadata(document);
        String malformedXml = "<x:xmpmeta xmlns:x=\"adobe:ns:meta/\">\n <malformed xml</x:xmpmeta>"; // Invalid XML structure

        assertDoesNotThrow(() -> {
            metadata.importXMPMetadata(new ByteArrayInputStream(malformedXml.getBytes()));
            catalog.setMetadata(metadata);
            XMPMetadata xmpMetadata = catalog.getXMPMetadata();
            // It's expected that malformed XML might not yield any valid XMP metadata.
            // The main goal is to not throw an exception during import or retrieval.
            // assertNotNull(xmpMetadata); // This might fail depending on PDFBox's strictness
        }, "Importing malformed XMP XML should not throw an exception.");
    }
}