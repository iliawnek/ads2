import java.util.*;
import java.io.*;

public class ArrayQueue<E> {

    public static final int DEFAULT_CAPACITY = 10;  // default queue capacity
    private E[] queue;      // E array used to implement the queue
    private int capacity;   // actual capacity of queue
    private int front;      // index for the top of queue
    private int rear;       // rear of the queue
    private int size;       // size of the queue

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = (E[]) new Object[this.capacity];
        front = rear = size = 0;
    }
    //
    // NOTE: java does not allow creation of array with parameterised type!
    //

    public int size() {
        return -999;
    }
    //
    // IMPLEMENT ME
    //

    public boolean isEmpty() {
        return false;
    }
    //
    // IMPLEMENT ME
    //

    public E front() throws ArrayQueueException {
        return null;
    }
    //
    // IMPLEMENT ME
    //

    public void enqueue(E element) throws ArrayQueueException {
    }
    //
    // IMPLEMENT ME
    //


    public E dequeue() throws ArrayQueueException {
        return null;
    }
    //
    // IMPLEMENT ME
    //

    public String toString() {
        return "";
    }
    //
    // IMPLEMENT ME
    //
    //
    // NOTE: if the queue contains 1,2,3 then return "[1,2,3]"
    //       if the queue contains 1 then return "[1]"
    //       if the queue is empty return "[]"
    //
}

