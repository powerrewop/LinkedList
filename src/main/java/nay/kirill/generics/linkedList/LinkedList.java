package nay.kirill.generics.linkedList;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LinkedList<TItem> {

    private int size = 0;

    public int size() {
        return size;
    }

    // Первый элемент списка
    private Node<TItem> tail = null;

    // Последний элемент списка
    private Node<TItem> head = null;

    public void add(TItem item) {
        Node<TItem> node = new Node<>(item, tail);
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void remove(TItem item) {
        Node<TItem> node = head;
        while (node != null) {
            if (node.item == item) {
                final Node<TItem> next = node.next;
                final Node<TItem> prev = node.prev;

                // Если элемент является первым в списке, то переопределяем head
                if (prev == null) {
                    head = next;
                } else {
                    prev.next = next;
                }

                // Если элемент является последним в списке, то переопределяем tail
                if (next == null) {
                    tail = prev;
                } else {
                    next.prev = prev;
                }

                size--;
            }

            node = node.next;
        }
    }

    public TItem get(int index) {
        // Проверяем границы index
        if (index >= size) throw new IllegalArgumentException("index can't be large than size!");
        if (index < 0) throw new IllegalArgumentException("index can't be less than zero");

        Node<TItem> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.item;
    }

    public void addAll(LinkedList<? extends TItem> items) {
        for (Node<? extends TItem> node = items.head; node != null; node = node.next) {
            add(node.item);
        }
    }

    static class Node<TItem> {

        public Node(@NotNull TItem item, @Nullable Node<TItem> prev) {
            this.item = item;
            this.prev = prev;
        }

        @NotNull
        private final TItem item;

        // Следующий узел в списке
        @Nullable
        private Node<TItem> next;

        // Предыдущий узел в списке
        @Nullable
        private Node<TItem> prev;

    }

}
