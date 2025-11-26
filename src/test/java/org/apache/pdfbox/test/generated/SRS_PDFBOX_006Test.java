package org.apache.pdfbox.test.generated;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for requirement SRS-PDFBOX-006.
 * This class tests the support for sequential definition of values for OECFType.
 */
class SRS_PDFBOX_006Test {

    private PDDocument document;

    @BeforeEach
    void setUp() throws IOException {
        document = new PDDocument();
        // Add a dummy signature field to allow adding signatures
        COSDictionary pageDict = new COSDictionary();
        COSArray contentsArray = new COSArray();
        pageDict.setItem(COSName.CONTENTS, contentsArray);
        document.getDocumentCatalog().getPages().toList().forEach(page -> page.getCOSObject().setItem(COSName.CONTENTS, contentsArray));
    }

    @AfterEach
    void tearDown() throws IOException {
        if (document != null) {
            document.close();
        }
    }

    /**
     * Tests the sequential definition of OECFType values when multiple signatures are added.
     * This covers sequences of OECF entries within signature dictionaries.
     *
     * @throws IOException if an error occurs during PDF manipulation.
     */
    @Test
    @DisplayName("Test sequential OECFType definition with multiple signatures")
    void testSequentialOECFTypeDefinitionMultipleSignatures() throws IOException {
        // Create two dummy signatures with different OECFType values
        PDSignature signature1 = createDummySignature("OECF_Type1");
        PDSignature signature2 = createDummySignature("OECF_Type2");

        // Add signatures to the document (simulating sequential definition)
        document.addSignature(signature1, new ByteArrayInputStream(new byte[0]));
        document.addSignature(signature2, new ByteArrayInputStream(new byte[0]));

        // Retrieve all signatures from the document
        List<PDSignature> signatures = document.getSignatureDictionaries();

        assertNotNull(signatures, "Signatures list should not be null.");
        assertEquals(2, signatures.size(), "Expected two signatures to be present.");

        // Verify the OECFType values are correctly set and accessible sequentially
        // PDFBox typically stores signatures in an array, and we expect the order to be preserved.
        // The COS dictionary for the signature is what holds the OECF entry.
        COSBase cosOECF1 = signatures.get(0).getCOSObject().getItem(COSName.getPDFName("OECF"));
        COSBase cosOECF2 = signatures.get(1).getCOSObject().getItem(COSName.getPDFName("OECF"));

        assertNotNull(cosOECF1, "OECF entry for the first signature should exist.");
        assertTrue(cosOECF1 instanceof COSDictionary, "OECF entry for the first signature should be a dictionary.");
        assertEquals("OECF_Type1", ((COSDictionary) cosOECF1).getString(COSName.getPDFName("Type")), "OECF Type for the first signature is incorrect.");

        assertNotNull(cosOECF2, "OECF entry for the second signature should exist.");
        assertTrue(cosOECF2 instanceof COSDictionary, "OECF entry for the second signature should be a dictionary.");
        assertEquals("OECF_Type2", ((COSDictionary) cosOECF2).getString(COSName.getPDFName("Type")), "OECF Type for the second signature is incorrect.");
    }

    /**
     * Tests the scenario where OECFType is defined within a single signature dictionary.
     * This validates that OECFType can be correctly set and retrieved from a single entry.
     *
     * @throws IOException if an error occurs during PDF manipulation.
     */
    @Test
    @DisplayName("Test single OECFType definition within a signature")
    void testSingleOECFTypeDefinition() throws IOException {
        PDSignature signature = createDummySignature("OECF_SingleType");

        document.addSignature(signature, new ByteArrayInputStream(new byte[0]));

        List<PDSignature> signatures = document.getSignatureDictionaries();
        assertNotNull(signatures, "Signatures list should not be null.");
        assertEquals(1, signatures.size(), "Expected one signature to be present.");

        COSBase cosOECF = signatures.get(0).getCOSObject().getItem(COSName.getPDFName("OECF"));
        assertNotNull(cosOECF, "OECF entry should exist.");
        assertTrue(cosOECF instanceof COSDictionary, "OECF entry should be a dictionary.");
        assertEquals("OECF_SingleType", ((COSDictionary) cosOECF).getString(COSName.getPDFName("Type")), "OECF Type is incorrect.");
    }

