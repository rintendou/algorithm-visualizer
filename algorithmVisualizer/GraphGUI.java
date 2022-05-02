import javax.swing.*;
import java.awt.*;


public class GraphGUI {
    private JFrame frame;
    private JPanel graphPanel;
    private JPanel graph;
    private static final int windowWidth = 1280;
    private static final int windowHeight = 720;

     public GraphGUI() {
        /* Initialization of the 'Graph JFrame' */
        frame = new JFrame();
        frame.setTitle("Algorithm Visualizer");
        frame.setSize(windowWidth, windowHeight);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Fully closes frame when exited.

        /* Graph Outer Panel */
        graphPanel = new JPanel();
        graphPanel.setBackground(Color.red);
        graphPanel.setBounds(0, 0, 250, 250);

        class displayArray {


            public displayArray() {
                
            }

            public void draw(Graphics graphics) {
                
            }
        }

        
        /* Display frame */
        frame.add(graphPanel);
        frame.setVisible(true);
    }
}