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
                            Robot r = new Robot();
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

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        registerPanel = new JPanel();
        registerPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 2, new Insets(5, 15, 15, 15), -1, -1));
        registerPanel.setBackground(new Color(-721665));
        registerPanel.setForeground(new Color(-15132391));
        fNLabel = new JLabel();
        fNLabel.setAlignmentX(0.0f);
        fNLabel.setBackground(new Color(-721665));
        Font fNLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, fNLabel.getFont());
        if (fNLabelFont != null) fNLabel.setFont(fNLabelFont);
        fNLabel.setForeground(new Color(-15132391));
        fNLabel.setText("First Name");
        registerPanel.add(fNLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        fNTextField = new JTextField();
        fNTextField.setBackground(new Color(-1642256));
        Font fNTextFieldFont = this.$$$getFont$$$(null, -1, 20, fNTextField.getFont());
        if (fNTextFieldFont != null) fNTextField.setFont(fNTextFieldFont);
        fNTextField.setForeground(new Color(-15132391));
        registerPanel.add(fNTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(200, -1), null, 5, false));
        lNTextField = new JTextField();
        lNTextField.setBackground(new Color(-1642256));
        lNTextField.setEditable(true);
        Font lNTextFieldFont = this.$$$getFont$$$(null, -1, 20, lNTextField.getFont());
        if (lNTextFieldFont != null) lNTextField.setFont(lNTextFieldFont);
        lNTextField.setForeground(new Color(-15132391));
        registerPanel.add(lNTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(200, -1), null, 5, false));
        lNLabel = new JLabel();
        lNLabel.setBackground(new Color(-721665));
        Font lNLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, lNLabel.getFont());
        if (lNLabelFont != null) lNLabel.setFont(lNLabelFont);
        lNLabel.setForeground(new Color(-15132391));
        lNLabel.setText("Last Name");
        registerPanel.add(lNLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        emailTextField = new JTextField();
        emailTextField.setBackground(new Color(-1642256));
        Font emailTextFieldFont = this.$$$getFont$$$(null, -1, 20, emailTextField.getFont());
        if (emailTextFieldFont != null) emailTextField.setFont(emailTextFieldFont);
        emailTextField.setForeground(new Color(-15132391));
        emailTextField.setText("");
        registerPanel.add(emailTextField, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(200, -1), null, 5, false));
        emailLabel = new JLabel();
        emailLabel.setBackground(new Color(-721665));
        emailLabel.setEnabled(true);
        Font emailLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, emailLabel.getFont());
        if (emailLabelFont != null) emailLabel.setFont(emailLabelFont);
        emailLabel.setForeground(new Color(-15132391));
        emailLabel.setText("Email");
        registerPanel.add(emailLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        mobileNumTextField = new JTextField();
        mobileNumTextField.setBackground(new Color(-1642256));
        Font mobileNumTextFieldFont = this.$$$getFont$$$(null, -1, 20, mobileNumTextField.getFont());
        if (mobileNumTextFieldFont != null) mobileNumTextField.setFont(mobileNumTextFieldFont);
        mobileNumTextField.setForeground(new Color(-15132391));
        registerPanel.add(mobileNumTextField, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(200, -1), null, 5, false));
        mobileLabel = new JLabel();
        mobileLabel.setBackground(new Color(-721665));
        Font mobileLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, mobileLabel.getFont());
        if (mobileLabelFont != null) mobileLabel.setFont(mobileLabelFont);
        mobileLabel.setForeground(new Color(-15132391));
        mobileLabel.setText("Mobile Number");
        registerPanel.add(mobileLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-1642256));
        Font backButtonFont = this.$$$getFont$$$(null, Font.BOLD, 20, backButton.getFont());
        if (backButtonFont != null) backButton.setFont(backButtonFont);
        backButton.setForeground(new Color(-15132391));
        backButton.setText("Back");
        registerPanel.add(backButton, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        nextButton = new JButton();
        nextButton.setBackground(new Color(-1642256));
        Font nextButtonFont = this.$$$getFont$$$(null, Font.BOLD, 20, nextButton.getFont());
        if (nextButtonFont != null) nextButton.setFont(nextButtonFont);
        nextButton.setForeground(new Color(-15132391));
        nextButton.setText("Next");
        registerPanel.add(nextButton, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        registerLabel = new JLabel();
        registerLabel.setBackground(new Color(-721665));
        Font registerLabelFont = this.$$$getFont$$$(null, Font.BOLD, 28, registerLabel.getFont());
        if (registerLabelFont != null) registerLabel.setFont(registerLabelFont);
        registerLabel.setForeground(new Color(-15132391));
        registerLabel.setText("Registration");
        registerPanel.add(registerLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return registerPanel;
    }
}
