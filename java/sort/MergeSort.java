package sort;

/**
 * @author shmilyiselephant
 * @date 15.01.20
 * @decription
 */
public class MergeSort extends BasicSorts{
    private int[] data;

    public MergeSort(int size) {
        super(size);
    }

    public int[] getData() {return this.data;}

    public static void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];
        int p1 = left, p2 = mid+1, k = left;

        while (p1 <= mid && p2 <= right) {
            if (a[p1] <= a[p2])
                tmp[k++] = a[p1++];
            else
                tmp[k++] = a[p2++];
        }

        while (p1 <= mid) tmp[k++] = a[p1++];
        while (p2 <= right) tmp[k++] = a[p2++];

        for (int i = left; i <= right; i++)
            a[i] = tmp[i];
    }

    public static void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start+end) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid+1, end);
            merge(a, start, mid, end);
        }
    }

    public static void main(String args[]) {
        int[] a = {32,12,4,321,12,41,24,56,7,8};
        mergeSort(a, 0, a.length-1);
        for(int e : a)
            System.out.print(e + ",");
    }
}
