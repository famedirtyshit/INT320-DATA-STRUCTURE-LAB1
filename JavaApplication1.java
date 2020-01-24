/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author int320
 */
public class JavaApplication1 {

    private static int N = 100_000;
    private static Random random = new Random();
    private static Integer[] a1 = new Integer[N];
    private static Integer[] a2 = new Integer[N];
    private static Integer[] a3 = new Integer[N];

    /**
     * @param args the command line arguments
     */

    static void insertionSort(Integer[] array) {
        // start at the first index and iterate through to the end
        for (int i = 1; i < array.length; i++) {
            int currentIndex = i;
            /*
         * Check:
         *      1. that currentIndex is at least 1
         *      2. that the item directly before the currentIndex is greater than the item at currentIndex
         *
         * If both conditions are met, swap the indexes
             */
            while (currentIndex > 0 && array[currentIndex - 1] > array[currentIndex]) {
                int temp = array[currentIndex];
                array[currentIndex] = array[currentIndex - 1];
                array[currentIndex - 1] = temp;
                currentIndex--;
            }
        }
    }

    private static void init() {
        for (int i = 0; i < a1.length; i++) {
            a1[i] = random.nextInt(N);
        }
        System.arraycopy(a1, 0, a2, 0, a1.length);
        System.arraycopy(a1, 0, a3, 0, a1.length);
    }

    public static void main(String[] args) {
//        Date date = new Date(System.currentTimeMillis());
//         int[]     array  = {12, 11, 15, 10, 9, 1, 2, 3, 13, 14, 4, 5, 6, 7, 8};
//        JavaApplication1 sorter = new JavaApplication1();
//        sorter.quickSort(array, 0, array.length - 1);
//        System.out.println(java.util.Arrays.toString(array));
//        
        init();
        //Arrays.sort(a1);
        System.out.println("compare insertion sort O(n!) with array sort O(n log n)");
        JavaApplication1 sorter = new JavaApplication1();
        long beginInsertionSort = System.currentTimeMillis();
        sorter.insertionSort(a1);
        long usedTimeInsertion = System.currentTimeMillis()-beginInsertionSort;
        //System.out.println("selection sort time" + usedTimeInsertion);
        //System.out.println(java.util.Arrays.toString(a1));
        long beginArraySort = System.currentTimeMillis();
        Arrays.sort(a2);
        long usedTimeArraySort = System.currentTimeMillis()-beginArraySort;
        //System.out.println("Arrays.sort() time" + usedTimeArraySort);
        //System.out.println(java.util.Arrays.toString(a2));
        System.out.println("**********************************************");
        System.out.println("input\t"+"Your Program\t"+"Arrays.sort");
        System.out.println("**********************************************");
        System.out.println(N+"\t"+usedTimeInsertion+" ms"+"\t"+usedTimeArraySort+" ms");
        System.out.println("credit https://big-o.io/algorithms/comparison/insertion-sort/");
    }

}
