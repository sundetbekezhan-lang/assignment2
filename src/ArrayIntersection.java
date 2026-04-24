public class ArrayIntersection {
    /// Returns array intersection of two arrays (unique elements only).
    public static IntArray intersect(IntArray A, IntArray B) {
        IntArray result = new IntArray();
        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            // Check if val exists in B
            boolean inB = false;
            for (int j = 0; j < B.size(); j++) {
                if (B.get(j) == val) { inB = true; break; }
            }
            // Check not already added to result (uniqueness)
            if (inB && result.indexOf(val) == -1) {
                result.add(val);
            }
        }
        return result;
    }

    /// main method that tests the class.
    static void main() {
        IntArray A = new IntArray(new int[]{1, 2, 2, 3, 4});
        IntArray B = new IntArray(new int[]{2, 2, 3, 5, 6});
        IntArray result = intersect(A, B);
        System.out.println("A: " + A);           // [1, 2, 2, 3, 4]
        System.out.println("B: " + B);           // [2, 2, 3, 5, 6]
        System.out.println("Intersection: " + result); // [2, 3]

        // Edge cases
        IntArray C = new IntArray(new int[]{1, 2, 3});
        IntArray D = new IntArray(new int[]{4, 5, 6});
        System.out.println("No overlap: " + intersect(C, D)); // []

        IntArray E = new IntArray(new int[]{1, 1, 1});
        IntArray F = new IntArray(new int[]{1, 1, 2});
        System.out.println("Duplicates: " + intersect(E, F)); // [1]
    }
}