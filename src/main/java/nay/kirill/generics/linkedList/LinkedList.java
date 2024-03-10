package nay.kirill.generics.linkedList;

public class LinkedList<TItem> {

    private int size = 0;

    public int size() {
        return size;
    }

    // Последний элемент списка
    private Node<TItem> head = null;

    // Первый элемент списка
    private Node<TItem> tail = null;

    public void add(TItem item) {
        Node<TItem> node = new Node<>(item, head);
        if (head == null) {
            tail = node;
        } else {
            head.next = node;
        }
        head = node;
        size++;
    }

    public void remove(TItem item) {
        Node<TItem> node = tail;
        while (node != null) {
            if (node.item == item) {
                final Node<TItem> next = node.next;
                final Node<TItem> prev = node.prev;

                if (prev == null) {
                    tail = next;
                } else {
                    prev.next = next;
                }

                if (next == null) {
                    head = prev;
                } else {
                    next.prev = prev;
                }

                size--;
            }

            node = node.next;
        }
    }

    public TItem get(int index) {
        if (index >= size) throw new IllegalArgumentException("index can't be large than size!");
        if (index < 0) throw new IllegalArgumentException("index can't be less than zero");

        Node<TItem> node = tail;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.item;
    }

    public void addAll(LinkedList<? extends TItem> items) {
        for (Node<? extends TItem> node = items.tail; node != null; node = node.next) {
            add(node.item);
        }
    }

    static class Node<TItem> {

        public Node(TItem item, Node<TItem> prev) {
            this.item = item;
            this.prev = prev;
        }

        private final TItem item;

        private Node<TItem> next;

        private Node<TItem> prev;

    }

}
