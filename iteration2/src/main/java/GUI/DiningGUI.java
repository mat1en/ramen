package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import service.DiningService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class DiningGUI {
    private JFrame frame;
    private JPanel diningPanel;
    private JButton backButton;
    private JButton nextButton;
    private JLabel diningLabel;
    private JRadioButton InButton;
    private JRadioButton AwayButton;
    private String diningChoice;

    public DiningGUI(final String[] choices) {
        InButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    diningChoice = temp.getText();
            }
        });
        AwayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    diningChoice = temp.getText();
            }
        });
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (diningChoice == null) {
                    Object[] options = {"OK"};
                    JOptionPane.showOptionDialog(null, "Dining Option Must be Chosen!",
                            "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                }
                else {
                    DiningService dining = new DiningService();
                    dining.setDiningChoice(diningChoice);
                    frame.dispose();
                    dining.dining2member(choices);
                }
            }
        });
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                AddGUI.main(choices);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        DiningGUI dining = new DiningGUI(args);
        //System.out.println(Arrays.toString(args));
        dining.frame = new JFrame("Dining Options");
        dining.frame.setContentPane(dining.diningPanel);
        dining.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dining.frame.pack();
        dining.frame.setSize(800, 600);
        dining.frame.setLocationRelativeTo(null);
        dining.frame.setVisible(true);
    }


}
