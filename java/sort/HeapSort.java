package sort;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEConfig;
import heap.MaxHeap;

import java.util.Random;
import heap.*;
/**
 * @author shmilyiselephant
 * @date 11.02.20
 * @decription
 */
public class HeapSort {

    public static void buildHeap(int[] a, int n) {
        for (int i = n/2 - 1; i>=0; --i) {
            MaxHeap.heapify(a, n, i);
        }
    }

    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 0) {
            MaxHeap.swap(a, 0, k);
            --k;
            MaxHeap.heapify(a, k, 0);
        }
    }

    public static void main(String[] args) {
        int[] test = new int[20];
        Random r = new Random();
        for (int i = 0; i < test.length; i++) {
            test[i] = r.nextInt(200);
        }
        MinHeap.printData(test);
        sort(test, test.length-1);
        MinHeap.printData(test);
    }
}
