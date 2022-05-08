package src.java.algorithms;

import src.java.new_gui.MainGUI;
import src.java.new_gui.Visualizer;

public class BubbleSort implements Runnable {
    private Integer[] toBeSorted;
    private MainGUI f;

    public BubbleSort(Integer[] toBeSorted, MainGUI f) {
        this.toBeSorted = toBeSorted;
        this.f = f;
    }

    public void sort() {
        int temp = 0;
        
        for (int i = 0; i < toBeSorted.length - 1; i++) {
            for (int j = 0; j < toBeSorted.length - i - 1; j++) {
                if (toBeSorted[j] > toBeSorted[j + 1]) {
                    temp = toBeSorted[j];
                    toBeSorted[j] = toBeSorted[j + 1];
                    toBeSorted[j + 1] = temp;
                }
                f.redraw(toBeSorted, j, j + 1);
                try {
                    Thread.sleep(Visualizer.delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void run() {
        sort();
        System.out.println("Sorted via Bubble Sort");
        Visualizer.sorting = false;
    }
    

}
