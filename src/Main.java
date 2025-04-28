import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Date;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {


        Ordenador or = new Ordenador(new ArrayList<>());
        Random r = new Random();
        int cem_mil = 100000;

        ArrayList<Integer> desordenada = new ArrayList<>();

            // --- Bubble Sort ---
        System.out.println("----BubbleSort----");

            // Com 1000 elementos
        for (int i = 0; i < cem_mil; i++) {
                desordenada.add(r.nextInt());
                //System.out.println(i);
            }
        long tempo_inicial = System.currentTimeMillis();
        or.bubbleSort(new ArrayList<>(desordenada));
        long tempo_final = System.currentTimeMillis();
        long tempo_total = (tempo_final - tempo_inicial);
        System.out.println("BubbleSort com " + cem_mil + " elementos tempo: " + tempo_total + " ms");
        desordenada.removeAll(desordenada);
            // Com 10000 elementos

            // --- Insertion Sort ---
        System.out.println("----InsertionSort----");


            // Com 10000 elementos
        for (int i = 0; i < cem_mil; i++) {
                desordenada.add(r.nextInt());
            }
        long tempo_inicial4 = System.currentTimeMillis();
        or.insertionSort(new ArrayList<>(desordenada));
        long tempo_final4 = System.currentTimeMillis();
        long tempo_total4 = (tempo_final4 - tempo_inicial4);
        System.out.println("InsertionSort com " + cem_mil + " elementos tempo: " + tempo_total4 + " ms");
        desordenada.removeAll(desordenada);

            // --- QuickSort ---
        System.out.println("----QuickSort----");



            // Com 10000 elementos
        for (int i = 0; i < cem_mil; i++) {
                desordenada.add(r.nextInt());
            }
        long tempo_inicial6 = System.currentTimeMillis();
        or.quickSort(new ArrayList<>(desordenada));
        long tempo_final6 = System.currentTimeMillis();
        long tempo_total6 = (tempo_final6 - tempo_inicial6);
        System.out.println("QuickSort com " + cem_mil + " elementos tempo: " + tempo_total6 + " ms");

        desordenada.removeAll(desordenada);

            // --- Selection Sort ---
        System.out.println("----SelectionSort----");


        for (int i = 0; i < cem_mil; i++) {
                desordenada.add(r.nextInt());
            }
        long tempo_inicial7 = System.currentTimeMillis();
        or.selectionSort(new ArrayList<>(desordenada));
        long tempo_final7 = System.currentTimeMillis();
        long tempo_total7 = (tempo_final7 - tempo_inicial7);
        System.out.println("SelectionSort com " + cem_mil + " elementos tempo: " + tempo_total7 + " ms");

        desordenada.removeAll(desordenada);

        System.out.println("----TimSort----");

        int[] array = new int[cem_mil];

        for (int i = 0; i < cem_mil; i++) {
            array[i]= r.nextInt();
        }

        TimsortExample tim = new TimsortExample();
        long tempo_inicial8 = System.currentTimeMillis();
        int[] ordenados = tim.timsort(array);
        long tempo_final8 = System.currentTimeMillis();
        long tempo_total8 = (tempo_final8 - tempo_inicial8);
        System.out.println("TimSort com " + cem_mil + " elementos tempo: " + tempo_total8 + " ms");

        System.out.println("----MergeSort----");

        MergeSort m = new MergeSort();

        int[] a = new int[cem_mil];

        for (int i = 0; i < cem_mil; i++) {
            a[i]= r.nextInt();
        }

        long tempo_inicial9 = System.currentTimeMillis();
        m.sort(a, 0, a.length - 1);;
        long tempo_final9 = System.currentTimeMillis();
        long tempo_total9 = (tempo_final9 - tempo_inicial9);
        System.out.println("TimSort com " + cem_mil + " elementos tempo: " + tempo_total9 + " ms");



        }
}
