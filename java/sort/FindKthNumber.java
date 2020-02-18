package sort;

import java.util.Random;

/**
 * @author shmilyiselephant
 * @date 15.01.20
 * @decription
 */
public class FindKthNumber {

    public static int kthSmallest(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return -1;
        }

        int partition = partition(arr, 0, arr.length - 1);
        while (partition + 1 != k) {
            if (partition + 1 < k) {
                partition = partition(arr, partition + 1, arr.length - 1);
            } else {
                partition = partition(arr, 0, partition - 1);
            }
        }

        return arr[partition];
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];

        int i = p;
        for (int j = p; j < r; j++) {
            // 这里要是 <= ，不然会出现死循环，比如查找数组 [1,1,2] 的第二小的元素
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, r);

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void print(int[] a) {
        for(int e : a)
            System.out.print(e + ",");
        System.out.println();
    }

    public static void main(String args[]) {
        int[] a = {34,32,12,12,41,24,56,67,98};
        print(a);
        int k = new Random().nextInt(7) + 1;
        System.out.println(k);
        QuickSort.quickSort(a, a.length);
        print(a);
        System.out.printf("%dth number is %d%n",6, kthSmallest(a, 6));
    }
}
