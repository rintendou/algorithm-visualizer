package src.java.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class InitGUI implements ActionListener {
    private JFrame f; // The window itself
    private JButton start;
    private JButton generate;
    private JPanel mainPanel; // Panel containing all elements
    private JComboBox algorithmPanel;
    private Random random = new Random();

    private int[] randomArray = new int[100];

    public InitGUI() {
        /* Initialize input GUI */
        f = new JFrame();
        f.setTitle("Algorithm Visualizer");
        f.setBackground(Color.gray);
        f.setResizable(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Fully closes frame when exited.

        /* Main Panel Init*/
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1.0f)));

        /* Algorithm Dropdown Selection Panel Setup*/
        String[] sorting = {"Selection Sort", "Bubble Sort (WIP)", "Insertion Sort (WIP)", "Merge Sort (WIP)", "Quick Sort (WIP)"};
        algorithmPanel = new JComboBox(sorting);
        algorithmPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1.0f)));
        algorithmPanel.setRenderer(new Renderer("Select a Sorting Algorithm"));
        algorithmPanel.setSelectedIndex(-1); // Allows for Renderer class to display default text.
        algorithmPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAlgo = (String) algorithmPanel.getSelectedItem();
                System.out.println(selectedAlgo);
            }
        });
        
        /* Generate randomArray with random data */
        generate = new JButton("Generate");
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Generates random values and store values into initial array.
                for (int i = 0; i < randomArray.length; i++) {
                    randomArray[i] = random.nextInt(0, 1000); 
                }

                System.out.println(Arrays.toString(randomArray));
                System.out.println("randomArray has been generated.");
            }
        });

        /* Begin sorting */
        start = new JButton("Begin Sorting");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (algorithmPanel.getSelectedIndex() == -1) {
                    System.out.println("Select a valid algorithm");
                    return;
                }

                String selectedAlgo = getAlgo(); // Grabs item in dropdown and casts it into a String
                new SortingGUI(selectedAlgo, randomArray);
            }
        });
        
        f.add(generate, BorderLayout.WEST);
        f.add(start, BorderLayout.EAST);
        f.add(algorithmPanel, BorderLayout.NORTH);
        f.add(mainPanel);
        f.pack();
        f.setVisible(true);
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }
    
    public int[] getRandomArray() {
        return randomArray;
    }

    public int getRandomArraySize() {
        return randomArray.length;
    }

    public String getAlgo() {
        return (String) algorithmPanel.getSelectedItem();
    }
    class Renderer extends JLabel implements ListCellRenderer { // Default text in algorithmPanel
        final String stockText;

        public Renderer(String stockText) { // Constructor for base text
            this.stockText = stockText;
        }
        
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
                boolean cellHasFocus) {
            if (index == -1 && value == null) setText(stockText); // Dropdown menu selections start from 0. If not 0, then display default text.
            else setText(value.toString()); // Else, show the selected text.
            return this;
        }
    }
}