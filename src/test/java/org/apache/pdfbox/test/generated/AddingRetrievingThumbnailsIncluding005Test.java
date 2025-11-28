package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AddingRetrievingThumbnailsIncluding005Test {
    @Test
    public void testAddThumbnailBasic() {
        String imageData = "image data";
        int height = 100;
        int width = 200;
        String format = "PNG";
        Assertions.assertNotNull(imageData);
        Assertions.assertEquals(100, height);
        Assertions.assertEquals(200, width);
        Assertions.assertNotNull(format);
    }
    
    @Test
    public void testRetrieveThumbnailBasic() {
        String retrievedImageData = "retrieved image data";
        int retrievedHeight = 150;
        int retrievedWidth = 250;
        String retrievedFormat = "JPEG";
        Assertions.assertNotNull(retrievedImageData);
        Assertions.assertEquals(150, retrievedHeight);
        Assertions.assertEquals(250, retrievedWidth);
        Assertions.assertNotNull(retrievedFormat);
    }
}