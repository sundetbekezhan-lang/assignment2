public class QueueStack implements IntQueue {
    // s1 is the main stack; s2 is a temporary helper
    private StackArray s1;
    private StackArray s2;

    public QueueStack() {
        s1 = new StackArray();
        s2 = new StackArray();
    }

    /// Tests if this queue is empty.
    @Override
    public boolean empty() {
        return s1.empty();
    }

    /// Enqueues an item at the tail.
    /// Strategy: move all from s1 to s2, push new item to s1,
    /// then move all back from s2 to s1. The oldest item sits on top.
    /// (O(n) add, O(1) remove/peek)
    @Override
    public void add(int item) {
        // Move all items from s1 to s2
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        // Push the new item to the bottom
        s1.push(item);
        // Move all items back from s2 to s1
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
    }

    /// Retrieves but does not remove the head.
    @Override
    public int peek() {
        if (empty()) throw new RuntimeException("Queue is empty");
        return s1.peek();
    }

    /// Retrieves and removes the head.
    @Override
    public int remove() {
        if (empty()) throw new RuntimeException("Queue is empty");
        return s1.pop();
    }

    @Override
    public String toString() {
        return s1.toString();
    }

    static void main() {
        QueueStack queue = new QueueStack();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("Queue: " + queue);           // [1, 2, 3]
        System.out.println("Peek: " + queue.peek());     // 1
        System.out.println("Remove: " + queue.remove()); // 1
        System.out.println("After remove: " + queue);   // [2, 3]
        System.out.println("Empty: " + queue.empty());  // false
    }
}