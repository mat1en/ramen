package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import service.MembershipService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @program: src
 * @description:
 * @create: 2020-04-12 18:01
 **/

public class AccountGUI {
    private JFrame frame;
    private JPanel accountPanel;
    private JTextField fNTextField;
    private JTextField lNTextField;
    private JTextField emailTextField;
    private JTextField telTextField;
    private JTextField stampsTextField;
    private JButton backButton;
    private JButton subscribeButton;
    private JButton modifyButton;
    private JLabel accountLabel;
    private JLabel fNLabel;
    private JLabel lNLabel;
    private JLabel emailLabel;
    private JLabel telLabel;
    private JLabel stampsLabel;
    private JTextField IdTextField;
    private JLabel IdLabel;
    private String[] choices;

    public AccountGUI(final String[] choices) {
        this.choices = choices;

        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                ConfirmGUI.main(choices);
            }
        });
    }

    public static void main(String[] args) {
        AccountGUI account = new AccountGUI(args);
        account.frame = new JFrame("Account");
        account.frame.setContentPane(account.accountPanel);
        account.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        account.frame.pack();
        account.frame.setSize(800, 600);
        account.frame.setLocationRelativeTo(null);
        account.frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        MembershipService member = new MembershipService();
        String[] info = member.getInfo(choices[12].substring(0, 8));
        fNTextField = new JTextField();
        fNTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
        fNTextField.setText(info[0]);
        lNTextField = new JTextField();
        lNTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
        lNTextField.setText(info[1]);
        emailTextField = new JTextField();
        emailTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
        if (info[2] == null) {
            info[2] = "Not Set";
        }
        emailTextField.setText(info[2]);
        telTextField = new JTextField();
        telTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
        if (info[3] == null) {
            info[3] = "Not Set";
        }
        telTextField.setText(info[3]);
        IdTextField = new JTextField();
        IdTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
        IdTextField.setText(info[4]);
        stampsTextField = new JTextField();
        stampsTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
        stampsTextField.setText(info[5]);

    }

}
