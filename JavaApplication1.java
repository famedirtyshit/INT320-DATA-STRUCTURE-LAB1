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
    private static int N2 = 10_000;
    private static Random random = new Random();
    private static Integer[] a1 = new Integer[N];
    private static Integer[] a2 = new Integer[N];
    private static Integer[] a3 = new Integer[N2];
    private static Integer[] a4 = new Integer[N2];

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
        for (int i = 0; i < a3.length; i++) {
            a3[i] = random.nextInt(N2);
        }
        System.arraycopy(a1, 0, a2, 0, a1.length);
        System.arraycopy(a3, 0, a4, 0, a3.length);
    }

    public static void main(String[] args) {     
        init();
        System.out.println("compare insertion sort O(n!) with array sort O(n log n)");
        JavaApplication1 sorter = new JavaApplication1();
        
        long beginInsertionSort1 = System.currentTimeMillis();
        sorter.insertionSort(a1);
        long usedTimeInsertion1 = System.currentTimeMillis()-beginInsertionSort1;
        long beginArraySort1 = System.currentTimeMillis();
        Arrays.sort(a2);
        long usedTimeArraySort1 = System.currentTimeMillis()-beginArraySort1;
        
        long beginInsertionSort2 = System.currentTimeMillis();
        sorter.insertionSort(a3);
        long usedTimeInsertion2 = System.currentTimeMillis()-beginInsertionSort2;
        long beginArraySort2 = System.currentTimeMillis();
        Arrays.sort(a4);
        long usedTimeArraySort2 = System.currentTimeMillis()-beginArraySort2;
        
        System.out.println("\n**********************************************");
        System.out.println("input\t"+"Your Program\t"+"Arrays.sort");
        System.out.println("**********************************************");
        System.out.println(N+"\t"+usedTimeInsertion1+" ms"+"\t"+usedTimeArraySort1+" ms\n");
        System.out.println(N2+"\t"+usedTimeInsertion2+" ms"+"\t\t"+usedTimeArraySort2+" ms\n");
        System.out.println("credit https://big-o.io/algorithms/comparison/insertion-sort/");
    }

}
