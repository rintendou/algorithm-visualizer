package src.java.new_gui;

import java.util.Random;

import src.java.*;

public class Visualizer {
    /* Initializing all variables. Variables that are public static will be called as is, otherwise we will have to create a new object of this class, which will cause complications. */
    private static Thread thread;
    private Random random = new Random();

    public static MainGUI f;
    public static Integer[] unsortedArray;
    public static boolean sorting;
    public static int dataCount = 100; // Fixed array size
    public int delay = 1;
    public static int barWidth;

    // public static void clear() {
    //     if (sorting) return; // If sorting is currently going, just return.
    //     unsortedArray = MainGUI.toBeSorted;
    //     barWidth = 5; // Hardcoded the width of each bar since the size of the array is always 100.

    //     for (int i = 0; i < unsortedArray.length; i++) { 
    //         unsortedArray[i] = (int) (100 * Math.random());
    //     }

    //     f.draw(unsortedArray);
    // }

    public static void beginSort(String algo) {
        if (!sorting) {
            sorting = true;

            switch (algo) {
                case "Selection Sort":
                    thread = new Thread(new Sort(unsortedArray, f, algo));
                    break;
                default:
                    break;
            }
        }
    }
}
    
