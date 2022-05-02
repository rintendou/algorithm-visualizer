import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Month;
import java.util.*;

public class InitGUI implements ActionListener, ItemListener {
    private JFrame f; // The window itself
    private JButton start;
    private JButton generate;
    private JPanel mainPanel; // Panel containing all elements
    private JComboBox algorithmPanel;
    private int[] arr;
    private boolean startFlag = false;
    private Random random = new Random();
    

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
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1.0f)));

        /* Algorithm Dropdown Selection Panel Setup*/
        String[] sorting = {"Selection Sort", "Bubble Sort (WIP)", "Insertion Sort (WIP)", "Merge Sort (WIP)", "Quick Sort (WIP"};
        algorithmPanel = new JComboBox(sorting);
        algorithmPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1.0f)));
        algorithmPanel.setRenderer(new Renderer("Select a Sorting Algorithm"));
        algorithmPanel.setSelectedIndex(-1);

        /* Generate array with random data */
        generate = new JButton("Generate");
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == generate) {
                    arr = new int[1000];
                    
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = random.nextInt(Integer.MAX_VALUE);
                     }
                     System.out.println("Array has been generated.");
                     System.out.println(Arrays.toString(arr));
                }
            }
        });

        /* Begin sorting */
        start = new JButton("Begin Sorting");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == start) {
                    startFlag = true;
                    new GraphGUI();
                }
            }
        });


        f.add(generate, BorderLayout.WEST);
        f.add(start, BorderLayout.EAST);
        f.add(algorithmPanel, BorderLayout.NORTH);
        f.add(mainPanel);
        f.pack();
        f.setVisible(true);
    }

    class Renderer extends JLabel implements ListCellRenderer { // Default drop down menu text creation
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        String selection = (String) e.getSource();
        
        switch(selection) {
            case "Selection Sort": 
        }
    }

    public static void main(String[] args) {
        new InitGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    public int[] getArray() {
        return arr;
    }
}
