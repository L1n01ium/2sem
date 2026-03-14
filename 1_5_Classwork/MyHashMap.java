public class MyHashMap<K, V> implements MyMap<K, V> {

    private Node<K, V>[] buckets;
    private int size;
    private int threshold;
    private float loadFactor = 0;
    private static final int CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public MyHashMap() {
        this.loadFactor = loadFactor;
        buckets = (Node<K, V>[]) new Node[CAPACITY];
        size = 0;
    }

    public MyHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException();
        }
        this.loadFactor = loadFactor;
        int capacity = 1;
        while (capacity < initialCapacity) {
            capacity <<= 1;
        }
        buckets = (Node<K, V>[]) new Node[capacity];
        threshold = (int) (capacity * loadFactor);
        size = 0;
    }

    public MyHashMap(float loadFactor) {

        this.loadFactor = loadFactor;
    }

    @Override
    public V put(K key, V value) {
        int index = getBucketIndex(key, buckets.length);
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key == key || (key != null && key.equals(current.key))) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
        if (size > threshold) {
            resize();
        }
        return null;
    }

    private void resize() {
        int oldCapacity = buckets.length;
        int newCapacity = oldCapacity << 1;
        Node<K, V>[] newBuckets = (Node<K, V>[]) new Node[newCapacity];
        for (int i = 0; i < oldCapacity; i++) {
            Node<K, V> node = buckets[i];
            while (node != null) {
                Node<K, V> next = node.next;
                int newIndex = getBucketIndex(node.key, newCapacity);
                node.next = newBuckets[newIndex];
                newBuckets[newIndex] = node;
                node = next;
            }
        }
        buckets = newBuckets;
        threshold = (int) (newCapacity * loadFactor);
    }

    private int hash(Object key) {
        return (key == null) ? 0 : key.hashCode() ^ (key.hashCode() >>> 16);
    }

    private int getBucketIndex(Object key, int length) {
        return (hash(key) & 0x7fffffff) % length;
    }

    @Override
    public V get(Object key) {
        int index = getBucketIndex(key, buckets.length);
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key == key || (key != null && key.equals(current.key))) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = getBucketIndex(key, buckets.length);
        Node<K, V> current = buckets[index];
        Node<K, V> prev = null;
        while(current != null) {
            if (current.key == key || (key != null && key.equals(current.key))) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        int index = getBucketIndex(key, buckets.length);
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key == key || (key != null && key.equals(current.key))) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < buckets.length; i++) {
            Node<K, V> current = buckets[i];
            while (current != null) {
                if (value == null) {
                    if (current.value == null) {
                        return true;
                    }
                } else {
                    if (value.equals(current.value)) {
                        return true;
                    }
                }
                current = current.next;
            }
        }
        return false;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        size = 0;
    }
}
