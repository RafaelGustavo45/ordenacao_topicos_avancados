import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Random;
public class Ordenador {

    ArrayList<Integer> e = new ArrayList<Integer>();

    public Ordenador(ArrayList<Integer> e){
        this.e=e;
    }

    public ArrayList<Integer> getList(){
        return this.e;
    }

    public void add(int e){
        this.e.add(e);
    }

    @Override
    public String toString(){
        return e.toString();
    }




    public ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;

            // Move elements of list[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
        Ordenador a = new Ordenador(list);
        return a.getList();
    }

    public ArrayList<Integer> bubbleSort(ArrayList<Integer> list) {
        int n = list.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j + 1);
                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop, the list is sorted
            if (!swapped) break;
        }

        Ordenador e = new Ordenador(list);
        return e.getList();
    }

    public ArrayList<Integer> quickSort(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<Integer> sortedList = new ArrayList<>(list);
        quickSortHelper(sortedList, 0, sortedList.size() - 1);
        return sortedList;
    }

    private void quickSortHelper(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(list, low, high);

            // Recursively sort elements before and after partition
            quickSortHelper(list, low, partitionIndex - 1);
            quickSortHelper(list, partitionIndex + 1, high);
        }
    }

    private int partition(ArrayList<Integer> list, int low, int high) {
        // Choose the last element as the pivot
        int pivot = list.get(high);
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (list.get(j) <= pivot) {
                i++;

                // swap list[i] and list[j]
                Collections.swap(list, i, j);
            }
        }

        // swap list[i+1] and list[high] (pivot)
        Collections.swap(list, i + 1, high);

        return i + 1;
    }
    public ArrayList<Integer> selectionSort(ArrayList<Integer> list) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            Collections.swap(list, i, minIndex);
        }

        return list;
    }




}