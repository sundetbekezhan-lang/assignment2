public class StackQueue implements IntStack {
    // q1 holds all elements; q2 is a temporary helper
    private QueueList q1;
    private QueueList q2;

    public StackQueue() {
        q1 = new QueueList();
        q2 = new QueueList();
    }

    /// Tests if this stack is empty.
    @Override
    public boolean empty() {
        return q1.empty();
    }

    /// Pushes an item onto the top of the stack.
    /// Strategy: enqueue new item to q2, then drain q1 into q2,
    /// then swap q1 and q2. This keeps the most-recently-pushed
    /// item at the front of q1 (O(n) push, O(1) pop/peek).
    @Override
    public void push(int item) {
        q2.add(item);
        while (!q1.empty()) {
            q2.add(q1.remove());
        }
        // Swap q1 and q2
        QueueList temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /// Looks at the top item without removing it.
    @Override
    public int peek() {
        if (empty()) throw new RuntimeException("Stack is empty");
        return q1.peek();
    }

    /// Removes and returns the top item.
    @Override
    public int pop() {
        if (empty()) throw new RuntimeException("Stack is empty");
        return q1.remove();
    }

    @Override
    public String toString() {
        return q1.toString();
    }

    static void main() {
        StackQueue stack = new StackQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack);         // [3, 2, 1]
        System.out.println("Peek: " + stack.peek());   // 3
        System.out.println("Pop: " + stack.pop());     // 3
        System.out.println("After pop: " + stack);     // [2, 1]
        System.out.println("Empty: " + stack.empty()); // false
    }
}