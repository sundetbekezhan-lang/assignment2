public class StackArray implements IntStack {
    private IntArray data;

    public StackArray() {
        data = new IntArray();
    }

    /// Tests if this stack is empty.
    @Override
    public boolean empty() {
        return data.isEmpty();
    }

    /// Looks at the top item without removing it.
    @Override
    public int peek() {
        if (empty()) throw new RuntimeException("Stack is empty");
        return data.get(data.size() - 1);
    }

    /// Removes and returns the top item.
    @Override
    public int pop() {
        if (empty()) throw new RuntimeException("Stack is empty");
        return data.removeLast();
    }

    /// Pushes an item onto the top of this stack.
    @Override
    public void push(int item) {
        data.add(item);
    }

    @Override
    public String toString() {
        return data.toString();
    }

    static void main() {
        StackArray stack = new StackArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + stack);        // [1, 2, 3]
        System.out.println("Peek: " + stack.peek());  // 3
        System.out.println("Pop: " + stack.pop());    // 3
        System.out.println("After pop: " + stack);    // [1, 2]
        System.out.println("Empty: " + stack.empty()); // false
    }
}