package algorithm_part_I.week1.algorithmAnalysis.searchInBitonicArray;

import java.util.Arrays;
import java.util.Scanner;

//A Bitonic Sequence is a sequence of numbers that is first strictly increasing
// then after a point decreasing.
public class SeacrchInBironicArray {
    private int[] arr;
    private int bitonicPoint;

    public SeacrchInBironicArray(int[] input) {
        this.arr = input;
    }

    public int findBitonicPoint(int left, int right) {
        if (right < left) return -1;

        int mid = (left + right) / 2;

        if (mid > 0 && mid < arr.length - 1) {
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                return findBitonicPoint(mid + 1, right);
            } else {
                return findBitonicPoint(left, mid - 1);
            }
        }
        return -1;
    }

    public int searchInBitonic(int value, int left, int right) {
        int bitonicPoint = findBitonicPoint(left, right);
//        if (value == this.arr[bitonicPoint]) return bitonicPoint;
        if (value > this.arr[bitonicPoint]) {
            return -1;
        } else {
            int tmp = Arrays.binarySearch(this.arr, left, bitonicPoint, value);
            if (tmp < 0) {
                tmp = this.decreasingBinarySearch(bitonicPoint + 1, right, value);
            }
            return tmp;
        }
    }

    public int decreasingBinarySearch(int left, int right, int value) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (this.arr[mid] == value) {
                return mid;
            } else if (this.arr[mid] < value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] input = {-8, 1, 2, 3, 5, 6, 2, 1, -3, -4, -5};
        SeacrchInBironicArray sba = new SeacrchInBironicArray(input);
        int value = in.nextInt();
        int ans = sba.searchInBitonic(value, 0, input.length - 1);
        if (ans < 0) {
            System.out.println("Not found!");
        } else {
            System.out.println("The index of your value is: " + ans);
        }
    }
}
