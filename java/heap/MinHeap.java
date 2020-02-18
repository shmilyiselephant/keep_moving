package heap;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Map;


import java.util.Arrays;
import java.util.HashMap;

/**
 * @author shmilyiselephant
 * @date 11.02.20
 * @decription MinHeap, store data by array, min = data[1]
 */
public class MinHeap {
    private int[] a;
    private int capacity;
    private int currSize;

    public MinHeap(int capacity) {
        this.a = new int[capacity+1];
        this.capacity = capacity;
        currSize = 0;
    }

    public int[] getData() {
        return a;
    }

    public int getMin() { return a[1];}

    public void setMin(int data) {
        this.a[1] = data;
    }

    public void updateMin(int data) {
        if (data < this.getMin())
            setMin(data);
    }

    public static int[] swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
        return data;
    }

    //bottom-up
    public void insert(int value) {
        if (currSize >=capacity) return;
        a[++currSize] = value;
        int i = currSize;
        while (i/2 > 0 && a[i] < a[i/2]) {
            swap(a, i, i/2);
            i = i/2;
        }
    }

    //top-down method
    public void removeMin() {
        if (currSize == 0) return;
        a[1] = a[currSize];
        a[currSize--]=0;
        heapify(a, currSize, 1);
    }

    public static void heapify(int[] data, int n, int i) {
        while (true) {
            int minPos = i;
            if (i*2 <= n && data[i] > data[i*2]) minPos = i*2;
            if (i*2+1 <= n && data[minPos] > data[i*2+1]) minPos = i*2+1;
            if (minPos == i) break;
            swap(data, i, minPos);
            i = minPos;
        }
    }

    public static void printData(int[] data) {
        for (int e:data) {
            System.out.print(e+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap aHeap = new MinHeap(20);
        for (int i = 1; i < 20; i++) {
            aHeap.insert(i);
        }
        MinHeap.printData(aHeap.getData());
        aHeap.removeMin();
        MinHeap.printData(aHeap.getData());
        aHeap.updateMin(-4);
        MinHeap.printData(aHeap.getData());
        char a = '我';
        System.out.print(a > 255);
    }
}
