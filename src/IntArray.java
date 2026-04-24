/// A resizable array of integers.
/// It grows internally when items are added and shrinks when items are removed.
public class IntArray {
    /// Internal int[] representation of IntArray.
    private int[] array;
    /// Number of elements in the array.
    private int size;

    ///  Initializes the array with a default size and capacity (e.g. size is 0 and capacity is 4).
    public IntArray() {
        array = new int[4];
        size = 0;
    }

    /// Initializes the array by adding the items from an int[] array.
    public IntArray(int[] items) {
        array = new int[Math.max(items.length * 2, 4)];
        size = 0;
        for (int item : items) {
            add(item);
        }
    }

    // Getter for size.
    public int size() {
        return size;
    }

    ///  Returns the item at the index position in the array.
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return array[index];
    }

    ///  Updates the item at index position and returns the old item.
    public int set(int index, int item) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        int old = array[index];
        array[index] = item;
        return old;
    }

    ///  Adds a new item to the array at the end position.
    public void add(int item) {
        ensureCapacity();
        array[size++] = item;
    }

    ///  Inserts a new item to the array at the index position.
    public void addAt(int index, int item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        ensureCapacity();
        // Shift elements right
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    /// Removes the item at index i and returns it.
    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        int removed = array[index];
        // Shift elements left
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        shrinkIfNeeded();
        return removed;
    }

    /// Removes the first item and returns it.
    public int removeFirst() {
        return remove(0);
    }

    /// Removes the last item and returns it.
    public int removeLast() {
        return remove(size - 1);
    }

    /// Removes the first occurrence of an item and returns whether the item was found.
    public boolean removeItem(int item) {
        int idx = indexOf(item);
        if (idx == -1) return false;
        remove(idx);
        return true;
    }

    /// Returns the index of the first occurrence of an item or -1.
    public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (array[i] == item) return i;
        }
        return -1;
    }

    /// Returns true if there are no elements in the array.
    public boolean isEmpty() {
        return size == 0;
    }

    /// Returns a string representation of the array, e.g. "[1, 2, 3]".
    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Doubles capacity when array is full.
    private void ensureCapacity() {
        if (size == array.length) {
            int[] newArray = new int[array.length * 2];
            for (int i = 0; i < size; i++) newArray[i] = array[i];
            array = newArray;
        }
    }

    // Halves capacity when array is less than 25% full (min capacity 4).
    private void shrinkIfNeeded() {
        if (size > 0 && size <= array.length / 4 && array.length > 4) {
            int[] newArray = new int[Math.max(array.length / 2, 4)];
            for (int i = 0; i < size; i++) newArray[i] = array[i];
            array = newArray;
        }
    }

    ///  main method to test the class.
    static void main(String[] args) {
        IntArray a = new IntArray();
        a.add(5);
        a.add(10);
        a.add(15);
        System.out.println("Size: " + a.size());       // 3
        System.out.println("Get(0): " + a.get(0));     // 5
        System.out.println(a);                          // [5, 10, 15]
        a.addAt(1, 7);
        System.out.println("After addAt(1,7): " + a);  // [5, 7, 10, 15]
        System.out.println("Remove(2): " + a.remove(2)); // 10
        System.out.println("After remove(2): " + a);   // [5, 7, 15]
        System.out.println("indexOf(7): " + a.indexOf(7)); // 1
        System.out.println("isEmpty: " + a.isEmpty()); // false
    }
}