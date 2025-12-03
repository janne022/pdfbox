package org.apache.pdfbox.test.generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class Functionality`arrayproperty`ReturnElements026Test {

    // Dummy ArrayProperty class for testing purposes
    private static class ArrayProperty {
        private List<String> elements;

        public ArrayProperty(List<String> elements) {
            this.elements = elements;
        }

        public List<String> getElements() {
            return Collections.unmodifiableList(this.elements);
        }
    }

    @Test
    public void testReturnElementsAsUnmodifiableListSimpleCase() {
        List<String> originalList = Arrays.asList("item1", "item2");
        ArrayProperty arrayProperty = new ArrayProperty(originalList);
        List<String> returnedList = arrayProperty.getElements();

        Assertions.assertEquals(2, returnedList.size());
        Assertions.assertEquals("item1", returnedList.get(0));
        Assertions.assertEquals("item2", returnedList.get(1));
    }

    @Test
    public void testReturnedListIsUnmodifiable() {
        List<String> originalList = Arrays.asList("elementA", "elementB");
        ArrayProperty arrayProperty = new ArrayProperty(originalList);
        List<String> returnedList = arrayProperty.getElements();

        boolean isUnmodifiable = false;
        try {
            returnedList.add("newElement");
        } catch (UnsupportedOperationException e) {
            isUnmodifiable = true;
        }

        Assertions.assertTrue(isUnmodifiable, "The returned list should be unmodifiable");
    }

    @Test
    public void testModificationToOriginalListDoesNotAffectReturnedList() {
        List<String> originalList = new java.util.ArrayList<>(Arrays.asList("first", "second"));
        ArrayProperty arrayProperty = new ArrayProperty(originalList);
        List<String> returnedList = arrayProperty.getElements();

        Assertions.assertEquals(2, returnedList.size());

        originalList.add("third");

        Assertions.assertEquals(2, returnedList.size(), "Returned list size should not change after original list modification");
        Assertions.assertEquals("first", returnedList.get(0));
        Assertions.assertEquals("second", returnedList.get(1));
    }
}