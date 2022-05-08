package src.java.algorithms;

import src.java.new_gui.MainGUI;
import src.java.new_gui.Visualizer;

public class InsertionSort implements Runnable {
    private Integer[] toBeSorted;
    private MainGUI f;

    public InsertionSort(Integer[] toBeSorted, MainGUI f) {
        this.toBeSorted = toBeSorted;
        this.f = f;
    }

    public void sort() {
        int temp = 0;
		int minNum = 0;
		for(int i = 0; i < toBeSorted.length; i++){
			minNum = i;
			for(int j = toBeSorted.length-1; j > i; j--){
				
				if (toBeSorted[j] <= toBeSorted[minNum]){
					minNum = j;
				}
				f.redraw(toBeSorted, minNum, j-1);
				try {
					Thread.sleep(Visualizer.delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
			temp = toBeSorted[i];
			toBeSorted[i] = toBeSorted[minNum];
			toBeSorted[minNum]= temp;
		}
		f.redraw(toBeSorted);
	}

    
    @Override
    public void run() {
        sort();
        System.out.println("Sorted via Selection Sort");
        Visualizer.sorting = false;
    }
}

