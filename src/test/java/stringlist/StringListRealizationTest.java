package stringlist;

import exception.StringListIndexOutOfBoundsException;
import exception.StringListNullPointerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        // ожидаем исключение при добавлении null
        assertThrows(StringListNullPointerException.class,
                () -> list.add(null));

        String expected1 = "expected1";
        String expected2 = "expected2";
        list.add(expected1);
        assertEquals(expected1, list.get(3));
        assertEquals(expected2, list.add(expected2));

        // ожидаем исключение при добавлении элемента в заполненный лист
        assertThrows(StringListIndexOutOfBoundsException.class,
                () -> list.add("This item will not be added"));
    }

    @Test
    void shouldAddElementByIndexCorrectly() {
        // ожидаем исключение при добавлении null, по отрицательному индексу и индексу больше чем size
        assertThrows(StringListNullPointerException.class,
                () -> list.add(0, null));
        assertThrows(StringListIndexOutOfBoundsException.class,
                () -> list.add(-1, "This item will not be added"));
        assertThrows(StringListIndexOutOfBoundsException.class,
                () -> list.add(list.size() + 1, "This item will not be added"));

        String expected1 = "expected1";
        String expected2 = "expected2";
        int expectedListSize = list.size();
        list.add(0, expected1);
        // после успешного добавления одного элемента size должен увеличиться на 1
        assertEquals(expectedListSize + 1, list.size());
        assertEquals(expected1, list.get(0));
        assertEquals(expected2, list.add(2, expected2));

        // так как equals от Object не переопределён, сравниваем лист в цикле с ожидаемым после проделанных тестов
        StringList expectedAfterAddTest = new StringListRealization(5);
        expectedAfterAddTest.add("expected1");
        expectedAfterAddTest.add("one");
        expectedAfterAddTest.add("expected2");
        expectedAfterAddTest.add("two");
        expectedAfterAddTest.add("three");
        for (int i = 0; i < list.size(); i++) {
            assertEquals(expectedAfterAddTest.get(i), list.get(i));
        }
    }

    @Test
    void set() {
        // ожидаем исключение при изменении на null, по отрицательному индексу и индексу больше чем size
        assertThrows(StringListNullPointerException.class,
                () -> list.set(0, null));
        assertThrows(StringListIndexOutOfBoundsException.class,
                () -> list.set(-1, "This item will not be set"));
        assertThrows(StringListIndexOutOfBoundsException.class,
                () -> list.set(list.size() + 1, "This item will not be set"));

        String expected1 = "expected1";
        String expected2 = "expected2";
        int expectedSize = list.size();
        list.set(0, expected1);
        assertEquals(expected1, list.get(0));
        assertEquals(expected2, list.set(2, expected2));
        // после успешного изменения элемента size должен остаться прежним
        assertEquals(expectedSize, list.size());
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