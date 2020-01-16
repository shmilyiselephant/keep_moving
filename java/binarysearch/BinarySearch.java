package binarysearch;

import sort.FindKthNumber;

import java.util.Random;

/**
 * @author shmilyiselephant
 * @date 15.01.20
 * @decription
 */
public class BinarySearch {
    private int[] data;

    public BinarySearch(int size) {
        data = new int[size];
        for (int i = 0; i < data.length; i++)
            data[i] = i*3;
    }

    public int[] getData() {
        return data;
    }

    public int binarySearch(int target) {
        int mid = data.length / 2;
        int left = 0, right = data.length-1;
        while (left <= right) {
            if (data[mid] == target) return mid;
            if (data[mid] > target) {
                mid = (left + mid) / 2;
            } else {
                mid = (right + mid) / 2;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        BinarySearch testArray = new BinarySearch(8);
        int r = new Random().nextInt(8);
        FindKthNumber.print(testArray.data);
        System.out.printf("find %d at %d %n", 3*r, testArray.binarySearch(3*r));
    }
}
