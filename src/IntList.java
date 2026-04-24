public class IntList {
    private Node head;
    private int size;

    public IntList() {
        head = null;
        size = 0;
    }

    /// Returns the number of items in the list.
    public int size() {
        return size;
    }

    /// Returns true if the list has no items.
    public boolean isEmpty() {
        return size == 0;
    }

    /// Inserts the specified item at the beginning of this list.
    public void addFirst(int item) {
        head = new Node(item, head);
        size++;
    }

    /// Appends the specified item to the end of this list.
    public void addLast(int item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = newNode;
        }
        size++;
    }

    /// Inserts the specified item at the specified position in this list.
    public void add(int index, int item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index);
        if (index == 0) { addFirst(item); return; }
        Node curr = head;
        for (int i = 0; i < index - 1; i++) curr = curr.next;
        curr.next = new Node(item, curr.next);
        size++;
    }

    /// Returns the item at the specified position in this list.
    public int get(int index) {
        checkIndex(index);
        Node curr = head;
        for (int i = 0; i < index; i++) curr = curr.next;
        return curr.value;
    }

    /// Returns the first item in this list.
    public int getFirst() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return head.value;
    }

    /// Returns the last item in this list.
    public int getLast() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        return curr.value;
    }

    /// Replaces the item at the specified position in this list with the specified item.
    public int set(int index, int item) {
        checkIndex(index);
        Node curr = head;
        for (int i = 0; i < index; i++) curr = curr.next;
        int old = curr.value;
        curr.value = item;
        return old;
    }

    /// Returns the index of the first occurrence, or -1.
    public int indexOf(int item) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.value == item) return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }

    /// Removes the item at the specified position in this list.
    public int remove(int index) {
        checkIndex(index);
        int removed;
        if (index == 0) {
            removed = head.value;
            head = head.next;
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) curr = curr.next;
            removed = curr.next.value;
            curr.next = curr.next.next;
        }
        size--;
        return removed;
    }

    /// Removes the first occurrence of the specified item from this list, if present.
    public boolean removeItem(int item) {
        int idx = indexOf(item);
        if (idx == -1) return false;
        remove(idx);
        return true;
    }

    /// Removes and returns the first item from this list.
    public int removeFirst() {
        return remove(0);
    }

    /// Reverses the list in place (iterative approach).
    public void reverse() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node curr = head;
        while (curr != null) {
            sb.append(curr.value);
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    // Internal class that represents a list node.
    static class Node {
        int value;
        Node next;
        Node() {}
        Node(int value) { this.value = value; }
        Node(int value, Node next) { this.value = value; this.next = next; }
    }

    /// main method to test the class.
    static void main() {
        IntList list = new IntList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);
        System.out.println("List: " + list);          // [0, 1, 2, 3]
        System.out.println("Size: " + list.size());   // 4
        System.out.println("Get(2): " + list.get(2)); // 2
        System.out.println("First: " + list.getFirst()); // 0
        System.out.println("Last: " + list.getLast());   // 3
        list.reverse();
        System.out.println("Reversed: " + list);      // [3, 2, 1, 0]
        list.removeItem(2);
        System.out.println("After removeItem(2): " + list); // [3, 1, 0]
    }
}