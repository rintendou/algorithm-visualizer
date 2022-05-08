package src.java.new_gui;

import java.util.Random;

import src.java.*;
import src.java.algorithms.*;

public class Visualizer {
    /* Initializing all variables. Variables that are public static will be called as is, otherwise we will have to create a new object of this class, which will cause complications. */
    private static Thread thread;
    private static Random random = new Random();

    public static MainGUI f;
    public static Integer[] toBeSorted;
    public static boolean sorting;
    public static int dataCount = 100; // Fixed array size
    public static int delay = 1;
    public static int barWidth;

    public static void clear() {
        if (sorting) return; // If sorting is currently going, just return.
        toBeSorted = new Integer[dataCount];
        barWidth = 5; // Hardcoded the width of each bar since the size of the array is always 100.

        for (int i = 0; i < toBeSorted.length; i++) toBeSorted[i] = random.nextInt(0, 100);
        f.draw(toBeSorted);
    }

    public static void beginSort(String algo) {
        if (!sorting || thread == null) {
            clear();
            sorting = true;
            
            switch (algo) {
                case "Selection Sort":
                    thread = new Thread(new SelectionSort(toBeSorted, f));
                    System.out.println("Selection Sort begun");
                    break;
                case "Bubble Sort":
                    thread = new Thread(new BubbleSort(toBeSorted, f));
                    System.out.println("Bubble Sort begun");
                    break;
                case "Insertion Sort":
                    thread = new Thread(new InsertionSort(toBeSorted, f));
                    System.out.println("Insertion Sort begun");
                    break;
                case "Merge Sort":
                    thread = new Thread(new MergeSort(toBeSorted, f));
                    System.out.println("Merge Sort begun");
                    break;
                default:
                    sorting = false;
                    break;
            }
            thread.start();
        }
    }

    public static void main(String[] args) {
        f = new MainGUI();
        clear();
        f.setLocationRelativeTo(null);
    }
}
    
