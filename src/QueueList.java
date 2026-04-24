public class QueueList implements IntQueue {
    private IntList list;

    public QueueList() {
        list = new IntList();
    }

    /// Tests if this queue is empty.
    @Override
    public boolean empty() {
        return list.isEmpty();
    }

    /// Enqueues an item at the tail.
    @Override
    public void add(int item) {
        list.addLast(item);
    }

    /// Retrieves but does not remove the head.
    @Override
    public int peek() {
        if (empty()) throw new RuntimeException("Queue is empty");
        return list.getFirst();
    }

    /// Retrieves and removes the head.
    @Override
    public int remove() {
        if (empty()) throw new RuntimeException("Queue is empty");
        return list.removeFirst();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    /// main method to test the class.
    static void main() {
        QueueList queue = new QueueList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("Queue: " + queue);          // [1, 2, 3]
        System.out.println("Peek: " + queue.peek());    // 1
        System.out.println("Remove: " + queue.remove()); // 1
        System.out.println("After remove: " + queue);  // [2, 3]
        System.out.println("Empty: " + queue.empty()); // false
    }
}