package src.java;

import javax.swing.JPanel;

import src.java.gui.SortingGUI;

public class Sort implements Runnable {
    private int[] sortingArray;
    private SortingGUI f;
    private String algo;

    public Sort(int[] sortingArray, SortingGUI f, String algo) {
        this.sortingArray = sortingArray;
        this.f = f;
        this.algo = algo;
    }
    
    public void beginSelectionSort(int[] sortingArray) {
        int temp;
        int minNum;
        for (int i = 0; i < sortingArray.length - 1; i++) {  
            minNum = i;  
            for (int j = i + 1; j < sortingArray.length; j++) {  
                if (sortingArray[j] < sortingArray[minNum]) {  
                    minNum = j;  
                }  
            }
            f.redraw(sortingArray); 

            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                ex.getSuppressed();
             }

            temp = sortingArray[minNum]; // Swapping.
            sortingArray[minNum] = sortingArray[i];  
            sortingArray[i] = temp;  
        }  
    }

    @Override
    public void run() {
        String selectedAgo = algo;
        switch (selectedAgo) {
            case "Selection Sort": 
                beginSelectionSort(sortingArray);
                break;
            default: break;
        }
        f.sorting = false;
    }
}

