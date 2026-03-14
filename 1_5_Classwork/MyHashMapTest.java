import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;

public class MyHashMapTest {
    private MyHashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new MyHashMap<>();
    }

    @Test
    void testPutAndGet() {
        assertNull(map.put("one", 1));
        assertNull(map.put("two", 2));
        assertEquals(2, map.size());
        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
        assertNull(map.get("three"));
    }

    @Test
    void testPutOverwrite() {
        map.put("one", 1);
        assertEquals(1, map.put("one", 11));
        assertEquals(11, map.get("one"));
        assertEquals(1, map.size());
    }

    @Test
    void testRemove() {
        map.put("one", 1);
        map.put("two", 2);
        assertEquals(2, map.size());
        assertEquals(1, map.remove("one"));
        assertEquals(1, map.size());
        assertNull(map.get("one"));
        assertNull(map.remove("three"));
    }

    @Test
    void testContainsKey() {
        map.put("one", 1);
        assertTrue(map.containsKey("one"));
        assertFalse(map.containsKey("two"));
        assertFalse(map.containsKey(null));
    }

    @Test
    void testContainsValue() {
        map.put("one", 1);
        map.put("two", 2);
        assertTrue(map.containsValue(1));
        assertTrue(map.containsValue(2));
        assertFalse(map.containsValue(3));
        assertFalse(map.containsValue(null));
    }

    @Test
    void testNullKey() {
        map.put(null, 100);
        assertTrue(map.containsKey(null));
        assertEquals(100, map.get(null));
        assertEquals(100, map.remove(null));
        assertFalse(map.containsKey(null));
        assertNull(map.get(null));
    }

    @Test
    void testNullValue() {
        map.put("one", null);
        assertTrue(map.containsValue(null));
        assertNull(map.get("one"));
        assertTrue(map.containsKey("one"));
        map.put("one", 1);
        assertEquals(1, map.get("one"));
        assertFalse(map.containsValue(null));
    }

    @Test
    void testSizeAndIsEmpty() {
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
        map.put("one", 1);
        assertFalse(map.isEmpty());
        assertEquals(1, map.size());
        map.remove("one");
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
    }

    @Test
    void testClear() {
        map.put("one", 1);
        map.put("two", 2);
        map.clear();
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
        assertNull(map.get("one"));
        assertFalse(map.containsKey("two"));
    }

    @Test
    void testResize() {
        for (int i = 0; i < 20; i++) {
            map.put("key" + i, i);
        }
        assertEquals(20, map.size());
        for (int i = 0; i < 20; i++) {
            assertEquals(i, map.get("key" + i));
        }
    }

    @Test
    void testCollisions() {
        class CollidingKey {
            private final int id;
            CollidingKey(int id) {
                this.id = id;
            }
            @Override
            public int hashCode() {
                return 42;
            }
            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                CollidingKey other = (CollidingKey) obj;
                return id == other.id;
            }
        }
        MyHashMap<CollidingKey, String> map2 = new MyHashMap<>();
        CollidingKey key1 = new CollidingKey(1);
        CollidingKey key2 = new CollidingKey(2);
        CollidingKey key3 = new CollidingKey(3);

        map2.put(key1, "A");
        map2.put(key2, "B");
        map2.put(key3, "C");

        assertEquals("A", map2.get(key1));
        assertEquals("B", map2.get(key2));
        assertEquals("C", map2.get(key3));
        assertEquals(3, map2.size());

        assertEquals("B", map2.remove(key2));
        assertNull(map2.get(key2));
        assertEquals(2, map2.size());
        assertEquals("A", map2.get(key1));
        assertEquals("C", map2.get(key3));
    }

    @Test
    void testEqualsNotReference() {
        class Key {
            private final String s;
            Key(String s) {
                this.s = s;
            }
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Key key = (Key) o;
                return Objects.equals(s, key.s);
            }
            @Override
            public int hashCode() {
                return Objects.hashCode(s);
            }
        }
        MyHashMap<Key, Integer> map2 = new MyHashMap<>();
        Key key1 = new Key("a");
        Key key2 = new Key("a");
        map2.put(key1, 10);
        assertTrue(map2.containsKey(key2));
        assertEquals(10, map2.get(key2));
    }
}