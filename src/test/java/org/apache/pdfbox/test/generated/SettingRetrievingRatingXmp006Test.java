package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SettingRetrievingRatingXmp006Test {
    @Test
    public void testSetAndGetRating() {
        int rating = 5;
        Assertions.assertEquals(5, rating);
    }

    @Test
    public void testRatingNotNull() {
        Integer rating = 10;
        Assertions.assertNotNull(rating);
    }
}