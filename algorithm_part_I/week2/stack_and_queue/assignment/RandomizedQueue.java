package algorithm_part_I.week2.stack_and_queue.assignment;
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size = 0;
    private int n = 1;
    private Item[] elements = (Item[]) new Object[n];
    // construct an empty randomized queue
    public RandomizedQueue() {

    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("The item can not be null!");
        } else {
            if (size == n) {
                resizeArray(n * 2);
            }
            elements[size++] = item;
        }
    }

    private void resizeArray(int newSize) {
        n = newSize;
        Item[] newArray = (Item[]) new Object[n];
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("The queue is empty!");
        }
        if (size == n/4) {
            resizeArray(n/2);
        }
        int randIndex = StdRandom.uniformInt(size);
        Item returnVal = elements[randIndex];
        elements[randIndex] = elements[--size];
        elements[size] = null;
        return returnVal;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException("The queue is empty!");
        }
        int randIndex = StdRandom.uniformInt(size);
        return elements[randIndex];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new QueIterator();
    }

    private class QueIterator implements Iterator<Item> {
        private int currentIndex = 0;
        private Item[] iteratorItems;

        public QueIterator() {
            iteratorItems = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                iteratorItems[i] = elements[i];
            }
            StdRandom.shuffle(iteratorItems);
        }

        @Override
        public boolean hasNext() {
            return currentIndex < iteratorItems.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            return iteratorItems[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void printQueue() {
        System.out.print("{ ");
        for (Item i : this) {
            System.out.print(i + " ");
        }
        System.out.println("}");
        System.out.println("Size: " + this.size);
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> rque = new RandomizedQueue<>();
        System.out.println("empty: " + rque.isEmpty());
        rque.enqueue(1);
        rque.enqueue(2);
        rque.enqueue(4);
        rque.enqueue(6);
        rque.enqueue(7);
        rque.enqueue(3);
        rque.printQueue();

        System.out.println("Random sample: " + rque.sample());
        System.out.println("Random sample: " + rque.sample());
        System.out.println("Random sample: " + rque.sample());

        System.out.println("Dequeue: " + rque.dequeue());
        System.out.println("Dequeue: " + rque.dequeue());
        rque.printQueue();
    }
}
