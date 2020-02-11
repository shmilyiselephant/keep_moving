package heap;

import java.util.Random;

/**
 * @author shmilyiselephant
 * @date 11.02.20
 * @decription MaxHeap, store data with array, max = data[0]
 */
public class MaxHeap {
    private final int DEFAULT_SIZE=10;

    private int[] a;//store data since index 1
    private int capacity;
    private int currSize;

    public static MaxHeap init(int capacity) {
        MaxHeap aHeap = new MaxHeap(capacity);
        Random r = new Random();
        for(int i = 0; i < capacity; i++) {
            aHeap.insert(r.nextInt(200));
        }
        return aHeap;
    }

    public MaxHeap(int capacity) {
        a = new int[capacity];
        this.capacity = capacity;
        currSize = 0;
    }

    public MaxHeap(){
        a = new int[DEFAULT_SIZE];
        this.capacity = a.length;
        currSize = 0;
    }

    public int size() {
        return currSize;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 has no parent");
        return a[index/2];
    }

    private int getLeftChild(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 has no child");
        return a[index*2+1];
    }

    private int getRightChild(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 has no child");
        return a[index*2+2];
    }

    public int getMax() {
        return a[0];
    }

    public void setMax(int data) {this.a[0] = data;}

    public void updateMax(int data) {
        if (data > getMax())
            setMax(data);
    }

    public void insert(int data) {
        if (currSize > capacity-1) return; //heap is full;
        a[currSize] = data;
        bottomHeapify(a, currSize);
        currSize++;
    }

    private void bottomHeapify(int[] a, int i) {
        while (i/2 >= 0 && a[i] > a[i/2]) {
            swap(a, i/2, i);
            i = i/2;
        }
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] data, int k) {
        //public static native void arraycopy(Object src, int srcPos, Object dest, int desPos, int length)
        System.arraycopy(data, 0, a, 0, k);
    }

    public static int[] swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
        return data;
    }

    public int removeMax() {
        if (currSize == 0) return 0;
        int res = a[0];
        a[0] = a[--currSize];
        a[currSize]=0;
        heapify(a, currSize, 0);
        return res;
    }

    public static void heapify(int[] data, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i*2+2 <= n && data[i] < data[i*2+2]) maxPos = i*2+2;
            if (i*2+1 <= n && data[maxPos] < data[i*2+1]) maxPos = i*2+1;
            if (maxPos == i) break;
            swap(data, i, maxPos);
            i = maxPos;
        }

    }
    public static void main(String[] args) {
        MaxHeap aHeap = new MaxHeap(10);
        for(int i = 1; i <= 10; i++) {
            aHeap.insert(i);
        }
        MinHeap.printData(aHeap.getA());
        aHeap.removeMax();
        MinHeap.printData(aHeap.getA());
    }
}
