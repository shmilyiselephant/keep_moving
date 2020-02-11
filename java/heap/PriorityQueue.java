package heap;

import java.util.Queue;
import sort.*;

/**
 * @author shmilyiselephant
 * @date 11.02.20
 * @decription
 */
public class PriorityQueue {
    private MaxHeap maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap();
    }

    public PriorityQueue(int capacity) {
        maxHeap = new MaxHeap(capacity);
    }

    public int getSize() {
        return maxHeap.size();
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    public int getMax() {
        return maxHeap.getMax();
    }

    public int getMin() {
        int[] temp = maxHeap.getA();
        HeapSort.sort(temp, maxHeap.size());
        return temp[0];
    }

    public void enqueue(int data) {
        maxHeap.insert(data);
    }

    public int dequeue() {
        return maxHeap.removeMax();
    }

    public static PriorityQueue init(int capacity) {
        PriorityQueue aQueue = new PriorityQueue(capacity);
        aQueue.maxHeap = MaxHeap.init(capacity);
        return aQueue;
    }

    /**
     *
     * @param args sorted arrays
     * @return int[]
     * @author quanliu
     * @creed: Talk is cheap,show me the code
     * @date 11.02.20 16:48
     */
    public static int[] mergeSortedArrays(int[]...args) {
        int length = 0;
        for (int[] ele: args) {
            length = length + ele.length;
        }
        int[] res = new int[length];
        int j = 0;
        for (int[] array: args) {
            for (int i = 0; i < array.length; i++)
                res[j++] = array[i];
        }
        MinHeap.printData(res);
        HeapSort.sort(res, res.length-1);
        return res;
    }

    public static void main(String[] args) {
        //PriorityQueue aQueue = init(20);
        //aQueue.enqueue(20);
        //MinHeap.printData(aQueue.maxHeap.getA());
        //aQueue.dequeue();
        //MinHeap.printData(aQueue.maxHeap.getA());
        int[] testA = {1,4,53,12,54,12,65};
        int[] testB = {21,44,153,12,54,12,65};
        int[] testC = {16,49,53,42,54,12,65};
        int[] testD = {71,84,23,66,54,1,65};
        int[] sorted = mergeSortedArrays(testA, testB, testC, testD);
        MinHeap.printData(sorted);
    }
}
