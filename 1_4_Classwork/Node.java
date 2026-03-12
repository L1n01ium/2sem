public class Node<E> {
    E data;
    Node<E> next;
    Node<E> prev;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public Node(E data) {
        this.data = data;
    }
}
