package algorithm_part_I.week2.stack_and_queue.assignment;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Element<Item> first = null;
    private Element<Item> last = null;
    private int size = 0;
    // construct an empty deque
    public Deque() {}
    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("you are trying to access to the null item!");
        }
        Element<Item> newElement = new Element<>(item);
        if (size == 0) {
            first = newElement;
            last = newElement;
            size++;
        } else {
            newElement.next = first;
            first.prev = newElement;
            first = newElement;
            size++;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("you are trying to access to the null item!");
        }
        Element<Item> newElement = new Element<>(item);
        if (size == 0) {
            first = newElement;
            last = newElement;
            size++;
        } else {
            newElement.prev = last;
            last.next = newElement;
            last = newElement;
            size++;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("The Queue is empty!");
        } else {
            Item returnValue = first.element;
            first = first.next;
            if (first != null) {
                first.prev = null;
            } else {
                last = null;
            }
            size--;
            return returnValue;
        }
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("The Queue is empty!");
        } else {
            Item returnValue = last.element;
            last = last.prev;
            if (last != null) {
                last.next = null;
            } else {
                first = null;
            }
            size--;
            return returnValue;
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Element<Item> current = first;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("The queue is empty!");
                } else {
                    Item returnValue = current.element;
                    current = current.next;
                    return returnValue;
                }
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException("This method is not supported!");
            }
        };
    }
    // user - define data type
    private static class Element<T> {
        private final T element;
        private Element<T> prev;
        private Element<T> next;
        public Element(T element) {
            this.element = element;
        }
    }
    //print method
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
        Deque<Integer> que = new Deque<>();
        que.addFirst(2);
        que.addFirst(3);
        que.addFirst(4);
        que.addFirst(5);
        que.addLast(6);
        que.addLast(7);
        que.addLast(8);
        que.addLast(9);
        que.addLast(10);
        que.addFirst(0);
        que.printQueue();

        System.out.println("Remove first: " + que.removeFirst());
        System.out.println("Remove first: " + que.removeFirst());
        System.out.println("Remove first: " + que.removeFirst());
        que.printQueue();

        System.out.println("Remove last: " + que.removeLast());
        System.out.println("Remove last: " + que.removeLast());
        System.out.println("Remove last: " + que.removeLast());
        que.printQueue();
    }
}
