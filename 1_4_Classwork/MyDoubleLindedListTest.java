import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyDoubleLindedListTest {
    private MyDoubleLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyDoubleLinkedList<>();
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
    }

    @Test
    void removeByItem() {
        list.add("A");
        list.add("B");
        list.add(null);
        Assertions.assertTrue(list.remove("B"));
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals("A", list.get(0));
        Assertions.assertNull(list.get(1));

        Assertions.assertTrue(list.remove(null));
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals("A", list.get(0));

        Assertions.assertFalse(list.remove("Z"));
    }

    @Test
    void sizeAndIsEmpty() {
        Assertions.assertTrue(list.isEmpty());
        list.add("X");
        Assertions.assertEquals(1, list.size());
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void clear() {
        list.add("A");
        list.add("B");
        list.clear();
        Assertions.assertEquals(0, list.size());
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    void containsAndIndexOf() {
        list.add("A");
        list.add("B");
        list.add(null);
        Assertions.assertTrue(list.contains("B"));
        Assertions.assertTrue(list.contains(null));
        Assertions.assertEquals(1, list.indexOf("B"));
        Assertions.assertEquals(2, list.indexOf(null));
        Assertions.assertEquals(-1, list.indexOf("Z"));
    }
}