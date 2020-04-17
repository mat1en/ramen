package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IndexGUI {
    private JFrame frame;
    private JPanel indexPanel;
    private JButton enterButton;
    private JLabel welcomeLabel;
    private JLabel toLabel;
    private JLabel restaurantLabel;


    public IndexGUI() {
        enterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                GUI.FixedGUI.main(null);
            }
        });
    }

    public static void main(String[] args) {
        IndexGUI index = new IndexGUI();
        index.frame = new JFrame("Welcome");
        index.frame.setContentPane(index.indexPanel);
        index.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        index.frame.pack();
        index.frame.setSize(800, 600);
        index.frame.setLocationRelativeTo(null);
        index.frame.setVisible(true);

    }

}
