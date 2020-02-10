package sort;

import java.util.Random;

/**
 * @author shmilyiselephant
 * @date 14.01.20
 * @decription
 */
public class BasicSorts {
    private int[] data;

    public BasicSorts(int size) {
        data = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++)
            data[i] = r.nextInt(100);
    }

    public int[] getData() {
        return this.data;
    }

    public void bubbleSort() {
        System.out.print("bubblesort: ");
        for (int i = 0; i < data.length; i++) {
            int tmp = 0;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[i]) {
                    tmp = data[j];
                    data[j] = data[i];
                    data[i] = tmp;
                }
            }
        }
        printElement();
    }

    public void insertSort() {
        System.out.print("insertsort: ");
        for (int i = 1; i < data.length; i++) {
            int tmp = data[i];
            for (int j = i - 1; j >= 0; j--) {
                if (data[j] < tmp) {
                    for (int k = i; k > j + 1; k--)
                        data[k] = data[k - 1];
                    data[j + 1] = tmp;
                    break;
                } else if (j == 0) {
                    for (int q = i; q > 0; q--)
                        data[q] = data[q - 1];
                    data[0] = tmp;
                }
            }
        }
        printElement();
    }

    public void insertSort2() {
        System.out.print("insertsort2: ");
        int temp;
        for (int i = 1; i < data.length; i++) {
            //待排元素小于有序序列的最后一个元素时，向前插入
            if (data[i] < data[i - 1]) {
                temp = data[i];
                for (int j = i; j >= 0; j--) {
                    if (j > 0 && data[j - 1] > temp) {
                        data[j] = data[j - 1];
                    } else {
                        data[j] = temp;
                        break;
                    }
                    printElement();
                }
                printElement();
            }
        }
        printElement();
    }

    public void selectSort() {
        System.out.print("selectsort: ");
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) minIndex = j;
            }
            int tmp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = tmp;
        }
        printElement();
    }

    public void printElement() {
        for (int e : data)
            System.out.print(e + ", ");
        System.out.println();
    }

    public static void main(String args[]) {
        //BasicSorts testArray1 = new BasicSorts(6);
        //testArray1.printElement();
        //testArray1.bubbleSort();
        BasicSorts testArray2 = new BasicSorts(6);
        testArray2.printElement();
        testArray2.insertSort2();
        //BasicSorts testArray3 = new BasicSorts(6);
        //testArray3.printElement();
        //testArray3.insertSort();
        //BasicSorts testArray4 = new BasicSorts(6);
        //testArray4.printElement();
        //testArray4.selectSort();
    }
}

