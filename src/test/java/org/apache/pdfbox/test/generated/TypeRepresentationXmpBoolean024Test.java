package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.util.XMLUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Requirement SRS-PDFBOX-024: The CSCI shall provide a type representation for XMP boolean properties.
 */
public class TypeRepresentationXmpBoolean024Test {

    private PDDocument document;

    /**
     * Sets up a new empty PDF document before each test.
     */
    @BeforeEach
    void setUp() throws IOException {
        document = new PDDocument();
    }

    /**
     * Closes the PDF document after each test.
     */
    @AfterEach
    void tearDown() throws IOException {
        if (document != null) {
            document.close();
        }
    }

    /**
     * Tests the representation of an XMP boolean property with a true value.
     * Ensures that a "true" boolean is correctly serialized and deserialized.
     *
     * @throws IOException if an error occurs during document processing.
     */
    @Test
    @DisplayName("Test XMP boolean property representation for true value")
    void testXmpBooleanTrueValueRepresentation() throws IOException {
        PDDocumentCatalog catalog = document.getDocumentCatalog();
        PDMetadata metadata = new PDMetadata(document);
        catalog.setMetadata(metadata);

        String xmpString = "<?xpacket begin='" + (char) 65533 + "' id='W5M0MpCehiHzreSzNTczkc9d'?>" +
                           "<x:xmpmeta xmlns:x='adobe:ns:meta/' xmlns:rdf='http://www.w3.org/1999/02/22-rdf-syntax-ns#'>" +
                           "<rdf:RDF>" +
                           "<rdf:Description rdf:about='' xmlns:test='http://example.com/ns/'>" +
                           "<test:AValue rdf:datatype='http://www.w3.org/2001/XMLSchema#boolean'>true</test:AValue>" +
                           "</rdf:Description>" +
                           "</rdf:RDF>" +
                           "</x:xmpmeta>" +
                           "<?xpacket end='w'?>";

        metadata.importXMPMetadata(new ByteArrayInputStream(xmpString.getBytes("UTF-8")));
        document.save(new java.io.ByteArrayOutputStream()); // Force serialization

        String exportedXmp = metadata.exportXMPMetadataAsString();
        
        assertNotNull(exportedXmp, "Exported XMP metadata should not be null");
        assertTrue(exportedXmp.contains("<test:AValue rdf:datatype='http://www.w3.org/2001/XMLSchema#boolean'>true</test:AValue>"), "Exported XMP should contain the true boolean representation");
        
        // Further verification by re-parsing and checking the COS object
        PDMetadata reloadedMetadata = new PDMetadata(document);
        catalog.setMetadata(reloadedMetadata);
        
        // Manually simulate metadata import to get the COS object
        String xmlString = exportedXmp.substring(exportedXmp.indexOf("<"), exportedXmp.lastIndexOf(">") + 1);
        Element rootElement = XMLUtil.parse(new ByteArrayInputStream(xmlString.getBytes("UTF-8")));
        java.util.List<Element> descriptions = XMLUtil.getChildElements(rootElement, "rdf:RDF").get(0);
        descriptions = XMLUtil.getChildElements(descriptions.get(0), "rdf:Description");
        Element descriptionElement = descriptions.get(0);
        java.util.List<Element> properties = XMLUtil.getChildElementsByLocalName(descriptionElement, "AValue");
        Element propertyElement = properties.get(0);
        String dataType = propertyElement.getAttributeNode("rdf:datatype").getValue();
        String value = propertyElement.getTextContent();

        assertEquals("http://www.w3.org/2001/XMLSchema#boolean", dataType, "Datatype should be boolean");
        assertEquals("true", value, "Value should be true");

        COSBase cosObject = metadata.getCOSObject();
        assertNotNull(cosObject, "COS object for metadata should exist");
        assertTrue(cosObject instanceof org.apache.pdfbox.cos.COSStream, "COS object should be a stream");
        // Deeper verification would involve inspecting the XMP stream content, which is complex.
        // This test primarily focuses on the successful export/import and string containment.
    }

