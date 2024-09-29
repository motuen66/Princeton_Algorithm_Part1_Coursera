package algorithm_part_I.week2.stack_and_queue.interview_question.queue_with_two_stack;

import java.util.Stack;

public class QueueWithTwoStacks<Item> {
    private Stack<Item> input = new Stack<>();//use 1 stack for input
    private Stack<Item> output = new Stack<>();//use another for output

    public QueueWithTwoStacks() {
    }

    //size of queue
    public int size(){
        return input.size() + output.size();
    }
    public boolean isEmpty(){
        return size() == 0;
    }

    //add an item
    public void enqueue(Item item){
        if(item == null){
            throw new java.lang.NullPointerException();
        }
        input.push(item);
    }

    //remove an item
    public Item dequeue() throws NoSuchFieldException {
        if(isEmpty()){
            throw new java.lang.NoSuchFieldException();
        }
        if(output.isEmpty()){
            while (!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.pop();
    }

    public static void main(String[] args) throws NoSuchFieldException {
        QueueWithTwoStacks<Integer> queue= new QueueWithTwoStacks<>();
        int i = 0;
        int N = 50;

        System.out.println("Size: " + queue.size());
        queue.enqueue(i);
        for(i = 0; i < N; i++){
            if(i % 3 == 0) {
                System.out.println("Dequeue: " + queue.dequeue());
            }else{
                queue.enqueue(i);
                System.out.println("Enqueue: " + i);
                }
            }
        while (!queue.isEmpty()){
            System.out.println("Dequeue: " + queue.dequeue());
        }
        System.out.println("Size: " + queue.size());
//        Random rand = new Random();
//        System.out.println("Size: " + queue.size());
//        for(int i = 0; i < 20; i++){
//            int r = rand.nextInt(2);
//            System.out.println(r);
//            if(r % 2 == 0){
//                queue.enqueue(i);
//                System.out.println("Enqueue: " + i);
//            }else{
//                System.out.println("Dequeue: " + queue.dequeue());
//            }
//        }
//        System.out.println("Size" + queue.size());
    }
}