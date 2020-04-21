package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

import service.FixedService;

public class FixedGUI {
    private JFrame frame;
    private JPanel fixedPanel;
    private JLabel fixedlabel;
    private JLabel soupLabel;
    private JRadioButton tonkotsuRadioButton;
    private JRadioButton shoyuRadioButton;
    private JRadioButton shioRadioButton;
    private JLabel noodlesLabel;
    private JRadioButton softRadioButton;
    private JRadioButton mediumdRadioButton;
    private JRadioButton firmRadioButton;
    private JLabel noriLabel;
    private JRadioButton YNRadioButton;
    private JRadioButton NNRadioButton;
    private JLabel chasuLabel;
    private JRadioButton YCradioButton;
    private JRadioButton NCRadioButton;
    private JLabel eggLabel;
    private JRadioButton NEradioButton;
    private JRadioButton YERadioButton;
    private JLabel onionLabel;
    private JRadioButton noPleaseRadioButton;
    private JRadioButton justALittleRadioButton;
    private JRadioButton aLotRadioButton;
    private JLabel spicinessLabel;
    private JSlider spicinessSlider;
    private JLabel noLabel;
    private JLabel maxLabel;
    private JButton backButton;
    private JButton nextButton;
    private JTextField valueTextField;
    private JLabel priceLabel;
    private String soupChoice;
    private String noodleChoice;
    private String onionChoice;
    private String noriChoice;
    private String chasuChoice;
    private String eggChoice;
    private String spicinessChoice;
    private String[] choices;

    public static void main(String[] args) {
        FixedGUI fixed = new FixedGUI(args);
        fixed.frame = new JFrame("Fixed Ramen");
        fixed.frame.setContentPane(fixed.fixedPanel);
        fixed.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fixed.frame.pack();
        fixed.frame.setSize(800, 600);
        fixed.frame.setLocationRelativeTo(null);
        fixed.frame.setVisible(true);
    }


