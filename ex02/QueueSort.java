import java.util.*;
import java.io.*;

public class QueueSort<E extends Comparable<E>> {

    private ArrayQueue<ArrayQueue<E>> Q;
    public static final int CAPACITY = 10;  // default queue capacity
    private int n;
    private boolean trace;

    public QueueSort() {
        this(CAPACITY);
    }

    public QueueSort(int capacity) {
        n = capacity;
        Q = new ArrayQueue<>(n);
    }

    private ArrayQueue<E> merge(ArrayQueue<E> q1, ArrayQueue<E> q2) throws ArrayQueueException {
        int size = q1.size() + q2.size();
        ArrayQueue<E> mergedQueue = new ArrayQueue<>(size);

        // queue lowest element into mergedQueue until q1 or q2 empties
        E a;
        E b;
        while ((q1.size() > 0 && q2.size() > 0)) {
            a = q1.front();
            b = q2.front();
            if (a.compareTo(b) < 0) {
                mergedQueue.enqueue(q1.dequeue());
            }
            else {
                mergedQueue.enqueue(q2.dequeue());
            }
        }

        // fill remainder of mergedQueue with rest of q1 or q2
        while (q1.size() > 0) {
            mergedQueue.enqueue(q1.dequeue());
        }
        while (q2.size() > 0) {
            mergedQueue.enqueue(q2.dequeue());
        }

        return mergedQueue;
    }

    public void sort() {
        ArrayQueue<E> q1;
        ArrayQueue<E> q2;
        while (Q.size() > 1) {
            q1 = Q.dequeue();
            q2 = Q.dequeue();
            q1 = merge(q1, q2);
            Q.enqueue(q1);
        }
    }

    public void add(E element) {
        ArrayQueue<E> arrayQueue = new ArrayQueue<>(1);
        arrayQueue.enqueue(element);
        Q.enqueue(arrayQueue);
    }

    public String toString() {
        return Q.toString();
    }

    public void trace() {
        trace = !trace;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(args[0]));
        ArrayList<String> data = new ArrayList<>();
        while (sc.hasNext()) {
            data.add(sc.next());
        }
        int n = data.size();
        QueueSort<String> QS = new QueueSort<>(n);
        for (String s : data) {
            QS.add(s);
        }
        if (args.length > 1) {
            QS.trace();
        }
        QS.sort();
        System.out.println(QS);
    }
}