    /**
     * Tests the representation of an XMP boolean property with a false value.
     * Ensures that a "false" boolean is correctly serialized and deserialized.
     *
     * @throws IOException if an error occurs during document processing.
     */
    @Test
    @DisplayName("Test XMP boolean property representation for false value")
    void testXmpBooleanFalseValueRepresentation() throws IOException {
        PDDocumentCatalog catalog = document.getDocumentCatalog();
        PDMetadata metadata = new PDDocumentMetadata(document);
        catalog.setMetadata(metadata);

        String xmpString = "<?xpacket begin='" + (char) 65533 + "' id='W5M0MpCehiHzreSzNTczkc9d'?>" +
                           "<x:xmpmeta xmlns:x='adobe:ns:meta/' xmlns:rdf='http://www.w3.org/1999/02/22-rdf-syntax-ns#'>" +
                           "<rdf:RDF>" +
                           "<rdf:Description rdf:about='' xmlns:test='http://example.com/ns/'>" +
                           "<test:AValue rdf:datatype='http://www.w3.org/2001/XMLSchema#boolean'>false</test:AValue>" +
                           "</rdf:Description>" +
                           "</rdf:RDF>" +
                           "</x:xmpmeta>" +
                           "<?xpacket end='w'?>";

        metadata.importXMPMetadata(new ByteArrayInputStream(xmpString.getBytes("UTF-8")));
        document.save(new java.io.ByteArrayOutputStream()); // Force serialization

        String exportedXmp = metadata.exportXMPMetadataAsString();

        assertNotNull(exportedXmp, "Exported XMP metadata should not be null");
        assertTrue(exportedXmp.contains("<test:AValue rdf:datatype='http://www.w3.org/2001/XMLSchema#boolean'>false</test:AValue>"), "Exported XMP should contain the false boolean representation");

        // Further verification by re-parsing and checking the COS object
        PDMetadata reloadedMetadata = new PDMetadata(document);
        catalog.setMetadata(reloadedMetadata);

        String xmlString = exportedXmp.substring(exportedXmp.indexOf("<"), exportedXmp.lastIndexOf(">") + 1);
        Element rootElement = XMLUtil.parse(new ByteArrayInputStream(xmlString.getBytes("UTF-8")));
        java.util.List<Element> descriptions = XMLUtil.getChildElements(rootElement, "rdf:RDF").get(0);
        descriptions = XMLUtil.getChildElements(descriptions.get(0), "rdf:Description");
        Element descriptionElement = descriptions.get(0);
        java.util.List<Element> properties = XMLUtil.getChildElementsByLocalName(descriptionElement, "AValue");
        Element propertyElement = properties.get(0);
        String dataType = propertyElement.getAttributeNode("rdf:datatype").getValue();
        String value = propertyElement.getTextContent();

        assertEquals("http://www.w3.org/2001/XMLSchema#boolean", dataType, "Datatype should be boolean");
        assertEquals("false", value, "Value should be false");
    }