    public FixedGUI(String[] choices) {
        this.choices = choices;
        //The choice of soup
        $$$setupUI$$$();
        showChoices();

        tonkotsuRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    soupChoice = temp.getText();
                //System.out.println(soupChoice);
            }
        });
        shoyuRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    soupChoice = temp.getText();
            }
        });
        shioRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    soupChoice = temp.getText();
            }
        });

        //The choice of noodles
        softRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    noodleChoice = temp.getText();
            }
        });
        mediumdRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    noodleChoice = temp.getText();
            }
        });
        firmRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    noodleChoice = temp.getText();
            }
        });

        //The choice of spring onion
        noPleaseRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    onionChoice = temp.getText();
            }
        });
        justALittleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    onionChoice = temp.getText();
            }
        });
        aLotRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    onionChoice = temp.getText();
            }
        });

        //The choice of Nori
        YNRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    noriChoice = temp.getText();
            }
        });
        NNRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    noriChoice = temp.getText();
            }
        });

        //The choice of Chasu
        YCradioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    chasuChoice = temp.getText();
            }
        });
        NCRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    chasuChoice = temp.getText();
            }
        });

        //The choice of boiled egg
        YERadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    eggChoice = temp.getText();
            }
        });
        NEradioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    eggChoice = temp.getText();
            }
        });

        //The choice of spiciness
        spicinessSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                spicinessChoice = spicinessSlider.getValue() + "";
                //System.out.println(spicinessChoice + "11");
            }
        });

        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (soupChoice == null || noodleChoice == null || onionChoice == null ||
                        noriChoice == null || chasuChoice == null || eggChoice == null || spicinessChoice == null) {
                    Object[] options = {"OK"};
                    int m = JOptionPane.showOptionDialog(null, "Each Item Needs to be Chosen!",
                            "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                } else {
                    FixedService items = new FixedService();
                    items.setSoupChoice(soupChoice);
                    items.setNoodleChoice(noodleChoice);
                    items.setOnionChoice(onionChoice);
                    items.setNoriChoice(noriChoice);
                    items.setChasuChoice(chasuChoice);
                    items.setEggChoice(eggChoice);
                    items.setSpicinessChoice(spicinessChoice);
                    frame.dispose();
                    items.fixed2add();
                }
            }
        });
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                IndexGUI.main(null);
            }
        });

    }

    private void showChoices() {
        if (choices != null && choices.length != 0) {
            String soup = choices[0];
            if (soup.equals(tonkotsuRadioButton.getText())) {
                tonkotsuRadioButton.setSelected(true);
                soupChoice = soup;
            } else if (soup.equals(shoyuRadioButton.getText())) {
                shoyuRadioButton.setSelected(true);
                soupChoice = soup;
            } else if (soup.equals(shioRadioButton.getText())) {
                shioRadioButton.setSelected(true);
                soupChoice = soup;
            }

            String noodels = choices[1];
            if (noodels.equals(softRadioButton.getText())) {
                softRadioButton.setSelected(true);
                noodleChoice = noodels;
            } else if (noodels.equals(mediumdRadioButton.getText())) {
                mediumdRadioButton.setSelected(true);
                noodleChoice = noodels;
            } else if (noodels.equals(firmRadioButton.getText())) {
                firmRadioButton.setSelected(true);
                noodleChoice = noodels;
            }

            String onion = choices[2];
            if (onion.equals(noPleaseRadioButton.getText())) {
                noPleaseRadioButton.setSelected(true);
                onionChoice = onion;
            } else if (onion.equals(justALittleRadioButton.getText())) {
                justALittleRadioButton.setSelected(true);
                onionChoice = onion;
            } else if (onion.equals(aLotRadioButton.getText())) {
                aLotRadioButton.setSelected(true);
                onionChoice = onion;
            }

            String nori = choices[3];
            if (nori.equals(YNRadioButton.getText())) {
                YNRadioButton.setSelected(true);
                noriChoice = nori;
            } else if (nori.equals(NNRadioButton.getText())) {
                NNRadioButton.setSelected(true);
                noriChoice = nori;
            }

            String Chashu = choices[4];
            if (Chashu.equals(YCradioButton.getText())) {
                YCradioButton.setSelected(true);
                chasuChoice = Chashu;
            } else if (Chashu.equals(NCRadioButton.getText())) {
                NCRadioButton.setSelected(true);
                chasuChoice = Chashu;
            }

            String egg = choices[5];
            if (egg.equals(YERadioButton.getText())) {
                YERadioButton.setSelected(true);
                eggChoice = egg;
            } else if (egg.equals(NEradioButton.getText())) {
                NEradioButton.setSelected(true);
                eggChoice = egg;
            }

            int spiciness = Integer.parseInt(choices[6]);
            spicinessSlider.setValue(spiciness);
            spicinessChoice = spiciness + "";
        }

    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        valueTextField = new JTextField();
        FixedService f = new FixedService();
        valueTextField.setText("￡ " + f.getPrice("Fixed"));
        valueTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
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
        fixedPanel = new JPanel();
        fixedPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(13, 4, new Insets(5, 15, 15, 15), -1, -1));
        fixedPanel.setBackground(new Color(-721665));
        fixedPanel.setEnabled(false);
        fixedPanel.setForeground(new Color(-15132391));
        fixedPanel.setName("");
        tonkotsuRadioButton = new JRadioButton();
        tonkotsuRadioButton.setBackground(new Color(-721665));
        tonkotsuRadioButton.setBorderPainted(false);
        tonkotsuRadioButton.setEnabled(true);
        Font tonkotsuRadioButtonFont = this.$$$getFont$$$(null, -1, 20, tonkotsuRadioButton.getFont());
        if (tonkotsuRadioButtonFont != null) tonkotsuRadioButton.setFont(tonkotsuRadioButtonFont);
        tonkotsuRadioButton.setForeground(new Color(-15132391));
        tonkotsuRadioButton.setHideActionText(false);
        tonkotsuRadioButton.setHorizontalAlignment(2);
        tonkotsuRadioButton.setHorizontalTextPosition(4);
        tonkotsuRadioButton.setText("Tonkotsu");
        fixedPanel.add(tonkotsuRadioButton, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        shoyuRadioButton = new JRadioButton();
        shoyuRadioButton.setBackground(new Color(-721665));
        Font shoyuRadioButtonFont = this.$$$getFont$$$(null, -1, 20, shoyuRadioButton.getFont());
        if (shoyuRadioButtonFont != null) shoyuRadioButton.setFont(shoyuRadioButtonFont);
        shoyuRadioButton.setForeground(new Color(-15132391));
        shoyuRadioButton.setSelected(false);
        shoyuRadioButton.setText("Shoyu");
        fixedPanel.add(shoyuRadioButton, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        shioRadioButton = new JRadioButton();
        shioRadioButton.setBackground(new Color(-721665));
        Font shioRadioButtonFont = this.$$$getFont$$$(null, -1, 20, shioRadioButton.getFont());
        if (shioRadioButtonFont != null) shioRadioButton.setFont(shioRadioButtonFont);
        shioRadioButton.setForeground(new Color(-15132391));
        shioRadioButton.setHideActionText(false);
        shioRadioButton.setSelected(false);
        shioRadioButton.setText("Shio");
        fixedPanel.add(shioRadioButton, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        noodlesLabel = new JLabel();
        noodlesLabel.setBackground(new Color(-721665));
        Font noodlesLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, noodlesLabel.getFont());
        if (noodlesLabelFont != null) noodlesLabel.setFont(noodlesLabelFont);
        noodlesLabel.setForeground(new Color(-15132391));
        noodlesLabel.setText("Noodles");
        fixedPanel.add(noodlesLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        onionLabel = new JLabel();
        onionLabel.setBackground(new Color(-721665));
        onionLabel.setEnabled(true);
        Font onionLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, onionLabel.getFont());
        if (onionLabelFont != null) onionLabel.setFont(onionLabelFont);
        onionLabel.setForeground(new Color(-15132391));
        onionLabel.setText("Spring onion");
        fixedPanel.add(onionLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        soupLabel = new JLabel();
        soupLabel.setDoubleBuffered(false);
        soupLabel.setEnabled(true);
        soupLabel.setFocusCycleRoot(false);
        soupLabel.setFocusTraversalPolicyProvider(false);
        Font soupLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, soupLabel.getFont());
        if (soupLabelFont != null) soupLabel.setFont(soupLabelFont);
        soupLabel.setForeground(new Color(-15132391));
        soupLabel.setHorizontalAlignment(0);
        soupLabel.setHorizontalTextPosition(0);
        soupLabel.setText("Soup");
        soupLabel.setVisible(true);
        fixedPanel.add(soupLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        softRadioButton = new JRadioButton();
        softRadioButton.setBackground(new Color(-721665));
        Font softRadioButtonFont = this.$$$getFont$$$(null, -1, 20, softRadioButton.getFont());
        if (softRadioButtonFont != null) softRadioButton.setFont(softRadioButtonFont);
        softRadioButton.setForeground(new Color(-15132391));
        softRadioButton.setText("Soft");
        fixedPanel.add(softRadioButton, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mediumdRadioButton = new JRadioButton();
        mediumdRadioButton.setBackground(new Color(-721665));
        mediumdRadioButton.setEnabled(true);
        Font mediumdRadioButtonFont = this.$$$getFont$$$(null, -1, 20, mediumdRadioButton.getFont());
        if (mediumdRadioButtonFont != null) mediumdRadioButton.setFont(mediumdRadioButtonFont);
        mediumdRadioButton.setForeground(new Color(-15132391));
        mediumdRadioButton.setText("Medium");
        fixedPanel.add(mediumdRadioButton, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        firmRadioButton = new JRadioButton();
        firmRadioButton.setBackground(new Color(-721665));
        Font firmRadioButtonFont = this.$$$getFont$$$(null, -1, 20, firmRadioButton.getFont());
        if (firmRadioButtonFont != null) firmRadioButton.setFont(firmRadioButtonFont);
        firmRadioButton.setForeground(new Color(-15132391));
        firmRadioButton.setText("Firm");
        fixedPanel.add(firmRadioButton, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        noriLabel = new JLabel();
        noriLabel.setBackground(new Color(-721665));
        Font noriLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, noriLabel.getFont());
        if (noriLabelFont != null) noriLabel.setFont(noriLabelFont);
        noriLabel.setForeground(new Color(-15132391));
        noriLabel.setText("Nori");
        fixedPanel.add(noriLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        chasuLabel = new JLabel();
        chasuLabel.setBackground(new Color(-721665));
        Font chasuLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, chasuLabel.getFont());
        if (chasuLabelFont != null) chasuLabel.setFont(chasuLabelFont);
        chasuLabel.setForeground(new Color(-15132391));
        chasuLabel.setText("Chashu");
        fixedPanel.add(chasuLabel, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        eggLabel = new JLabel();
        eggLabel.setBackground(new Color(-721665));
        eggLabel.setEnabled(true);
        Font eggLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, eggLabel.getFont());
        if (eggLabelFont != null) eggLabel.setFont(eggLabelFont);
        eggLabel.setForeground(new Color(-15132391));
        eggLabel.setText("Boiled egg");
        fixedPanel.add(eggLabel, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        YNRadioButton = new JRadioButton();
        YNRadioButton.setBackground(new Color(-721665));
        YNRadioButton.setEnabled(true);
        Font YNRadioButtonFont = this.$$$getFont$$$(null, -1, 20, YNRadioButton.getFont());
        if (YNRadioButtonFont != null) YNRadioButton.setFont(YNRadioButtonFont);
        YNRadioButton.setForeground(new Color(-15132391));
        YNRadioButton.setText("Yes");
        fixedPanel.add(YNRadioButton, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        NNRadioButton = new JRadioButton();
        NNRadioButton.setBackground(new Color(-721665));
        Font NNRadioButtonFont = this.$$$getFont$$$(null, -1, 20, NNRadioButton.getFont());
        if (NNRadioButtonFont != null) NNRadioButton.setFont(NNRadioButtonFont);
        NNRadioButton.setForeground(new Color(-15132391));
        NNRadioButton.setHideActionText(true);
        NNRadioButton.setText("No");
        fixedPanel.add(NNRadioButton, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        YCradioButton = new JRadioButton();
        YCradioButton.setBackground(new Color(-721665));
        Font YCradioButtonFont = this.$$$getFont$$$(null, -1, 20, YCradioButton.getFont());
        if (YCradioButtonFont != null) YCradioButton.setFont(YCradioButtonFont);
        YCradioButton.setForeground(new Color(-15132391));
        YCradioButton.setText("Yes");
        fixedPanel.add(YCradioButton, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        NCRadioButton = new JRadioButton();
        NCRadioButton.setBackground(new Color(-721665));
        Font NCRadioButtonFont = this.$$$getFont$$$(null, -1, 20, NCRadioButton.getFont());
        if (NCRadioButtonFont != null) NCRadioButton.setFont(NCRadioButtonFont);
        NCRadioButton.setForeground(new Color(-15132391));
        NCRadioButton.setText("No");
        fixedPanel.add(NCRadioButton, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        NEradioButton = new JRadioButton();
        NEradioButton.setBackground(new Color(-721665));
        NEradioButton.setEnabled(true);
        Font NEradioButtonFont = this.$$$getFont$$$(null, -1, 20, NEradioButton.getFont());
        if (NEradioButtonFont != null) NEradioButton.setFont(NEradioButtonFont);
        NEradioButton.setForeground(new Color(-15132391));
        NEradioButton.setText("No");
        fixedPanel.add(NEradioButton, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        YERadioButton = new JRadioButton();
        YERadioButton.setBackground(new Color(-721665));
        Font YERadioButtonFont = this.$$$getFont$$$(null, -1, 20, YERadioButton.getFont());
        if (YERadioButtonFont != null) YERadioButton.setFont(YERadioButtonFont);
        YERadioButton.setForeground(new Color(-15132391));
        YERadioButton.setText("Yes");
        fixedPanel.add(YERadioButton, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        spicinessLabel = new JLabel();
        spicinessLabel.setBackground(new Color(-721665));
        Font spicinessLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, spicinessLabel.getFont());
        if (spicinessLabelFont != null) spicinessLabel.setFont(spicinessLabelFont);
        spicinessLabel.setForeground(new Color(-15132391));
        spicinessLabel.setText("Spiciness");
        fixedPanel.add(spicinessLabel, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        spicinessSlider = new JSlider();
        spicinessSlider.setAutoscrolls(false);
        spicinessSlider.setBackground(new Color(-721665));
        spicinessSlider.setDoubleBuffered(false);
        spicinessSlider.setEnabled(true);
        spicinessSlider.setFocusCycleRoot(false);
        spicinessSlider.setFocusTraversalPolicyProvider(false);
        spicinessSlider.setForeground(new Color(-4473925));
        spicinessSlider.setInheritsPopupMenu(false);
        spicinessSlider.setInverted(false);
        spicinessSlider.setMajorTickSpacing(1);
        spicinessSlider.setMaximum(5);
        spicinessSlider.setMinorTickSpacing(0);
        spicinessSlider.setName("");
        spicinessSlider.setOpaque(false);
        spicinessSlider.setOrientation(0);
        spicinessSlider.setPaintLabels(true);
        spicinessSlider.setPaintTicks(true);
        spicinessSlider.setPaintTrack(true);
        spicinessSlider.setRequestFocusEnabled(false);
        spicinessSlider.setSnapToTicks(true);
        spicinessSlider.setToolTipText("");
        spicinessSlider.setValueIsAdjusting(true);
        spicinessSlider.setVerifyInputWhenFocusTarget(true);
        fixedPanel.add(spicinessSlider, new com.intellij.uiDesigner.core.GridConstraints(10, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setBackground(new Color(-1642256));
        backButton.setEnabled(true);
        Font backButtonFont = this.$$$getFont$$$(null, Font.BOLD, 20, backButton.getFont());
        if (backButtonFont != null) backButton.setFont(backButtonFont);
        backButton.setForeground(new Color(-15132391));
        backButton.setHideActionText(false);
        backButton.setText("Back");
        fixedPanel.add(backButton, new com.intellij.uiDesigner.core.GridConstraints(12, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nextButton = new JButton();
        nextButton.setBackground(new Color(-1642256));
        nextButton.setEnabled(true);
        Font nextButtonFont = this.$$$getFont$$$(null, Font.BOLD, 20, nextButton.getFont());
        if (nextButtonFont != null) nextButton.setFont(nextButtonFont);
        nextButton.setForeground(new Color(-15132391));
        nextButton.setText("Next");
        fixedPanel.add(nextButton, new com.intellij.uiDesigner.core.GridConstraints(12, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        noLabel = new JLabel();
        noLabel.setBackground(new Color(-721665));
        noLabel.setEnabled(true);
        Font noLabelFont = this.$$$getFont$$$(null, Font.BOLD, 16, noLabel.getFont());
        if (noLabelFont != null) noLabel.setFont(noLabelFont);
        noLabel.setForeground(new Color(-15132391));
        noLabel.setHorizontalAlignment(0);
        noLabel.setHorizontalTextPosition(10);
        noLabel.setText("No");
        noLabel.setVerticalAlignment(3);
        noLabel.setVerticalTextPosition(3);
        fixedPanel.add(noLabel, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        maxLabel = new JLabel();
        maxLabel.setBackground(new Color(-721665));
        maxLabel.setEnabled(true);
        Font maxLabelFont = this.$$$getFont$$$(null, Font.BOLD, 16, maxLabel.getFont());
        if (maxLabelFont != null) maxLabel.setFont(maxLabelFont);
        maxLabel.setForeground(new Color(-15132391));
        maxLabel.setText("Max");
        fixedPanel.add(maxLabel, new com.intellij.uiDesigner.core.GridConstraints(9, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_SOUTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        noPleaseRadioButton = new JRadioButton();
        noPleaseRadioButton.setBackground(new Color(-721665));
        Font noPleaseRadioButtonFont = this.$$$getFont$$$(null, -1, 20, noPleaseRadioButton.getFont());
        if (noPleaseRadioButtonFont != null) noPleaseRadioButton.setFont(noPleaseRadioButtonFont);
        noPleaseRadioButton.setForeground(new Color(-15132391));
        noPleaseRadioButton.setText("No please");
        fixedPanel.add(noPleaseRadioButton, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        justALittleRadioButton = new JRadioButton();
        justALittleRadioButton.setBackground(new Color(-721665));
        Font justALittleRadioButtonFont = this.$$$getFont$$$(null, -1, 20, justALittleRadioButton.getFont());
        if (justALittleRadioButtonFont != null) justALittleRadioButton.setFont(justALittleRadioButtonFont);
        justALittleRadioButton.setForeground(new Color(-15132391));
        justALittleRadioButton.setText("Just a little");
        fixedPanel.add(justALittleRadioButton, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        aLotRadioButton = new JRadioButton();
        aLotRadioButton.setBackground(new Color(-721665));
        Font aLotRadioButtonFont = this.$$$getFont$$$(null, -1, 20, aLotRadioButton.getFont());
        if (aLotRadioButtonFont != null) aLotRadioButton.setFont(aLotRadioButtonFont);
        aLotRadioButton.setForeground(new Color(-15132391));
        aLotRadioButton.setText("A lot!");
        fixedPanel.add(aLotRadioButton, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fixedlabel = new JLabel();
        fixedlabel.setBackground(new Color(-721665));
        Font fixedlabelFont = this.$$$getFont$$$(null, Font.BOLD, 28, fixedlabel.getFont());
        if (fixedlabelFont != null) fixedlabel.setFont(fixedlabelFont);
        fixedlabel.setForeground(new Color(-15132391));
        fixedlabel.setText("Items of a Fixed Ramen");
        fixedPanel.add(fixedlabel, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        priceLabel = new JLabel();
        priceLabel.setBackground(new Color(-4473925));
        Font priceLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, priceLabel.getFont());
        if (priceLabelFont != null) priceLabel.setFont(priceLabelFont);
        priceLabel.setForeground(new Color(-15132391));
        priceLabel.setText("Price");
        fixedPanel.add(priceLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        valueTextField.setBackground(new Color(-721665));
        valueTextField.setEditable(false);
        Font valueTextFieldFont = this.$$$getFont$$$(null, Font.BOLD, 20, valueTextField.getFont());
        if (valueTextFieldFont != null) valueTextField.setFont(valueTextFieldFont);
        valueTextField.setForeground(new Color(-15132391));
        fixedPanel.add(valueTextField, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(tonkotsuRadioButton);
        buttonGroup.add(shoyuRadioButton);
        buttonGroup.add(shioRadioButton);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(softRadioButton);
        buttonGroup.add(mediumdRadioButton);
        buttonGroup.add(firmRadioButton);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(YNRadioButton);
        buttonGroup.add(NNRadioButton);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(YCradioButton);
        buttonGroup.add(NCRadioButton);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(YERadioButton);
        buttonGroup.add(NEradioButton);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(noPleaseRadioButton);
        buttonGroup.add(justALittleRadioButton);
        buttonGroup.add(aLotRadioButton);
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
        return fixedPanel;
    }
}
