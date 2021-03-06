package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import service.ManagerService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManagementLogInGUI {
    JFrame frame = new JFrame("ManagementLogInGUI");
    private JTextField iDtextField;
    private JPasswordField passwordField;
    private JButton logInButton;
    private JButton backButton;
    private JLabel passwordLabel;
    private JLabel IDLabel;
    private JLabel titelLabel;
    private JPanel managementLogInPanel;

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
        managementLogInPanel = new JPanel();
        managementLogInPanel.setLayout(new GridLayoutManager(4, 5, new Insets(0, 0, 0, 0), -1, -1));
        managementLogInPanel.setBackground(new Color(-721665));
        titelLabel = new JLabel();
        Font titelLabelFont = this.$$$getFont$$$(null, Font.BOLD, 28, titelLabel.getFont());
        if (titelLabelFont != null) titelLabel.setFont(titelLabelFont);
        titelLabel.setHorizontalAlignment(10);
        titelLabel.setText("Management");
        managementLogInPanel.add(titelLabel, new GridConstraints(0, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        iDtextField = new JTextField();
        managementLogInPanel.add(iDtextField, new GridConstraints(1, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        passwordLabel = new JLabel();
        Font passwordLabelFont = this.$$$getFont$$$(null, -1, 20, passwordLabel.getFont());
        if (passwordLabelFont != null) passwordLabel.setFont(passwordLabelFont);
        passwordLabel.setText("Password:");
        managementLogInPanel.add(passwordLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordField = new JPasswordField();
        managementLogInPanel.add(passwordField, new GridConstraints(2, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        logInButton = new JButton();
        Font logInButtonFont = this.$$$getFont$$$(null, -1, 20, logInButton.getFont());
        if (logInButtonFont != null) logInButton.setFont(logInButtonFont);
        logInButton.setText("Log In");
        managementLogInPanel.add(logInButton, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        IDLabel = new JLabel();
        Font IDLabelFont = this.$$$getFont$$$(null, -1, 20, IDLabel.getFont());
        if (IDLabelFont != null) IDLabel.setFont(IDLabelFont);
        IDLabel.setText("ID:");
        managementLogInPanel.add(IDLabel, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        managementLogInPanel.add(spacer1, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        managementLogInPanel.add(spacer2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        backButton = new JButton();
        Font backButtonFont = this.$$$getFont$$$(null, -1, 20, backButton.getFont());
        if (backButtonFont != null) backButton.setFont(backButtonFont);
        backButton.setText("Back");
        managementLogInPanel.add(backButton, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        return managementLogInPanel;
    }

    ManagementLogInGUI(){
        ManagerService managerService = new ManagerService();
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                IndexGUI.main(null);
            }
        });
        logInButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // need implement
                if(managerService.managerLogIn(iDtextField.getText(),new String(passwordField.getPassword())))
                    ManagementGUI.main(null);
                else{
                    Object[] options = {"OK"};
                    JOptionPane.showOptionDialog(null, "Wrong password!",
                            "Warning", JOptionPane.PLAIN_MESSAGE, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                }
            }
        });
    }

    public static void main(String[] args) {
        ManagementLogInGUI logInGUI = new ManagementLogInGUI();
        logInGUI.frame = new JFrame("Registration");
        logInGUI.frame.setContentPane(new ManagementLogInGUI().managementLogInPanel);
        logInGUI.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInGUI.frame.setSize(600, 500);
        logInGUI.frame.setPreferredSize(new Dimension(600, 500));
        logInGUI.frame.setLocationRelativeTo(null);
        logInGUI.frame.pack();
        logInGUI.frame.setVisible(true);
    }
}
