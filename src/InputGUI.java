import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputGUI implements ActionListener {
    private JFrame frame;
    private JPanel mainPanel, buttonPane, dropDownPane;
    private JButton selectionSortButton, bubbleSortButton, insertionSortButton, mergeSortButton;

    public InputGUI() {
        /* Initialize input GUI */
        frame = new JFrame();
        frame.setTitle("Algorithm Visualizer Input");
        frame.setBackground(Color.gray);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Fully closes frame when exited.

        /* Main Panel */
        mainPanel = new JPanel();

        /* Button Pane Setup */
        buttonPane = new JPanel(new FlowLayout());
        buttonPane.setBackground(Color.red);
        buttonPane.setBounds(10, 10, 10, 10);

        /* Drop-down Menu Pane Setup*/
        dropDownPane = new JPanel(new CardLayout());
        dropDownPane.setBackground(Color.blue);


        /* Create buttons for user to interact with */
        selectionSortButton = new JButton("Selection Sort");
        selectionSortButton.setBounds(20, 20, 20, 20);
        selectionSortButton.addActionListener(
            new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) { // Selection Sort Button Listener
                    if (e.getSource() == selectionSortButton) System.out.println("Selection Sort");
                }
            }
        ); 
        buttonPane.add(selectionSortButton);

        bubbleSortButton = new JButton("Bubble Sort");
        bubbleSortButton.setBounds(50, 20, 20, 20);
        bubbleSortButton.addActionListener(
            new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == bubbleSortButton) System.out.println("Bubble Sort");
                }
            }
        );
        buttonPane.add(bubbleSortButton);

        insertionSortButton = new JButton("Insertion Sort");
        insertionSortButton.setBounds(80, 20, 20, 20);
        insertionSortButton.addActionListener(
            new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == insertionSortButton) System.out.println("Insertion Sort");
                }
            }
        );
        buttonPane.add(insertionSortButton);
        
        mainPanel.add(buttonPane);
        mainPanel.add(dropDownPane);
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new InputGUI();
    }


    @Override
    public void actionPerformed(ActionEvent e) { // Default button response (run GraphGUI)
        // TODO Auto-generated method stub
        
    }
}
