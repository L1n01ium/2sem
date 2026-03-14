import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyHashSetTest {
    private MyHashSet<String> set;

    @BeforeEach
    void setUp() {
        set = new MyHashSet<>();
    }

    @Test
    void testAddUnique() {
        assertTrue(set.add("one"));
        assertTrue(set.add("two"));
        assertEquals(2, set.size());
        assertTrue(set.contains("one"));
        assertTrue(set.contains("two"));
    }

    @Test
    void testAddDuplicate() {
        assertTrue(set.add("one"));
        assertFalse(set.add("one"));
        assertEquals(1, set.size());
    }

    @Test
    void testRemove() {
        set.add("one");
        set.add("two");
        assertTrue(set.remove("one"));
        assertEquals(1, set.size());
        assertFalse(set.contains("one"));
        assertFalse(set.remove("three"));
        assertEquals(1, set.size());
    }

    @Test
    void testContains() {
        set.add("one");
        assertTrue(set.contains("one"));
        assertFalse(set.contains("two"));
        assertFalse(set.contains(null));
    }

    @Test
    void testSizeAndIsEmpty() {
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
        set.add("one");
        assertFalse(set.isEmpty());
        assertEquals(1, set.size());
        set.remove("one");
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    @Test
    void testClear() {
        set.add("one");
        set.add("two");
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
        assertFalse(set.contains("one"));
        assertFalse(set.contains("two"));
    }

    @Test
    void testNull() {
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
        assertEquals(1, set.size());
        assertTrue(set.remove(null));
        assertEquals(0, set.size());
        assertFalse(set.contains(null));
    }
}
