package algorithm_part_I.week2.stack_and_queue.assignment;

import edu.princeton.cs.algs4.StdIn;
import java.util.Iterator;

public class Permutation {
    public static void main(String[] args) {
        int k;

        try {
            k = StdIn.readInt();
            if (k <= 0) {
                throw new IllegalArgumentException("k must be a positive integer.");
            }
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        RandomizedQueue<String> rq = new RandomizedQueue<>();

        for (int i = 0; i < k && !StdIn.isEmpty(); i++) {
            String word = StdIn.readString();
            rq.enqueue(word);
        }

        Iterator<String> it = rq.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
