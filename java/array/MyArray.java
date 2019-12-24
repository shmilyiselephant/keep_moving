package array;

import java.util.*;

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

    public static void main(String args[]) {
        MyArray array = new MyArray(5);
        array.insertElement(2);
        array.insertElement(2);
        array.insertElement(2);
        array.insertElement(4, 4);
        array.insertElement(3, 3);
        array.printArray();
        array.deleteElement(2);
        array.printArray();
    }

}
