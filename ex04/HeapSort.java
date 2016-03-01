import java.util.*;
import java.io.*;

public class HeapSort {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        // get file data from command line
        Scanner sc = new Scanner(new File(args[0]));
        ArrayList<String> data = new ArrayList<>();
        while (sc.hasNext()) {
            data.add(sc.next());
        }

        // build heap
        Heap heap = new Heap(data.size());
        for (String s : data) {
            heap.insert(s);
        }

        // sorted output from heap
        try {
            // setup file
            File file = new File(String.format("%s-sorted.txt", args[0]));

            // write to file
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            while (!heap.isEmpty()) {
                bw.write(heap.removeMin().toString() + "\n");
            }
            bw.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
//
// takes a filename from the command line
// and outputs that file sorted, one word per line
//
