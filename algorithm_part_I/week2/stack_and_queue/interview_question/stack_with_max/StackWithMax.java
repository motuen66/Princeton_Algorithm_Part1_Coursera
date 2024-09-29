package algorithm_part_I.week2.stack_and_queue.interview_question.stack_with_max;

import java.util.HashSet;
import java.util.Random;
import java.util.Stack;
import java.util.TreeSet;

public class StackWithMax<Type> extends Stack<Type> {
    TreeSet<Type> set = new TreeSet<Type>();

    public Type max() {
        return set.last();
    }

    @Override
    public Type push(Type item) {
        set.add(item);
        super.push(item);
        return item;
    }

    @Override
    public Type pop() {
        Type item = super.pop();
        set.remove(item);
        return item;
    }

    public static void main(String[] args) {
        StackWithMax<Integer> stack = new StackWithMax<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int r = rand.nextInt(2);
            if (r % 2 == 0 || stack.isEmpty()) {
                System.out.println("Push: " + stack.push(i));
            } else {
                System.out.println("Pop: " + stack.pop());
            }
        }
        System.out.println("Max: " + stack.max());
    }
}