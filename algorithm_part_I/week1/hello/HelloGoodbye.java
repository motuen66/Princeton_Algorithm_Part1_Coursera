package algorithm_part_I.week1.hello;

import edu.princeton.cs.algs4.StdOut;

public class HelloGoodbye {
    public static void main(String[] args) {
        if(args.length < 2){
            StdOut.println("Not enough parameters");
        }
        StdOut.println("Hello " + args[0] + " and " + args[1]);
        StdOut.println("Goodbye " + args[1] + " and " + args[0]);
    }
}