    /**
     * Tests the handling of invalid XMP boolean representations.
     * This test checks that non-standard boolean values are handled gracefully, potentially
     * by not being recognized as booleans or by causing parsing issues (depending on PDFBox implementation).
     * For this test, we expect it to be parsed as a string or to be ignored if strictly validating.
     *
     * @throws IOException if an error occurs during document processing.
     */
    @Test
    @DisplayName("Test XMP boolean property representation with invalid value")
    void testXmpBooleanInvalidValueRepresentation() throws IOException {
        PDDocumentCatalog catalog = document.getDocumentCatalog();
        PDMetadata metadata = new PDMetadata(document);
        catalog.setMetadata(metadata);

        String xmpString = "<?xpacket begin='" + (char) 65533 + "' id='W5M0MpCehiHzreSzNTczkc9d'?>" +
                           "<x:xmpmeta xmlns:x='adobe:ns:meta/' xmlns:rdf='http://www.w3.org/1999/02/22-rdf-syntax-ns#'>" +
                           "<rdf:RDF>" +
                           "<rdf:Description rdf:about='' xmlns:test='http://example.com/ns/'>" +
                           "<test:AValue rdf:datatype='http://www.w3.org/2001/XMLSchema#boolean'>invalid</test:AValue>" +
                           "</rdf:Description>" +
                           "</rdf:RDF>" +
                           "</x:xmpmeta>" +
                           "<?xpacket end='w'?>";

        // PDFBox might parse this as a string if it's not strictly conforming
        // or it might throw an error during XMP processing.
        // We will assert that it doesn't crash and the export is as expected (likely as a string).
        assertDoesNotThrow(() -> metadata.importXMPMetadata(new ByteArrayInputStream(xmpString.getBytes("UTF-8"))), "Importing invalid boolean should not throw an exception");

        document.save(new java.io.ByteArrayOutputStream()); // Force serialization
        String exportedXmp = metadata.exportXMPMetadataAsString();
        
        assertNotNull(exportedXmp, "Exported XMP metadata should not be null");
        // The expectation here is that PDFBox might export it as a plain string if it couldn't parse it as boolean
        // or might filter it out. Checking for containment of the original string, assuming minimal modification.
        assertTrue(exportedXmp.contains("<test:AValue rdf:datatype='http://www.w3.org/2001/XMLSchema#boolean'>invalid</test:AValue>") || 
                   !exportedXmp.contains("<test:AValue"), 
                   "Exported XMP should handle invalid boolean representation gracefully (either as string or omitted)");

        // If PDFBox strictly interprets datatypes and rejects invalid ones, the above `assertTrue` might fail.
        // A more robust negative test would require knowing PDFBox's exact parsing strategy for invalid datatypes.
        // For now, we ensure no exceptions and observe exported behavior.
    }
    
    /**
     * Tests the XMP representation when no boolean property is present.
     * Ensures that the absence of a boolean property is handled correctly.
     *
     * @throws IOException if an error occurs during document processing.
     */
    @Test
    @DisplayName("Test XMP document without boolean property")
    void testXmpDocumentWithoutBooleanProperty() throws IOException {
        PDDocumentCatalog catalog = document.getDocumentCatalog();
        PDMetadata metadata = new PDDocumentMetadata(document);
        catalog.setMetadata(metadata);

        String xmpString = "<?xpacket begin='" + (char) 65533 + "' id='W5M0MpCehiHzreSzNTczkc9d'?>" +
                           "<x:xmpmeta xmlns:x='adobe:ns:meta/' xmlns:rdf='http://www.w3.org/1999/02/22-rdf-syntax-ns#'>" +
                           "<rdf:RDF>" +
                           "<rdf:Description rdf:about='' xmlns:test='http://example.com/ns/'>" +
                           "<test:SomeOtherProperty>SomeValue</test:SomeOtherProperty>" +
                           "</rdf:Description>" +
                           "</rdf:RDF>" +
                           "</x:xmpmeta>" +
                           "<?xpacket end='w'?>";

        metadata.importXMPMetadata(new ByteArrayInputStream(xmpString.getBytes("UTF-8")));
        document.save(new java.io.ByteArrayOutputStream()); // Force serialization

        String exportedXmp = metadata.exportXMPMetadataAsString();

        assertNotNull(exportedXmp, "Exported XMP metadata should not be null");
        assertTrue(exportedXmp.contains("<test:SomeOtherProperty>SomeValue</test:SomeOtherProperty>"), "Exported XMP should contain other properties");
        assertFalse(exportedXmp.contains("rdf:datatype='http://www.w3.org/2001/XMLSchema#boolean'"), "Exported XMP should not contain boolean datatype if none was present");
    }
}