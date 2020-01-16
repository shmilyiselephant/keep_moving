package sort;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author shmilyiselephant
 * @date 15.01.20
 * @decription
 */
public class QuickSort{

    public static void quickSort(int[] num, int left, int right) {
        if (left >= right) return;
        int key = num[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (num[j] >= key && i < j) j--; //find the first num[j] < key
            while (num[i] <= key && i < j) i++; //find the first num[i] > key
            if(i<j) { //swap them
                int tmp = num[i];
                num[i] = num[j];
                num[j] = tmp;
            }
        }
        if (left == 9) System.out.printf("%dth number is %d%n", i, num[i]);
        num[left] = num[i];
        num[i] = key;
        quickSort(num, left, i-1);
        quickSort(num, i+1, right);
    }

    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n-1);
    }

    public static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition(a, p, r); // 获取分区点
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    public static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) ++i;
                else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        return i;
    }


    public static void main(String args[]) {
        int[] a = {34,32,12,41,24,56,67,98};
        //quickSort(a, 0, a.length-1);
        quickSort(a, a.length);
        for(int e : a)
            System.out.print(e + ",");
    }
}
