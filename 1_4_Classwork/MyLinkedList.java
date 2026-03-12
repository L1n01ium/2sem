public class MyLinkedList<T> implements MyList<T> {

    private Node<T> head;
    private int size;

    @Override
    public void add(T item) {
        if (head == null) {
            head = new Node<>(item);
        } else {
            Node<T> node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(item);
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("ne");
        }
        Node<T> newNode = new Node<>(item);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("AAAAA");
        }
        int counter = 0;
        Node<T> node = head;
        while (counter < index) {
            node = node.next;
            counter++;
        }
        return node.data;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("ne");
        }
        T removedData;
        if (index == 0) {
            removedData = head.data;
            head = head.next;
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            removedData = prev.next.data;
            prev.next = prev.next.next;
        }
        size--;
        return removedData;
    }

    @Override
    public boolean remove(T item) {
        if (head == null) {
            return false;
        }
        if (head.data.equals(item) || (head.data == null && item == null)) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if ((current.next.data == null && item == null) || (current.next.data != null && current.next.data.equals(item))) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(T item) {
        int index = 0;
        Node<T> current = head;
        while (current != null) {
            if ((current.data == null && item == null) || (current.data != null && current.data.equals(item))) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
}