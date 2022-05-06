package src.java.gui;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import src.java.Sort;


public class SortingGUI extends JFrame {
    private Thread thread;
    private Random random = new Random();

    private JPanel visualizer;
    private JPanel[] barPanels;

    private GridBagConstraints grid;

    private int[] copyArray;
    private int sizeScale;
    private int barWidth;

    public boolean sorting;

    public SortingGUI(String selectedAlgo, int[] toBeSorted) {
        super(selectedAlgo); // Name of JFrame window

        /* Setting up the panels within the frame.*/
        visualizer = new JPanel(new GridBagLayout());

        grid = new GridBagConstraints();
        grid.insets = new Insets(0, 1, 0, 1); // Creating gaps btwn each bar in the grid.
        grid.anchor = GridBagConstraints.SOUTH;

        add(visualizer);

        /* Frame Properties */
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
        setVisible(true);

        start(selectedAlgo, toBeSorted);
    }

    public void start(String selectedAlgo, int[] toBeSorted) {
        if (thread == null || !sorting) { // Thread must be empty and we must not be sorting...
            clear(toBeSorted);
            sorting = true;

            switch (selectedAlgo) {
                case "Selection Sort":
                    thread = new Thread(new Sort(toBeSorted, this, selectedAlgo));
                    break;
                case "Bubble Sort":
                    System.out.println("Not implemented yet. Please select another algorithm.");
                    break;
                default:
                    sorting = false;
                    break;
            }

            thread.start();
        }
    }

    public void draw(int[] bars) {
        barPanels = new JPanel[copyArray.length]; // # of bars == # of elements in array
        visualizer.removeAll(); // Clearing canvas

        sizeScale = (int) ((getHeight() * 0.9) / barPanels.length); // Scaling according to the size of the window.

        for (int i = 0; i < copyArray.length; i++) {
            barPanels[i] = new JPanel();
            barPanels[i].setPreferredSize(new Dimension(barWidth, bars[i] * sizeScale));
            barPanels[i].setBackground(Color.WHITE);
            visualizer.add(barPanels[i], grid);
        }
        repaint();
        validate();
    }

    public void redraw(int[] arr) {
        redraw(arr, -1);
        System.out.println("First redraw()");
    }

    public void redraw(int[] arr, int swap) {
        redraw(arr, swap, -1);
        System.out.println("Second redraw()");
    }

    public void redraw(int[] arr, int swap, int compare) {
        redraw(arr, swap, compare, -1);
        System.out.println("Third redraw()");
    }

    public void redraw(int[] arr, int swapping, int comparing, int reading) {
        visualizer.removeAll();

        for (int i = 0; i < barPanels.length; i++) {
            barPanels[i] = new JPanel();
            barPanels[i].setPreferredSize(new Dimension(barWidth, arr[i] * sizeScale));

            if (i == swapping) barPanels[i].setBackground(Color.RED);
            else if (i == comparing) barPanels[i].setBackground(Color.YELLOW);
            else if (i == reading) barPanels[i].setBackground(Color.GREEN);
            else barPanels[i].setBackground(Color.BLUE);
            visualizer.add(barPanels[i], grid);
            System.out.println("Added bar");
        }
        repaint();
        System.out.println("Final redraw()");
        validate();
    }

    public void clear(int[] initialArray) {
        if (sorting) return; // If sorting is currently happening, return.
        copyArray = initialArray;
        barWidth = Math.max(500 / copyArray.length, 1); // Grabbing the size of each bar depending on the # of elements in the array. Chose 500 because it fitted the best.

        // for (int i = 0; i < copyArray.length; i++) {
        //     copyArray[i] = (copyArray.length * random.nextInt());
        // }

        System.out.println("Cleared canvas");
        draw(copyArray);
    }
}
