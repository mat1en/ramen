package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import service.AddService;
import service.FixedService;
import vo.Add;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class AddGUI {
    private JFrame frame;
    private JLabel noriLabel;
    private JLabel eggLabel;
    private JSpinner noriSpinner;
    private JPanel addPanel;
    private JLabel bambooLabel;
    private JLabel chasuLabel;
    private JSpinner eggSpinner;
    private JSpinner bambooSpinner;
    private JSpinner chasuSpinner;
    private JButton nextButton;
    private JButton backButton;
    private JLabel addLabel;
    private JTextField NoriPriceTextField;
    private JTextField eggPriceTextField;
    private JTextField shootPriceTextField;
    private JTextField ChashuPriceTextField;
    private int noriNum;
    private int eggNum;
    private int bambooNum;
    private int chasuNum;
    private String[] choices;

    public static void main(String[] args) {
        AddGUI add = new AddGUI(args);
        //System.out.println(Arrays.toString(args));
        add.frame = new JFrame("Add-ons");
        add.frame.setContentPane(add.addPanel);
        add.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add.frame.pack();
        add.frame.setSize(800, 600);
        add.frame.setLocationRelativeTo(null);
        add.frame.setVisible(true);
    }

    public AddGUI(final String[] choices) {
        this.choices = choices;

        $$$setupUI$$$();
        showChoices();
        noriSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                noriNum = Integer.parseInt(noriSpinner.getValue().toString());
            }
        });
        eggSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                eggNum = Integer.parseInt(eggSpinner.getValue().toString());
            }
        });
        bambooSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                bambooNum = Integer.parseInt(bambooSpinner.getValue().toString());
            }
        });
        chasuSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                chasuNum = Integer.parseInt(chasuSpinner.getValue().toString());
            }
        });
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AddService add = new AddService();
                add.setNoriNum(noriNum);
                add.setEggNum(eggNum);
                add.setBambooNum(bambooNum);
                add.setChasuNum(chasuNum);
                frame.dispose();
                add.add2dining(choices);
            }
        });
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                FixedGUI.main(choices);
            }
        });
    }

    private void showChoices() {
        if (choices.length == 11) {
            int nori = Integer.parseInt(choices[7]);
            noriSpinner.setValue(nori);

            int egg = Integer.parseInt(choices[8]);
            eggSpinner.setValue(egg);

            int shoots = Integer.parseInt(choices[9]);
            bambooSpinner.setValue(shoots);

            int chashu = Integer.parseInt(choices[10]);
            chasuSpinner.setValue(chashu);

        }
    }

    private void createUIComponents() {// TODO: place custom component creation code here
        int min = 0;
        int max = 99;
        int step = 1;  //步数间隔
        int initValue = 0;  //初始值
        SpinnerModel norimodel = new SpinnerNumberModel(initValue, min, max, step);
        SpinnerModel eggmodel = new SpinnerNumberModel(initValue, min, max, step);
        SpinnerModel bamboomodel = new SpinnerNumberModel(initValue, min, max, step);
        SpinnerModel chasumodel = new SpinnerNumberModel(initValue, min, max, step);
        noriSpinner = new JSpinner(norimodel);
        eggSpinner = new JSpinner(eggmodel);
        bambooSpinner = new JSpinner(bamboomodel);
        chasuSpinner = new JSpinner(chasumodel);
        FixedService f = new FixedService();
        NoriPriceTextField = new JTextField();
        NoriPriceTextField.setText("￡ " + f.getPrice("Nori"));
        NoriPriceTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
        eggPriceTextField = new JTextField();
        eggPriceTextField.setText("￡ " + f.getPrice("egg"));
        eggPriceTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
        shootPriceTextField = new JTextField();
        shootPriceTextField.setText("￡ " + f.getPrice("shoots"));
        shootPriceTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
        ChashuPriceTextField = new JTextField();
        ChashuPriceTextField.setText("￡ " + +f.getPrice("Chashu"));
        ChashuPriceTextField.setBorder(new EmptyBorder(0, 0, 0, 0));

    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        addPanel = new JPanel();
        addPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(8, 3, new Insets(5, 15, 15, 15), -1, -1));
        addPanel.setBackground(new Color(-721665));
        addPanel.setOpaque(true);
        addPanel.setRequestFocusEnabled(true);
        noriLabel = new JLabel();
        noriLabel.setBackground(new Color(-721665));
        Font noriLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, noriLabel.getFont());
        if (noriLabelFont != null) noriLabel.setFont(noriLabelFont);
        noriLabel.setForeground(new Color(-15132391));
        noriLabel.setText("Extra Nori");
        addPanel.add(noriLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        eggLabel = new JLabel();
        eggLabel.setBackground(new Color(-721665));
        Font eggLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, eggLabel.getFont());
        if (eggLabelFont != null) eggLabel.setFont(eggLabelFont);
        eggLabel.setForeground(new Color(-15132391));
        eggLabel.setText("Extra boiled egg");
        addPanel.add(eggLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        bambooLabel = new JLabel();
        bambooLabel.setBackground(new Color(-721665));
        Font bambooLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, bambooLabel.getFont());
        if (bambooLabelFont != null) bambooLabel.setFont(bambooLabelFont);
        bambooLabel.setForeground(new Color(-15132391));
        bambooLabel.setText("Bamboo shoots");
        addPanel.add(bambooLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        chasuLabel = new JLabel();
        chasuLabel.setBackground(new Color(-721665));
        chasuLabel.setEnabled(true);
        Font chasuLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, chasuLabel.getFont());
        if (chasuLabelFont != null) chasuLabel.setFont(chasuLabelFont);
        chasuLabel.setForeground(new Color(-15132391));
        chasuLabel.setText("Extra Chashu");
        addPanel.add(chasuLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        noriSpinner.setBackground(new Color(-1642256));
        noriSpinner.setEnabled(true);
        Font noriSpinnerFont = this.$$$getFont$$$(null, -1, 20, noriSpinner.getFont());
        if (noriSpinnerFont != null) noriSpinner.setFont(noriSpinnerFont);
        noriSpinner.setForeground(new Color(-15132391));
        noriSpinner.setRequestFocusEnabled(true);
        addPanel.add(noriSpinner, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 7, false));
        eggSpinner.setBackground(new Color(-1642256));
        Font eggSpinnerFont = this.$$$getFont$$$(null, -1, 20, eggSpinner.getFont());
        if (eggSpinnerFont != null) eggSpinner.setFont(eggSpinnerFont);
        eggSpinner.setForeground(new Color(-15132391));
        addPanel.add(eggSpinner, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 7, false));
        bambooSpinner.setBackground(new Color(-1642256));
        Font bambooSpinnerFont = this.$$$getFont$$$(null, -1, 20, bambooSpinner.getFont());
        if (bambooSpinnerFont != null) bambooSpinner.setFont(bambooSpinnerFont);
        bambooSpinner.setForeground(new Color(-15132391));
        addPanel.add(bambooSpinner, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 7, false));
        chasuSpinner.setBackground(new Color(-1642256));
        Font chasuSpinnerFont = this.$$$getFont$$$(null, -1, 20, chasuSpinner.getFont());
        if (chasuSpinnerFont != null) chasuSpinner.setFont(chasuSpinnerFont);
        chasuSpinner.setForeground(new Color(-15132391));
        chasuSpinner.setInheritsPopupMenu(false);
        chasuSpinner.setVerifyInputWhenFocusTarget(true);
        addPanel.add(chasuSpinner, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 7, false));
        nextButton = new JButton();
        nextButton.setBackground(new Color(-1642256));
        nextButton.setEnabled(true);
        Font nextButtonFont = this.$$$getFont$$$(null, Font.BOLD, 20, nextButton.getFont());
        if (nextButtonFont != null) nextButton.setFont(nextButtonFont);
        nextButton.setForeground(new Color(-15132391));
        nextButton.setText("Next");
        addPanel.add(nextButton, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-1642256));
        Font backButtonFont = this.$$$getFont$$$(null, Font.BOLD, 20, backButton.getFont());
        if (backButtonFont != null) backButton.setFont(backButtonFont);
        backButton.setForeground(new Color(-15132391));
        backButton.setText("Back");
        addPanel.add(backButton, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        addLabel = new JLabel();
        addLabel.setBackground(new Color(-721665));
        addLabel.setEnabled(true);
        Font addLabelFont = this.$$$getFont$$$(null, Font.BOLD, 28, addLabel.getFont());
        if (addLabelFont != null) addLabel.setFont(addLabelFont);
        addLabel.setForeground(new Color(-15132391));
        addLabel.setText("Add-ons");
        addLabel.setVerticalAlignment(0);
        addPanel.add(addLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        eggPriceTextField.setBackground(new Color(-721665));
        eggPriceTextField.setEditable(false);
        Font eggPriceTextFieldFont = this.$$$getFont$$$(null, Font.BOLD, 20, eggPriceTextField.getFont());
        if (eggPriceTextFieldFont != null) eggPriceTextField.setFont(eggPriceTextFieldFont);
        eggPriceTextField.setForeground(new Color(-15132391));
        addPanel.add(eggPriceTextField, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        shootPriceTextField.setBackground(new Color(-721665));
        shootPriceTextField.setEditable(false);
        Font shootPriceTextFieldFont = this.$$$getFont$$$(null, Font.BOLD, 20, shootPriceTextField.getFont());
        if (shootPriceTextFieldFont != null) shootPriceTextField.setFont(shootPriceTextFieldFont);
        shootPriceTextField.setForeground(new Color(-15132391));
        addPanel.add(shootPriceTextField, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        ChashuPriceTextField.setBackground(new Color(-721665));
        ChashuPriceTextField.setEditable(false);
        Font ChashuPriceTextFieldFont = this.$$$getFont$$$(null, Font.BOLD, 20, ChashuPriceTextField.getFont());
        if (ChashuPriceTextFieldFont != null) ChashuPriceTextField.setFont(ChashuPriceTextFieldFont);
        ChashuPriceTextField.setForeground(new Color(-15132391));
        addPanel.add(ChashuPriceTextField, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        NoriPriceTextField.setBackground(new Color(-721665));
        NoriPriceTextField.setEditable(false);
        Font NoriPriceTextFieldFont = this.$$$getFont$$$(null, Font.BOLD, 20, NoriPriceTextField.getFont());
        if (NoriPriceTextFieldFont != null) NoriPriceTextField.setFont(NoriPriceTextFieldFont);
        NoriPriceTextField.setForeground(new Color(-15132391));
        addPanel.add(NoriPriceTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
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
        return addPanel;
    }
}
