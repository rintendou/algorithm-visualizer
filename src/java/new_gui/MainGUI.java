package src.java.new_gui;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.InsetsUIResource;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

public class MainGUI extends JFrame {
    /* Declaration of all components that will be needed */
    private JPanel main;
    private JPanel arrayPanel;
    private JPanel buttonPanel;
    private JPanel[] barPanels;
    private GridBagConstraints grid; // Allows us to position bars into orientations.

    private JComboBox<String> algoPanel; // Drop-down menu for algorithm choices
    private JButton startButton;
    private JButton generateButton;

    private int sizeScale; // Scales components so  graph is not too big.

    private final String[] sortAlgorithms = {"Selection Sort", "Insertion Sort", "Merge Sort", "Bubble Sort"};
    public static Integer[] toBeSorted; // Uses wrapper class because JFrame works with objects. Saves us the effort for converting from int -> Integer.
    private Random random = new Random();

    public MainGUI() {
        super("Sorting Algorithm Visualizer");

        /* Initializing all components */
        startButton = new JButton("Begin Sorting");
        generateButton = new JButton("Generate Arbitrary Array");
        main = new JPanel(new BorderLayout());
        arrayPanel = new JPanel(new GridBagLayout());
        algoPanel = new JComboBox<>(sortAlgorithms);
        buttonPanel = new JPanel();
        grid = new GridBagConstraints();

        algoPanel.setSelectedIndex(-1);
        algoPanel.setRenderer(new Renderer("Select a Sorting Algorithm"));
        grid.insets = new InsetsUIResource(0, 1, 0, 1); // Gaps between each bar
        grid.anchor = GridBagConstraints.SOUTH; // Keeps the bars upright.

        /* ActionListeners */
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (algoPanel.getSelectedIndex() == -1) {
                    System.out.println("Select a valid algorithm");
                    return;
                }
            }
        });

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* There will errors in the console. It's okay. toBeSorted is null until the generate button is pressed. */
                System.out.println(toBeSorted);
                toBeSorted = new Integer[Visualizer.dataCount];
                for (int i = 0; i < 100; i++) {
                    toBeSorted[i] = random.nextInt(0, 100);
                }
                
                System.out.println(Arrays.toString(toBeSorted) + '\n');
            }
        });

        /* Adding all panels into their respective panels. */
        buttonPanel.add(startButton);
        buttonPanel.add(generateButton);
        buttonPanel.add(algoPanel);

        /* Adding all panels into the main frame */
        main.add(buttonPanel, BorderLayout.NORTH);
        main.add(arrayPanel);

        add(main);
        setBackground(Color.DARK_GRAY);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreens the application
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centered window

        addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Allows all components to scale according to window size.
                sizeScale = (int) ((getHeight() * 0.9) / (barPanels.length));
                
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void componentShown(ComponentEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
    }

    public void draw(Integer[] bar) {
        /* Initializes bars, which represent the values in the array. The size of the bars are set according to the sizeScale */
        barPanels = new JPanel[Visualizer.dataCount]; // Calling static variable in Visualizer that contains the # of elements
        arrayPanel.removeAll(); // Clears the bars
        sizeScale = (int) ((getHeight() * 0.9) / (barPanels.length));

        for (int i = 0; i < Visualizer.dataCount; i++) {
            barPanels[i] = new JPanel();
            barPanels[i].setPreferredSize(new DimensionUIResource(Visualizer.barWidth, bar[i] * sizeScale)); // Set the dimensions of each bar, based on the data specified in the parameters.
            arrayPanel.add(barPanels[i], grid);
        }
        repaint(); // Uses Swing to paint the bar's onto the screen.
        validate(); // Confirms all components are valid.
    }

    /* 4 redraw methods. These will be used to update the bars during each iteration. Each method will have another parameter to represent an action during each iteration.  */
    public void redraw(Integer[] bars) {
        redraw(bars, -1);
    }

    public void redraw(Integer[] bars, int swappping) {
        redraw(bars, swappping, -1);
    }

    public void redraw(Integer[] bars, int swapping, int comparing) {
        redraw(bars, swapping, comparing, -1);
    }

    public void redraw(Integer[] bars, int swapping, int comparing, int reading) {
        arrayPanel.removeAll();

        for (int i = 0; i < barPanels.length; i++) {
            barPanels[i] = new JPanel();
            barPanels[i].setPreferredSize(new Dimension(Visualizer.barWidth, bars[i] * sizeScale));

            if (i == swapping) barPanels[i].setBackground(Color.RED);
            else if (i == comparing) barPanels[i].setBackground(Color.YELLOW);
            else if (i == reading) barPanels[i].setBackground(Color.GREEN);
            else barPanels[i].setBackground(Color.BLUE);
            arrayPanel.add(barPanels[i], grid);
        }
        repaint();
        validate();
    }

    /* Allows us to display default text in the dropdown menu */
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
