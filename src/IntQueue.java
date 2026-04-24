public interface IntQueue {
    /// Tests if this queue is empty.
    boolean empty();
    /// Inserts the specified item into this queue.
    void add(int item);
    /// Retrieves, but does not remove, the head of this queue, if the queue is not empty.
    int peek();
    /// Retrieves and removes the head of this queue.
    int remove();
}