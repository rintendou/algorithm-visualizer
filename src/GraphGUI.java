import javax.swing.*;
import java.awt.*;

public class GraphGUI {
    private JFrame frame;
    private JPanel graphPanel;
    private JPanel graph;

     public GraphGUI() {
        /* Initialization of the 'Graph JFrame' */
        frame = new JFrame();
        frame.setTitle("Algorithm Visualizer");
        frame.setLayout(null);
        frame.setSize(1200,800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Fully closes frame when exited.

        /* Graph Outer Panel */
        graphPanel = new JPanel();
        graphPanel.setBackground(Color.red);
        graphPanel.setBounds(0, 0, 250, 250);
        frame.add(graphPanel);

        /* Graph Inner Panel */
        graph = new JPanel();
        graph.setBackground(Color.LIGHT_GRAY);

        /* Display frame */
        frame.setVisible(true);
    }
}