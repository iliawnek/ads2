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
     * by default, create a new heap with capacity = 7 (height = 3)
     */
    public Heap() {
        this(7);
    }


    @SuppressWarnings("unchecked")
    private int compare(Object x, Object y) {
        return ((E) x).compareTo((E) y);
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
     * @return element with smallest key (without removing it)
     * @throws HeapException if heap is empty
     */
    @SuppressWarnings("unchecked")
    public E min() throws HeapException {
        if (isEmpty()) {
            throw new HeapException("Heap underflow: cannot return an element from an empty heap.");
        }



        return (E) H[1];
    }


    /**
     * @param e is the element to be inserted into the heap
     * @throws HeapException if the heap is full
     */
    public void insert(E e) throws HeapException {
    }


    /**
     * @return the minimum element, and remove it from the heap
     * @throws HeapException if the heap is empty
     */
    @SuppressWarnings("unchecked")
    public E removeMin() throws HeapException {
        return null;
    }


    /**
     * @return elements in H in the order H[1] to H[last]
     */
    public String toString() {
        return "implement me";
    }

}

