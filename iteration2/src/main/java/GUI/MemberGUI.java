package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import service.MembershipService;
import service.OrderService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberGUI {
    private JFrame frame;
    private JPanel memberPanel;
    private JTextField numTextField;
    private JButton loginButton;
    private JLabel memberLabel;
    private JLabel numLabel;
    private JButton registerButton;
    private JButton skipButton;
    private JLabel notLabel;
    private String mebershipId;

    public MemberGUI(final String[] choices) {
        skipButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                OrderService order = new OrderService();
                order.skip2confirm(choices);
            }
        });
        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                RegisterGUI.main(choices);
            }
        });
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                mebershipId = numTextField.getText();
                MembershipService member = new MembershipService();
                member.setMemberId(mebershipId);
                boolean flag = false;
                try {
                    flag = member.checkMermeberId();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                if (!flag) {
                    Object[] options = {"OK"};
                    JOptionPane.showOptionDialog(null, "Wrong Membership Number!",
                            "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                } else {
                    frame.dispose();
                    member.setType("Log In!");
                    member.member2SMember(choices);
                }
            }
        });
    }

    public static void main(String[] args) {
        MemberGUI member = new MemberGUI(args);
        member.frame = new JFrame("Member");
        member.frame.setContentPane(member.memberPanel);
        member.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        member.frame.pack();
        member.frame.setSize(800, 600);
        member.frame.setLocationRelativeTo(null);
        member.frame.setVisible(true);
    }

}
