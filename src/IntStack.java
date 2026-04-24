public interface IntStack {
    /// Tests if this stack is empty.
    boolean empty();
    /// Looks at the item at the top of this stack without removing it from the stack.
    int peek();
    /// Removes the object at the top of this stack and returns that object as the value of this function.
    int pop();
    /// Pushes an item onto the top of this stack.
    void push(int item);
}