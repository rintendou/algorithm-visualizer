package src.java;

import src.java.new_gui.MainGUI;
import src.java.new_gui.Visualizer;

public class Sort implements Runnable {
    private Integer[] toBeSorted;
    private MainGUI f;
    private String algo;

    public Sort(Integer[] toBeSorted, MainGUI f, String algo) {
        this.toBeSorted = toBeSorted;
        this.f = f;
        this.algo = algo;

        switch (algo) {
            case "Selection Sort":
                beginSelectionSort(toBeSorted);
                break;
            default:
                break;
        }
    }
    
    public void beginSelectionSort(Integer[] toBeSorted) {
        int temp;
        int minNum;
        for (int i = 0; i < toBeSorted.length - 1; i++) {  
            minNum = i;  
            for (int j = i + 1; j < toBeSorted.length; j++) {  
                if (toBeSorted[j] < toBeSorted[minNum]) {  
                    minNum = j;  
                }  
            }
            
            f.redraw(toBeSorted); // Updates the bars 

            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                ex.getSuppressed();
             }

            temp = toBeSorted[minNum]; // Swapping.
            toBeSorted[minNum] = toBeSorted[i];  
            toBeSorted[i] = temp;  
        }  
    }

    @Override
    public void run() {
        beginSelectionSort(toBeSorted);
        Visualizer.sorting = false;
    }
}

