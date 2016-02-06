public class ArrayQueue<E> {

    public static final int CAPACITY = 10;  // default queue capacity
    private E[] Q;          // E array used to implement the queue
    private int n;          // actual capacity of queue
    private int front;      // index for the top of queue
    private int rear;       // rear of the queue
    private int size;       // size of the queue

    public ArrayQueue() {
        this(CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.n = capacity;
        Q = (E[]) new Object[this.n];
        front = rear = size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E front() throws ArrayQueueException {
        return Q[front];
    }

    public void enqueue(E element) throws ArrayQueueException {
        if (size == n) {
            throw new ArrayQueueException();
        }
        else {
            Q[rear] = element;
            rear = (rear + 1) % n;
            size++;
        }
    }


    public E dequeue() throws ArrayQueueException {
        if (size == 0) {
            throw new ArrayQueueException();
        }
        else {
            E dequeuedElement = Q[front];
            Q[front] = null;
            front = (front + 1) % n;
            size--;
            return dequeuedElement;
        }
    }

    public String toString() {
        String s = "[";
        int cursor = front;
        for (int i = 0; i < size - 1; i++) {
            s += Q[cursor].toString();
            s += ",";
            cursor = (cursor + 1) % n;
        }
        if (size > 0) {
            s += Q[(rear - 1) == -1 ? n - 1 : rear - 1];
        }
        return s + "]";
    }
}

