package heap;

import sort.HeapSort;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * @author shmilyiselephant
 * @date 11.02.20
 * @decription
 */
public class TopKAns {

    public static int[] getTopK(int caseSize, int k) {
        int[] cases = new int[caseSize];
        Random r = new Random();
        for(int i = 0; i < caseSize; i++) {
            cases[i] = r.nextInt(10000);
        }
        MinHeap.printData(cases);
        MinHeap minHeap = new MinHeap(k);
        for (int j = 0; j < k; j++)
            minHeap.insert(cases[j]);
        MinHeap.printData(minHeap.getData());
        for(int m = k; m < caseSize; m++) {
            if (minHeap.getMin() < cases[m]) {
                minHeap.setMin(cases[m]);
                MinHeap.heapify(minHeap.getData(), k, 1);
            }
        }
        return minHeap.getData();
    }

    public static void main(String[] args) {
        int[] topKs = getTopK(10000, 5);
        MinHeap.printData(topKs);
    }
}
