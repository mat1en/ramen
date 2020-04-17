package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import service.MembershipService;
import vo.UserInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class RegisterGUI {
    private JFrame frame;
    private JPanel registerPanel;
    private JTextField fNTextField;
    private JTextField lNTextField;
    private JTextField emailTextField;
    private JTextField mobileNumTextField;
    private JButton backButton;
    private JButton nextButton;
    private JLabel registerLabel;
    private JLabel fNLabel;
    private JLabel lNLabel;
    private JLabel emailLabel;
    private JLabel mobileLabel;
    private String fN;
    private String lN;
    private String email;
    private String mobileNum;

    public RegisterGUI(final String[] choices) {
        fNTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                fN = fNTextField.getText();
            }
        });
        lNTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                lN = lNTextField.getText();
            }
        });
        emailTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                email = emailTextField.getText();
            }
        });
        mobileNumTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                mobileNum = mobileNumTextField.getText();
            }
        });
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (fN == null || lN == null) {
                    Object[] options = {"OK"};
                    int m = JOptionPane.showOptionDialog(null, "First Name and Last Name Must be Chosen!",
                            "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                } else if (email == null && mobileNum == null) {
                    Object[] options = {"OK"};
                    int m = JOptionPane.showOptionDialog(null, "At Least One Between Email and Mobile Number Must be Chosen!",
                            "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                } else {
                    MembershipService info = new MembershipService();
                    info.setfN(fN);
                    info.setlN(lN);
                    info.setEmail(email);
                    info.setTel(mobileNum);
                    boolean flag = info.checkForamt();
                    if (flag) {
                        try {
                            info.register2membership();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        Object[] options = {"OK"};
                        JOptionPane.showOptionDialog(null, "Sending Membership Number to Your Email or Telephone... Please Wait a Moment",
                                "Sending Message", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                null, options, options[0]);
                        try {
                            Robot  r   =   new   Robot();
                            r.delay(2000);
                        } catch (AWTException ex) {
                            ex.printStackTrace();
                        }
                        frame.dispose();
                        info.setType("Registration!");
                        info.member2SMember(choices);
                    } else {
                        frame.dispose();
                        RegisterGUI.main(choices);
                    }
                }
            }
        });
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                MemberGUI.main(choices);
            }
        });
    }

    public static void main(String[] args) {
        RegisterGUI register = new RegisterGUI(args);
        register.frame = new JFrame("Registration");
        register.frame.setContentPane(register.registerPanel);
        register.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        register.frame.pack();
        register.frame.setSize(800, 600);
        register.frame.setLocationRelativeTo(null);
        register.frame.setVisible(true);
    }

}
