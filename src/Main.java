public class Main {
    public static void main(String[] args) {

        // ── IntArray ──────────────────────────────────────
        System.out.println("=== IntArray ===");
        IntArray a = new IntArray();
        a.add(1); a.add(2); a.add(3);
        System.out.println(a);               // [1, 2, 3]
        a.addAt(1, 99);
        System.out.println(a);               // [1, 99, 2, 3]
        a.remove(1);
        System.out.println(a);               // [1, 2, 3]
        System.out.println(a.get(0));        // 1
        System.out.println(a.indexOf(2));    // 1
        System.out.println(a.size());        // 3

        // ── ArrayIntersection ─────────────────────────────
        System.out.println("\n=== ArrayIntersection ===");
        IntArray x = new IntArray(new int[]{1, 2, 2, 3});
        IntArray y = new IntArray(new int[]{2, 3, 4});
        System.out.println(ArrayIntersection.intersect(x, y)); // [2, 3]

        // ── IntList ───────────────────────────────────────
        System.out.println("\n=== IntList ===");
        IntList list = new IntList();
        list.addLast(1); list.addLast(2); list.addLast(3);
        list.addFirst(0);
        System.out.println(list);            // [0, 1, 2, 3]
        list.remove(1);
        System.out.println(list);            // [0, 2, 3]
        list.reverse();
        System.out.println(list);            // [3, 2, 0]

        // ── StackArray ────────────────────────────────────
        System.out.println("\n=== StackArray ===");
        StackArray stack = new StackArray();
        stack.push(1); stack.push(2); stack.push(3);
        System.out.println(stack.peek());    // 3
        System.out.println(stack.pop());     // 3
        System.out.println(stack.pop());     // 2
        System.out.println(stack.empty());   // false

        // ── StackQueue ────────────────────────────────────
        System.out.println("\n=== StackQueue ===");
        StackQueue sq = new StackQueue();
        sq.push(1); sq.push(2); sq.push(3);
        System.out.println(sq.peek());       // 3
        System.out.println(sq.pop());        // 3
        System.out.println(sq.pop());        // 2
        System.out.println(sq.empty());      // false

        // ── QueueList ─────────────────────────────────────
        System.out.println("\n=== QueueList ===");
        QueueList queue = new QueueList();
        queue.add(1); queue.add(2); queue.add(3);
        System.out.println(queue.peek());    // 1
        System.out.println(queue.remove());  // 1
        System.out.println(queue.remove());  // 2
        System.out.println(queue.empty());   // false

        // ── QueueStack ────────────────────────────────────
        System.out.println("\n=== QueueStack ===");
        QueueStack qs = new QueueStack();
        qs.add(1); qs.add(2); qs.add(3);
        System.out.println(qs.peek());       // 1
        System.out.println(qs.remove());     // 1
        System.out.println(qs.remove());     // 2
        System.out.println(qs.empty());      // false

        // ── MinHeap ───────────────────────────────────────
        System.out.println("\n=== MinHeap ===");
        MinHeap heap = new MinHeap();
        heap.add(5); heap.add(3); heap.add(8); heap.add(1);
        System.out.println(heap.peek());     // 1
        System.out.println(heap.remove());   // 1
        System.out.println(heap.remove());   // 3

        // ── Descending Sort ───────────────────────────────
        System.out.println("\n=== Descending Sort ===");
        IntArray arr = new IntArray(new int[]{4, 2, 7, 1, 9, 3});
        System.out.println(arr);                              // [4, 2, 7, 1, 9, 3]
        System.out.println(MinHeap.sortDescending(arr));      // [9, 7, 4, 3, 2, 1]
    }
}