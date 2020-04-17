package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @program: src
 * @description:
 * @create: 2020-04-08 18:16
 **/

public class SRegistrationGUI {
    private JFrame frame;
    private JPanel SRegistration;
    private JButton nextButton;
    private JButton backButton;
    private JTextField STextField;
    private JLabel SLabel;
    private String[] allchoices;

    public SRegistrationGUI(final String[] choices) {
        allchoices = choices;

        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                ConfirmGUI.main(choices);
            }
        });
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                AccountGUI.main(choices);
            }
        });
    }

    public static void main(String[] args) {
        SRegistrationGUI successful = new SRegistrationGUI(args);
        successful.frame = new JFrame("Successful Registration");
        successful.frame.setContentPane(successful.SRegistration);
        successful.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        successful.frame.pack();
        successful.frame.setSize(800, 600);
        successful.frame.setLocationRelativeTo(null);
        successful.frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String str = "Successful " + allchoices[12].substring(8);
        //System.out.println(allchoices[12]);
        STextField = new JTextField();
        STextField.setText(str);
        STextField.setBorder(new EmptyBorder(0, 0, 0, 0));
    }
}
