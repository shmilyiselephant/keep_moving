package sort;

import java.util.Random;

/**
 * @author shmilyiselephant
 * @date 01.02.20
 * @decription
 */
public class ShellSort {

    public static void main(String args[]) {
        Random r = new Random();
        int[] cases = new int[10];
        for (int i = 0; i < cases.length; i++) {
            cases[i] = r.nextInt(100);
            System.out.print(cases[i]+",");
        }
        System.out.println();
        shellSort(cases);
        for (int e : cases)
            System.out.print(e+",");
    }

    public static void shellSort(int []a) {
        int j;

        for (int gap = a.length/2; gap > 0; gap /= 2)
            for (int i = gap; i < a.length; i++) {
                int tmp = a[i];
                for (j = i; j >= gap && tmp - a[j-gap] < 0; j-=gap) {
                    a[j] = a[j-gap];
                }
                a[j] = tmp;
            }
    }
}
