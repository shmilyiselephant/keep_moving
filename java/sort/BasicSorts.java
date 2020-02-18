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
                }
            }
        }
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

    public static void mergeSort(int[] data, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(data, start, mid);
            mergeSort(data, mid+1, end);
            merge(data, start, mid, end);
        }
    }

    public static void merge(int[] data, int start, int mid, int end) {
        int left = start, right = mid+1, k=start;
        int[] tmp = new int[data.length];

        while (left <= mid && right <= end) {
            if (data[left] <= data[right]) {
                tmp[k++] = data[left++];
            } else {
                tmp[k++] = data[right++];
            }
        }

        while (left <= mid) tmp[k++] = data[left++];
        while (right <= end) tmp[k++] = data[right++];

        for (int i = start; i <= end; i++) {
            data[i] = tmp[i];
        }
    }


    public static void quickSort(int[] a, int left, int right) {
        if (left >= right) return;

        int p = parition(a, left, right);
        quickSort(a, left, p-1);
        quickSort(a, p+1, right);
    }

    public static int parition(int[] a, int left, int right) {
        int pivot = a[right];
        int i = left;
        for (int j = left; j < right; ++j) {
            if (a[j] < pivot) {
                if (j == i) i++;
                else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[right];
        a[right] = tmp;

        return i;
    }

    public static int findKthLargest(int[] data, int k) {
        if (k < 1 || k > data.length-1) return -1;

        int p = parition(data, 0, data.length-1);
        while (p + 1 != k) {
            if (p + 1 > k) {
                p = parition(data, 0, p - 1);
            } else if (p + 1 < k) {
                p = parition(data, p + 1, data.length - 1);
            }
        }

        return data[p];
    }

    public static void main(String args[]) {
        BasicSorts testArray1 = new BasicSorts(6);
        testArray1.printElement();
        testArray1.bubbleSort();
        BasicSorts testArray2 = new BasicSorts(6);
        testArray2.printElement();
        testArray2.insertSort2();
        BasicSorts testArray3 = new BasicSorts(6);
        testArray3.printElement();
        testArray3.insertSort();
        BasicSorts testArray4 = new BasicSorts(6);
        testArray4.printElement();
        testArray4.selectSort();
        BasicSorts testArray5 = new BasicSorts(10);
        testArray5.printElement();
        mergeSort(testArray5.getData(), 0, testArray5.getData().length-1);
        testArray5.printElement();
        BasicSorts testArray6 = new BasicSorts(10);
        testArray6.printElement();
        quickSort(testArray6.getData(), 0, testArray6.getData().length-1);
        testArray6.printElement();
        System.out.println(findKthLargest(testArray6.getData(), 5));
    }
}

