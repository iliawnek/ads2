public class Heap<E extends Comparable<E>> {

    private Object[] H;   // contains the objects in the heap
    private int last;     // index of last element in heap
    private int capacity; // max number of elements in heap


    /**
     * create a heap with capacity n
     */
    public Heap(int n) {
        capacity = n;
        H = new Object[capacity + 1];
        last = 0;
    }


    /**
     * by default, create a new heap with capacity = 7 (max height = 3)
     */
    public Heap() {
        this(7);
    }


    /**
     * @param x is an object x you want to compare with object y
     * @param y is an object y you want to compare with object x
     * @return < 0 if x < y
     *          = 0 if x == y
     *          > 0 if x > y
     */
    @SuppressWarnings("unchecked")
    private int compare(Object x, Object y) {
        return ((E) x).compareTo((E) y);
    }


    /**
     * @param x is index of element x in heap you want to swap with element y
     * @param y is index of element y in heap you want to swap with element x
     * @throws HeapException if x and y do not refer to elements in the heap.
     */
    @SuppressWarnings("unchecked")
    private void swap(int x, int y) throws HeapException {
        if (x > last || y > last || x < 0 || y < 0) {
            throw new HeapException("Indices x and y must refer to an element within the heap.");
        }
        E temp = (E) H[x];
        H[x] = H[y];
        H[y] = temp;
    }


    /**
     * @return number of elements in the heap
     */
    public int size() {
        return last;
    }


    /**
     * @return true if heap is empty
     */
    public boolean isEmpty() {
        return last == 0;
    }


    /**
     * @return true if heap is full
     */
    public boolean isFull() {
        return last == capacity;
    }


    /**
     * @return element with smallest key (without removing it)
     * @throws HeapException if heap is empty
     */
    @SuppressWarnings("unchecked")
    public E min() throws HeapException {
        return (E) H[minIndex()];
    }


    /**
     * @return the index of the minimum element in the heap
     */
    @SuppressWarnings("unchecked")
    private int minIndex() throws HeapException {
        if (isEmpty()) {
            throw new HeapException("Heap underflow: cannot get element from an empty heap.");
        }

        // if only one element in heap, return it (minimum by default)
        if (size() == 1) {
            return 1;
        }

        int minIndex = 1;
        E minElement = (E) H[minIndex];
        for (int i = 2; i <= size(); i++) {
            // store new minElement and minIndex if less than current min
            if (compare(minElement, H[i]) < 0) {
                minIndex = i;
                minElement = (E) H[minIndex];
            }
        }

        return minIndex;
    }


    /**
     * @param e is the element to be inserted into the heap
     * @throws HeapException if the heap is full
     */
    public void insert(E e) throws HeapException {
        if (isFull()) {
            throw new HeapException("Heap overflow: cannot insert an element into a full heap.");
        }
    }


    /**
     * @return the minimum element, and remove it from the heap
     * @throws HeapException if the heap is empty
     */
    @SuppressWarnings("unchecked")
    public E removeMin() throws HeapException {
        if (isEmpty()) {
            throw new HeapException("Heap underflow: cannot remove an element from an empty heap.");
        }
        return null;
    }


    /**
     * @return elements in H in the order H[1] to H[last]
     */
    public String toString() {
        return "implement me";
    }

}

