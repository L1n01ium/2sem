import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyArrayListTest {
    private MyArrayList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    void addAndGet() {
        list.add("A");
        list.add("B");
        Assertions.assertEquals("A", list.get(0));
        Assertions.assertEquals("B", list.get(1));
    }

    @Test
    void addAtIndex() {
        list.add(0, "A");
        list.add(1, "C");
        list.add(1, "B");
        Assertions.assertEquals("A", list.get(0));
        Assertions.assertEquals("B", list.get(1));
        Assertions.assertEquals("C", list.get(2));
    }

    @Test
    void removeByIndex() {
        list.add("A");
        list.add("B");
        list.add("C");

        Assertions.assertEquals("B", list.remove(1));
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("A", list.get(0));
        Assertions.assertEquals("C", list.get(1));

        Assertions.assertEquals("A", list.remove(0));
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals("C", list.get(0));

        Assertions.assertEquals("C", list.remove(0));
        Assertions.assertEquals(0, list.size());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    void removeByItem() {
        list.add("A");
        list.add("B");
        list.add("A");
        list.add(null);
        list.add("C");

        Assertions.assertTrue(list.remove("A"));
        Assertions.assertEquals(4, list.size());
        Assertions.assertEquals("B", list.get(0));
        Assertions.assertEquals("A", list.get(1));
        Assertions.assertNull(list.get(2));
        Assertions.assertEquals("C", list.get(3));

        Assertions.assertTrue(list.remove(null));
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("B", list.get(0));
        Assertions.assertEquals("A", list.get(1));
        Assertions.assertEquals("C", list.get(2));

        Assertions.assertFalse(list.remove("X"));
        Assertions.assertEquals(3, list.size());
    }

    @Test
    void sizeAndIsEmpty() {
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(0, list.size());

        list.add("A");
        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(1, list.size());

        list.remove(0);
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void clear() {
        list.add("A");
        list.add("B");
        list.clear();
        Assertions.assertEquals(0, list.size());
        Assertions.assertTrue(list.isEmpty());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }
}