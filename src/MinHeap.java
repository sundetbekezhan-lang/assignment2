public class MinHeap implements IntQueue {
    private IntArray data;

    public MinHeap() {
        data = new IntArray();
    }

    /// Tests if the heap is empty.
    @Override
    public boolean empty() {
        return data.isEmpty();
    }

    /// Inserts an item and sifts it up to restore heap order.
    @Override
    public void add(int item) {
        data.add(item);
        siftUp(data.size() - 1);
    }

    /// Returns the minimum item (root) without removing it.
    @Override
    public int peek() {
        if (empty()) throw new RuntimeException("Heap is empty");
        return data.get(0);
    }

    /// Removes and returns the minimum item (root).
    /// Replaces root with the last element, then sifts down.
    @Override
    public int remove() {
        if (empty()) throw new RuntimeException("Heap is empty");
        int min = data.get(0);
        int last = data.removeLast();
        if (!data.isEmpty()) {
            data.set(0, last);
            siftDown(0);
        }
        return min;
    }

    /// Sifts element at index i up until heap property is restored.
    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (data.get(i) < data.get(parent)) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    /// Sifts element at index i down until heap property is restored.
    private void siftDown(int i) {
        int n = data.size();
        while (true) {
            int left  = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < n && data.get(left) < data.get(smallest))
                smallest = left;
            if (right < n && data.get(right) < data.get(smallest))
                smallest = right;

            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int tmp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, tmp);
    }

    @Override
    public String toString() {
        return data.toString();
    }

    /// Sorts an IntArray in descending order using the MinHeap.
    /// Adds all elements to the heap, then removes them in ascending order
    /// and fills the result array from the back → descending.
    public static IntArray sortDescending(IntArray arr) {
        MinHeap heap = new MinHeap();
        for (int i = 0; i < arr.size(); i++) {
            heap.add(arr.get(i));
        }
        IntArray sorted = new IntArray();
        // Extract all in ascending order, build a temp array
        IntArray ascending = new IntArray();
        while (!heap.empty()) {
            ascending.add(heap.remove());
        }
        // Reverse to descending
        for (int i = ascending.size() - 1; i >= 0; i--) {
            sorted.add(ascending.get(i));
        }
        return sorted;
    }

    ///  main method to test the class.
    static void main() {
        // Test basic MinHeap
        MinHeap heap = new MinHeap();
        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);
        heap.add(4);
        System.out.println("Heap after inserts: " + heap);
        System.out.println("Peek (min): " + heap.peek()); // 1
        System.out.println("Remove: " + heap.remove());   // 1
        System.out.println("Remove: " + heap.remove());   // 3
        System.out.println("Heap now: " + heap);

        // Test descending sort
        IntArray arr = new IntArray(new int[]{4, 2, 7, 1, 9, 3});
        System.out.println("Original: " + arr);
        IntArray sorted = sortDescending(arr);
        System.out.println("Sorted descending: " + sorted); // [9, 7, 4, 3, 2, 1]
    }
}