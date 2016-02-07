/**
 * Queue implemented using a circular array.
 * @param <E>
 */

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

    /**
     * @return size of queue
     */
    public int size() {
        return size;
    }

    /**
     * @return true if queue is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return element at front of queue
     * @throws ArrayQueueException when queue is empty
     */
    public E front() throws ArrayQueueException {
        if (size == 0) {
            throw new ArrayQueueException("Queue empty, front element does not exist.");
        }
        return Q[front];
    }

    /**
     * Adds an object to the rear of the queue.
     * @param element is object to be enqueued
     * @throws ArrayQueueException when queue is full
     */
    public void enqueue(E element) throws ArrayQueueException {
        if (size == n) {
            throw new ArrayQueueException("Queue full, cannot enqueue element.");
        }
        else {
            Q[rear] = element;
            rear = (rear + 1) % n;
            size++;
        }
    }

    /**
     * Removes frontmost element from the queue, and returns it.
     * @return element at the front of the queue
     * @throws ArrayQueueException when queue is empty
     */
    public E dequeue() throws ArrayQueueException {
        if (size == 0) {
            throw new ArrayQueueException("Queue empty, nothing to dequeue.");
        }
        else {
            E dequeuedElement = Q[front];
            Q[front] = null;
            front = (front + 1) % n;
            size--;
            return dequeuedElement;
        }
    }

    /**
     * @return string representation of queue
     */
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

