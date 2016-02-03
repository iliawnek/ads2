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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E front() throws ArrayQueueException {
        return queue[front];
    }

    public void enqueue(E element) throws ArrayQueueException {
        if (size == capacity) {
            throw new ArrayQueueException();
        }
        else {
            queue[rear] = element;
            rear = (rear + 1) % capacity;
            size++;
        }
    }


    public E dequeue() throws ArrayQueueException {
        if (size == 0) {
            throw new ArrayQueueException();
        }
        else {
            E dequeuedElement = queue[front];
            queue[front] = null;
            front = (front + 1) % capacity;
            size--;
            return dequeuedElement;
        }
    }

    public String toString() {
        String s = "[";
        int cursor = front;
        for (int i = 0; i < size - 1; i++) {
            s += queue[cursor].toString();
            s += ", ";
            cursor = (cursor + 1) % capacity;
        }
        if (size > 0) {
            s += queue[(rear - 1) == -1 ? capacity - 1 : rear - 1];
        }
        return s + "]";
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

