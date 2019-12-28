package array;

import java.util.*;

/**
 * @author shmilyiselephant
 * @date 27.12.19
 * @decription
 */

public class MyArray{
    private int data[];
    private int capacity;
    private int currentIndex;

    public MyArray(int n) {
        if (n <= 0) {
            System.out.print("Invalid n");
            System.exit(0);
        }
        this.data = new int[n];
        this.capacity = n;
        this.currentIndex = 0;
        for(int item: this.data)
            item = 0;
    }

    public MyArray(int data[]) {
        this.data = data;
        this.capacity = data.length;
        this.currentIndex = data.length;
    }

    public void printArray() {
        for (int item : this.data)
            System.out.print(item + "  ");
        System.out.println();
    }

    public void insertElement(int value, int insertIndex) {
        if (insertIndex >= capacity || currentIndex >= capacity || currentIndex < 0) {
            System.out.println("Cannot insert value");
            System.exit(0);
        }
        if (data[insertIndex] != 0) {
            for(int i = currentIndex+1; i >= insertIndex; i--)
                data[i] = data[i-1];
        }
        data[insertIndex] = value;
        currentIndex++;
        System.out.printf("Insert %d in %d", value, insertIndex);
        System.out.println();
    }

    public void insertElement(int value) {
        if (currentIndex >= capacity) {
            System.out.println("Cannot insert value");
            System.exit(0);
        }
        data[currentIndex] = value;
        currentIndex++;
    }

    public void deleteElement(int deleteIndex) {
        if (deleteIndex < 0 || deleteIndex >= capacity - 1) {
            System.out.println("Cannot delete index");
        }
        int tmp = data[deleteIndex];
        data[deleteIndex] = 0;
        System.out.printf("Delete %d in %d", tmp, deleteIndex);
        System.out.println();
    }

    //merge two arrays to a new greater array
    public static MyArray mergeArray(int[] arrayA, int[] arrayB) {
        int[] result = new int[arrayA.length+arrayB.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < arrayA.length && j < arrayB.length) {
            if (arrayA[i] <= arrayB[j]) {
                result[index] = arrayA[i];
                i++;
            } else {
                result[index] = arrayB[j];
                j++;
            }
            index++;
        }
        for (;i < arrayA.length;i++) {
            result[index] = arrayA[i];
            index++;
        }
        for (;j < arrayB.length;j++) {
            result[index] = arrayB[j];
            index++;
        }
        return new MyArray(result);
    }

    //bubble sort
    public void sort() {
        for(int i = 0; i < data.length; i++) {
            int tmp = 0;
            for(int j = i+1; j < data.length; j++) {
                if (data[j] < data[i]) {
                    tmp = data[j];
                    data[j] = data[i];
                    data[i] = tmp;
                }
            }
        }
    }

    public int[] getData(){
        return this.data;
    }

    public static void main(String args[]) {
        MyArray array = new MyArray(5);
        array.insertElement(24);
        array.insertElement(12);
        array.insertElement(5);
        array.insertElement(53);
        array.insertElement(12);
        //array.printArray();
        //array.deleteElement(2);
        array.sort();
        array.printArray();
        MyArray arrayA = new MyArray(5);
        arrayA.insertElement(25);
        arrayA.insertElement(21);
        arrayA.insertElement(22);
        arrayA.insertElement(54);
        arrayA.insertElement(32);
        arrayA.sort();
        arrayA.printArray();
        MyArray.mergeArray(arrayA.getData(),array.getData()).printArray();
    }

}
