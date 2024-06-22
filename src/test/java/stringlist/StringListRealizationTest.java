package stringlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringListRealizationTest {

    private StringList list;

    @BeforeEach
    public void setUp() {
        list = new StringListRealization(5);
        list.add("one");
        list.add("two");
        list.add("three");
    }

    @Test
    void shouldAddElementCorrectly() {
        String expected = "four";
        list.add(expected);
        assertEquals(expected, list.get(4));
    }

    @Test
    void testAdd() {
    }

    @Test
    void set() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void contains() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void lastIndexOf() {
    }

    @Test
    void get() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void clear() {
    }

    @Test
    void toArray() {
    }
}