    /**
     * Tests the handling of a signature without an OECFType entry.
     * This is an edge case to ensure robustness when the OECFType is absent.
     *
     * @throws IOException if an error occurs during PDF manipulation.
     */
    @Test
    @DisplayName("Test signature without OECFType")
    void testSignatureWithoutOECFType() throws IOException {
        PDSignature signature = new PDSignature(); // Signature without explicit OECF
        // Simulate adding the signature to the COS layer directly to bypass some checks for test purposes
        COSDictionary sigDict = signature.getCOSObject();
        sigDict.setDirect(true);
        document.addXObject(sigDict, COSName.SIG_FIELD);

        List<PDSignature> signatures = document.getSignatureDictionaries();
        assertFalse(signatures.isEmpty(), "Signatures list should not be empty.");
        assertEquals(1, signatures.size(), "Expected one signature.");

        // Verify that attempting to access OECF returns null or an appropriate value if not present
        COSBase cosOECF = signatures.get(0).getCOSObject().getItem(COSName.getPDFName("OECF"));
        assertNull(cosOECF, "OECF entry should not exist if not defined.");
    }

    /**
     * Tests the scenario where OECFType is defined with different data types (e.g., String instead of Dictionary).
     * This is an edge case to check how PDFBox handles malformed OECF entries.
     *
     * @throws IOException if an error occurs during PDF manipulation.
     */
    @Test
    @DisplayName("Test OECFType with incorrect data type")
    void testOECFTypeIncorrectDataType() throws IOException {
        PDSignature signature = new PDSignature();
        COSDictionary sigDict = signature.getCOSObject();
        sigDict.setItem(COSName.getPDFName("OECF"), COSString.fromString("ThisIsNotADictionary")); // Incorrect type
        sigDict.setDirect(true);
        document.addXObject(sigDict, COSName.SIG_FIELD);

        List<PDSignature> signatures = document.getSignatureDictionaries();
        assertFalse(signatures.isEmpty(), "Signatures list should not be empty.");
        assertEquals(1, signatures.size(), "Expected one signature.");

        COSBase cosOECF = signatures.get(0).getCOSObject().getItem(COSName.getPDFName("OECF"));
        assertNotNull(cosOECF, "OECF entry should exist.");
        // The requirement implies sequential *definition* of values, not necessarily parsing of incorrect types.
        // If the parser is strict, this might throw an exception, or it might just treat it as an invalid entry.
        // For this test, we mainly check if the item is present and its type if it's not the expected dictionary.
        assertTrue(cosOECF instanceof COSString, "OECF entry should be a COSString if defined incorrectly.");
        assertEquals("ThisIsNotADictionary", ((COSString) cosOECF).getString(), "Incorrect string value for OECF.");
    }

    /**
     * Helper method to create a dummy signature with a specified OECFType.
     * 
     * @param oecfType The value for the OECF Type field.
     * @return A PDSignature object with the specified OECFType.
     * @throws IOException if an error occurs.
     */
    private PDSignature createDummySignature(String oecfType) throws IOException {
        PDSignature signature = new PDSignature();
        COSDictionary sigDict = signature.getCOSObject();

        COSDictionary oecfDict = new COSDictionary();
        oecfDict.setItem(COSName.TYPE, COSName.getPDFName(oecfType)); // Using TYPE as placeholder for the actual OECF type value
        sigDict.setItem(COSName.getPDFName("OECF"), oecfDict);

        // Add other necessary dictionary items for a valid signature if required by PDFBox internally
        sigDict.setItem(COSName.FILTER, COSName.getPDFName("Adobe.PPKLite"));
        sigDict.setItem(COSName.SUBFILTER, COSName.getPDFName("adbe.pkcs7.detached"));
        sigDict.setItem(COSName.BYTE_RANGE, new COSArray());
        sigDict.setItem(COSName.CONTENTS, new COSString(new byte[10]));

        return signature;
    }
}
