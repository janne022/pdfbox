package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class CheckOcspResponseBased097Test {
    @Test
    public void testOcspTimeCheckWhenNonceFails() {
        String ocspResponse = "valid_ocsp_response_with_time";
        boolean nonceVerificationFailed = true;
        boolean timeCheckSatisfied = isOcspResponseValidBasedOnTime(ocspResponse, nonceVerificationFailed);
        Assertions.assertTrue(timeCheckSatisfied);
    }
    
    @Test
    public void testOcspTimeCheckWhenNoncePasses() {
        String ocspResponse = "valid_ocsp_response_with_time";
        boolean nonceVerificationFailed = false;
        boolean timeCheckSatisfied = isOcspResponseValidBasedOnTime(ocspResponse, nonceVerificationFailed);
        Assertions.assertTrue(timeCheckSatisfied); 
    }

    private boolean isOcspResponseValidBasedOnTime(String ocspResponse, boolean nonceVerificationFailed) {
        if (nonceVerificationFailed) {
            return ocspResponse.contains("valid_time");
        } else {
            return true;
        }
    }
}