package stringlist;

import exception.StringListElementNotFoundException;
import exception.StringListIndexOutOfBoundsException;
import exception.StringListNullPointerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void shouldSetElementByIndexCorrectly() {
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
    void shouldRemoveElementByStringValueCorrectly() {
        // ожидаем исключение при удалении null и элемента, которого нет в списке
        assertThrows(StringListNullPointerException.class,
                () -> list.remove(null));
        assertThrows(StringListElementNotFoundException.class,
                () -> list.remove("No such element"));

        String expected = "two";
        int expectedSize = list.size();
        assertEquals(expected, list.remove(expected));
        // после успешного удаление элемента size должен уменьшиться на 1
        assertEquals(expectedSize - 1, list.size());
    }

    @Test
    void shouldRemoveElementByIndexCorrectly() {
        // ожидаем исключение при удалении элемента с индексом меньше 0 или равным и больше size
        assertThrows(StringListIndexOutOfBoundsException.class,
                () -> list.remove(-1));
        assertThrows(StringListIndexOutOfBoundsException.class,
                () -> list.remove(list.size()));
        assertThrows(StringListIndexOutOfBoundsException.class,
                () -> list.remove(list.size() + 1));

        String expected = list.get(1);
        int expectedSize = list.size();
        assertEquals(expected, list.remove(1));
        // после успешного удаления элемента size должен уменьшиться на 1
        assertEquals(expectedSize - 1, list.size());
    }

    @Test
    void shouldCheckContainsElementCorrectly() {
        // ожидаем исключение при передаче null
        assertThrows(StringListNullPointerException.class,
                () -> list.contains(null));

        assertTrue(list.contains(list.get(0)));
        assertFalse(list.contains("There is no such element"));
    }

    @Test
    void shouldReturnIndexOfElementCorrectly() {
        // ожидаем исключение при передаче null
        assertThrows(StringListNullPointerException.class,
                () -> list.indexOf(null));

        int expectedIndex1 = 1;
        int expectedIndex2 = 2;
        int expectedFailIndex = -1;
        assertEquals(expectedIndex1, list.indexOf(list.get(expectedIndex1)));
        assertEquals(expectedIndex2, list.indexOf("three"));
        assertEquals(expectedFailIndex, list.indexOf("There is no such element"));
    }

    @Test
    void shouldReturnLastIndexOfElementCorrectly() {
        // ожидаем исключение при передаче null
        assertThrows(StringListNullPointerException.class,
                () -> list.lastIndexOf(null));

        int expectedFailIndex = -1;
        // добавим в список повторяющиеся элементы для теста
        list.add(0, list.get(0));
        list.add(4, list.get(2));
        assertEquals(1, list.lastIndexOf("one"));
        assertEquals(4, list.lastIndexOf("two"));
        assertEquals(expectedFailIndex, list.lastIndexOf("There is no such element"));
    }

    @Test
    void shouldGetElementCorrectly() {
        // ожидаем исключение, если индекс меньше 0 или >= size
        assertThrows(StringListIndexOutOfBoundsException.class,
                () -> list.get(-1));
        assertThrows(StringListIndexOutOfBoundsException.class,
                () -> list.get(list.size()));
        assertThrows(StringListIndexOutOfBoundsException.class,
                () -> list.get(list.size() + 1));

        String expected1 = "one";
        String expected2 = "two";
        assertEquals(expected1, list.get(0));
        assertEquals(expected2, list.get(list.indexOf(expected2)));
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