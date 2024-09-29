package algorithm_part_I.week2.elementary_sort.interview_question;

import java.util.HashSet;
import java.util.Set;

public class Permutation {
    private int[] a;
    private int[] b;

    public Permutation(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }
    private boolean permutationCheck(){
        if(a.length != b.length){
            return false;
        }
        Set<Integer> checkSet = new HashSet<>();
        for(int i : a){
            checkSet.add(i);
        }
        for(int i : b){
            if(!checkSet.contains(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {3, 4, 2, 1, 5};
        Permutation permutation = new Permutation(a, b);
        System.out.println("a[] and b[] is permutation: " + permutation.permutationCheck());
    }
}