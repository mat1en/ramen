package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SPaymentGUI {
    private JFrame frame;
    private JPanel successfulPanel;
    private JLabel successfulLabel;
    private JButton backButton;
    private JButton exitButton;

    public SPaymentGUI() {
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                IndexGUI.main(null);
            }
        });
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        SPaymentGUI s = new SPaymentGUI();
        s.frame = new JFrame("Successful Payment");
        s.frame.setContentPane(s.successfulPanel);
        s.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.frame.pack();
        s.frame.setSize(800, 600);
        s.frame.setLocationRelativeTo(null);
        s.frame.setVisible(true);
    }

}
