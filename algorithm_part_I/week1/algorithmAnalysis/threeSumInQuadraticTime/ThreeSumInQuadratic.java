package algorithm_part_I.week1.algorithmAnalysis.threeSumInQuadraticTime;

import java.util.Arrays;

public class ThreeSumInQuadratic {
    private int[] arr;
    private int[] ans = new int[3];
    private int value;

    public ThreeSumInQuadratic(int[] input) {
        this.arr = input;
        this.value = 0;
    }

    public void solveThreeSum(){
        int left = 0;
        Arrays.fill(ans, -1);
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                left = value - arr[i] - arr[j];
                int key = Arrays.binarySearch(this.arr, left);
                if(key > 0){
                    this.ans[0] = arr[i];
                    this.ans[1] = arr[j];
                    this.ans[2] = arr[key];
                }
            }
        }
    }
    public int[] getAns(){
        return this.ans;
    }

    public static void main(String[] args) {
        int[] inputArr = new int[]{1,2,3,4,5,6,7,8,-1,-2,-3,-4,-5,-6};
        ThreeSumInQuadratic ts = new ThreeSumInQuadratic(inputArr);
        ts.solveThreeSum();
        System.out.println("Three sum answer: " + Arrays.toString(ts.getAns()));
    }
}
