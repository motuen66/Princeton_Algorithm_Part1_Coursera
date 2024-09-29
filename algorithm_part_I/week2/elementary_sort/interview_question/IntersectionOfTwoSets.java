package algorithm_part_I.week2.elementary_sort.interview_question;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoSets {
    private int[] a;
    private int[] b;

    public IntersectionOfTwoSets(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }
    private int intersectionCount(){
        Set<Integer> check = new HashSet<>();
        for(int i : a){
            check.add(i);
        }
        int cnt = 0;
        for(int i : b){
            if(check.contains(i)){
                cnt++;
                check.remove(i);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 5, 1, 9, 3 ,6, 7, 1, 4, 5};
        IntersectionOfTwoSets intersection = new IntersectionOfTwoSets(a, b);
        System.out.println("Number of same elements: " + intersection.intersectionCount());
    }
}