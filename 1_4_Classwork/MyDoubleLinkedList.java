public class MyDoubleLinkedList<T> implements MyList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void add(T item) {

    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("aga");
        }
        Node<T> newNode = new Node<>(item);
        if (size == 0) {
            head = tail = newNode;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node<T> nodeAtIndex = getNode(index);
            Node<T> prevNode = nodeAtIndex.prev;

            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = nodeAtIndex;
            nodeAtIndex.prev = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("aga");
        }
        return getNode(index).data;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("aga");
        }
        Node<T> nodeToRemove = getNode(index);
        T data = nodeToRemove.data;
        if (size == 1) {
            head = tail = null;
        } else if (nodeToRemove == head) {
            head = head.next;
            head.prev = null;
        } else if (nodeToRemove == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
        }
        size--;
        return data;
    }

    @Override
    public boolean remove(T item) {
        Node<T> current = head;
        while (current != null) {
            if ((current.data == null && item == null) || (current.data != null && current.data.equals(item))) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
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
        head = tail = null;
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

    private Node<T> getNode(int index) {
        if (index < size / 2) {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            Node<T> current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
    }
}
