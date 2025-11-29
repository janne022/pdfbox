package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class RegisterBouncycastleSecurityProvider126Test {

    @Test
    public void testBouncyCastleIsRegistered() {
        Security.addProvider(new BouncyCastleProvider());
        boolean isRegistered = Security.getProvider("BC") != null;
        Assertions.assertTrue(isRegistered, "BC Provider should be registered");
    }

    @Test
    public void testProviderInstanceIsNotNull() {
        BouncyCastleProvider provider = new BouncyCastleProvider();
        Assertions.assertNotNull(provider, "Provider instance should not be null");
    }
}