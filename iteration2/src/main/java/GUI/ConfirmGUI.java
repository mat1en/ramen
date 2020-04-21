package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import service.FixedService;
import service.MembershipService;
import service.OrderService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class ConfirmGUI {
    private JFrame frame;
    private JPanel confirmPanel;
    private JLabel confirmLabel;
    private JLabel soupLabel;
    private JLabel NoodleLabel;
    private JTextField soupChoice;
    private JLabel onionLabel;
    private JLabel noriLabel;
    private JLabel chashuLabel;
    private JLabel eggLabel;
    private JLabel spicinessLabel;
    private JLabel fixedLabel;
    private JLabel extraLabel;
    private JButton paymentButton;
    private JLabel diningLabel;
    private JLabel extraNoriLabel;
    private JLabel extraEggLabel;
    private JLabel bambooLabel;
    private JLabel extraChasuLabel;
    private JTextField noodleChoice;
    private JTextField onionChoice;
    private JTextField noriChoice;
    private JTextField chashuChoice;
    private JTextField eggChoice;
    private JTextField spicinessChoice;
    private JTextField extraNori;
    private JTextField diningChoice;
    private JTextField extraEgg;
    private JTextField bambooChoice;
    private JTextField extraChashu;
    private JTextField memberTextField;
    private JTextField IdTextField;
    private JTextField valueTextField;
    private JLabel priceLabel;
    private JButton cancelButton;
    private JTextField remainingTextField;
    private JTextField numTextField;
    private static String[] allChoices;
    private double price = 99999;
    private int VSnum = 0;

    public static void main(String[] args) {
        ConfirmGUI confirm = new ConfirmGUI(args);
        //System.out.println(Arrays.toString(args));
        confirm.frame = new JFrame("Confirm");
        confirm.frame.setContentPane(confirm.confirmPanel);
        confirm.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        confirm.frame.pack();
        confirm.frame.setSize(800, 600);
        confirm.frame.setLocationRelativeTo(null);
        confirm.frame.setVisible(true);
    }

    public ConfirmGUI(final String[] choices) {
        allChoices = choices;


        $$$setupUI$$$();
        paymentButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (price == 0) {
                    OrderService order = new OrderService();
                    try {
                        order.setMethods("Virtual Stamps");
                        order.setOrder(choices);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    frame.dispose();
                    SPaymentGUI.main(null);
                } else if (VSnum >= 10 && !allChoices[12].substring(8, 9).equals("Y")) {
                    Object[] options = {"Yes", "No"};
                    int m = JOptionPane.showOptionDialog(null,
                            "You have accumulated 10 virtual stamps. Do you choose to use them?\r\n" +
                                    "They are equivalent to the price of a fixed Ramen.",
                            "Suggestion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, options, options[0]);
                    if (m == 0) {
                        MembershipService member = new MembershipService();
                        member.setVS(allChoices[12].substring(0, 8));
                        allChoices = member.newPrice(allChoices);
                        allChoices[12] = allChoices[12].substring(0, 8) + "Y";
                        frame.dispose();
                        ConfirmGUI.main(allChoices);
                    }
                } else {
                    frame.dispose();
                    PaymentGUI.main(allChoices);
                }


            }
        });
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (allChoices.length == 14 && allChoices[12].substring(8, 9).equals("Y")) {
                    MembershipService member = new MembershipService();
                    member.addVS(choices[12].substring(0, 8), 10);
                }
                frame.dispose();
                IndexGUI.main(null);
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        //System.out.println("IUUUUUU");
        //System.out.println(Arrays.toString(allChoices));
        soupChoice = new JTextField();
        soupChoice.setText(allChoices[0]);
        soupChoice.setBorder(new EmptyBorder(0, 0, 0, 0));
        noodleChoice = new JTextField();
        noodleChoice.setText(allChoices[1]);
        noodleChoice.setBorder(new EmptyBorder(0, 0, 0, 0));
        onionChoice = new JTextField();
        onionChoice.setText(allChoices[2]);
        onionChoice.setBorder(new EmptyBorder(0, 0, 0, 0));
        noriChoice = new JTextField();
        noriChoice.setText(allChoices[3]);
        noriChoice.setBorder(new EmptyBorder(0, 0, 0, 0));
        chashuChoice = new JTextField();
        chashuChoice.setText(allChoices[4]);
        chashuChoice.setBorder(new EmptyBorder(0, 0, 0, 0));
        eggChoice = new JTextField();
        eggChoice.setText(allChoices[5]);
        eggChoice.setBorder(new EmptyBorder(0, 0, 0, 0));
        spicinessChoice = new JTextField();
        spicinessChoice.setText(allChoices[6]);
        spicinessChoice.setBorder(new EmptyBorder(0, 0, 0, 0));
        extraNori = new JTextField();
        extraNori.setText(allChoices[7]);
        extraNori.setBorder(new EmptyBorder(0, 0, 0, 0));
        extraEgg = new JTextField();
        extraEgg.setText(allChoices[8]);
        extraEgg.setBorder(new EmptyBorder(0, 0, 0, 0));
        bambooChoice = new JTextField();
        bambooChoice.setText(allChoices[9]);
        bambooChoice.setBorder(new EmptyBorder(0, 0, 0, 0));
        extraChashu = new JTextField();
        extraChashu.setText(allChoices[10]);
        extraChashu.setBorder(new EmptyBorder(0, 0, 0, 0));
        diningChoice = new JTextField();
        diningChoice.setText(allChoices[11]);
        diningChoice.setBorder(new EmptyBorder(0, 0, 0, 0));


        memberTextField = new JTextField();
        IdTextField = new JTextField();
        valueTextField = new JTextField();
        remainingTextField = new JTextField();
        numTextField = new JTextField();
        memberTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
        IdTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
        valueTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
        remainingTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
        numTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
        if (allChoices.length == 14) {
            String str = allChoices[12].substring(0, 8);
            memberTextField.setText("Membership Id");
            IdTextField.setText(str);
            price = Double.parseDouble(allChoices[13]);
            valueTextField.setText(allChoices[13]);
            remainingTextField.setText("Number of Coupons");
            MembershipService m = new MembershipService();
            VSnum = m.getVS(str);
            //System.out.println(VSnum);
            numTextField.setText(VSnum + "");
        } else {
            //System.out.println(allChoices[12]);
            valueTextField.setText(allChoices[12]);
        }


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
        confirmPanel = new JPanel();
        confirmPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(13, 4, new Insets(5, 15, 15, 15), -1, -1));
        confirmPanel.setBackground(new Color(-721665));
        confirmPanel.setForeground(new Color(-15132391));
        soupLabel = new JLabel();
        soupLabel.setBackground(new Color(-721665));
        Font soupLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, soupLabel.getFont());
        if (soupLabelFont != null) soupLabel.setFont(soupLabelFont);
        soupLabel.setForeground(new Color(-15132391));
        soupLabel.setText("Soup");
        confirmPanel.add(soupLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        NoodleLabel = new JLabel();
        NoodleLabel.setBackground(new Color(-721665));
        Font NoodleLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, NoodleLabel.getFont());
        if (NoodleLabelFont != null) NoodleLabel.setFont(NoodleLabelFont);
        NoodleLabel.setForeground(new Color(-15132391));
        NoodleLabel.setText("Noodles");
        confirmPanel.add(NoodleLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        onionLabel = new JLabel();
        onionLabel.setBackground(new Color(-721665));
        Font onionLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, onionLabel.getFont());
        if (onionLabelFont != null) onionLabel.setFont(onionLabelFont);
        onionLabel.setForeground(new Color(-15132391));
        onionLabel.setText("Spring onion");
        confirmPanel.add(onionLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        spicinessLabel = new JLabel();
        spicinessLabel.setBackground(new Color(-721665));
        Font spicinessLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, spicinessLabel.getFont());
        if (spicinessLabelFont != null) spicinessLabel.setFont(spicinessLabelFont);
        spicinessLabel.setForeground(new Color(-15132391));
        spicinessLabel.setText("Spiciness");
        confirmPanel.add(spicinessLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        extraNoriLabel = new JLabel();
        extraNoriLabel.setBackground(new Color(-721665));
        extraNoriLabel.setEnabled(true);
        Font extraNoriLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, extraNoriLabel.getFont());
        if (extraNoriLabelFont != null) extraNoriLabel.setFont(extraNoriLabelFont);
        extraNoriLabel.setForeground(new Color(-15132391));
        extraNoriLabel.setText("Extra Nori");
        confirmPanel.add(extraNoriLabel, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        bambooLabel = new JLabel();
        bambooLabel.setBackground(new Color(-721665));
        Font bambooLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, bambooLabel.getFont());
        if (bambooLabelFont != null) bambooLabel.setFont(bambooLabelFont);
        bambooLabel.setForeground(new Color(-15132391));
        bambooLabel.setText("Bamboo shoots");
        confirmPanel.add(bambooLabel, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        noriLabel = new JLabel();
        noriLabel.setBackground(new Color(-721665));
        Font noriLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, noriLabel.getFont());
        if (noriLabelFont != null) noriLabel.setFont(noriLabelFont);
        noriLabel.setForeground(new Color(-15132391));
        noriLabel.setText("Nori");
        confirmPanel.add(noriLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        chashuLabel = new JLabel();
        chashuLabel.setBackground(new Color(-721665));
        Font chashuLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, chashuLabel.getFont());
        if (chashuLabelFont != null) chashuLabel.setFont(chashuLabelFont);
        chashuLabel.setForeground(new Color(-15132391));
        chashuLabel.setText("Chashu");
        confirmPanel.add(chashuLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        eggLabel = new JLabel();
        eggLabel.setBackground(new Color(-721665));
        Font eggLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, eggLabel.getFont());
        if (eggLabelFont != null) eggLabel.setFont(eggLabelFont);
        eggLabel.setForeground(new Color(-15132391));
        eggLabel.setText("Boiled egg");
        confirmPanel.add(eggLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        extraEggLabel = new JLabel();
        extraEggLabel.setBackground(new Color(-721665));
        Font extraEggLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, extraEggLabel.getFont());
        if (extraEggLabelFont != null) extraEggLabel.setFont(extraEggLabelFont);
        extraEggLabel.setForeground(new Color(-15132391));
        extraEggLabel.setText("Extra boiled egg");
        confirmPanel.add(extraEggLabel, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        soupChoice.setBackground(new Color(-721665));
        soupChoice.setEditable(false);
        Font soupChoiceFont = this.$$$getFont$$$(null, -1, 20, soupChoice.getFont());
        if (soupChoiceFont != null) soupChoice.setFont(soupChoiceFont);
        soupChoice.setForeground(new Color(-15132391));
        confirmPanel.add(soupChoice, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        fixedLabel = new JLabel();
        fixedLabel.setBackground(new Color(-721665));
        Font fixedLabelFont = this.$$$getFont$$$(null, Font.BOLD | Font.ITALIC, 22, fixedLabel.getFont());
        if (fixedLabelFont != null) fixedLabel.setFont(fixedLabelFont);
        fixedLabel.setForeground(new Color(-15132391));
        fixedLabel.setText("Fixed Items");
        confirmPanel.add(fixedLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        extraLabel = new JLabel();
        extraLabel.setBackground(new Color(-721665));
        Font extraLabelFont = this.$$$getFont$$$(null, Font.BOLD | Font.ITALIC, 22, extraLabel.getFont());
        if (extraLabelFont != null) extraLabel.setFont(extraLabelFont);
        extraLabel.setForeground(new Color(-15132391));
        extraLabel.setText("Add-ons");
        confirmPanel.add(extraLabel, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        extraChasuLabel = new JLabel();
        extraChasuLabel.setBackground(new Color(-721665));
        Font extraChasuLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, extraChasuLabel.getFont());
        if (extraChasuLabelFont != null) extraChasuLabel.setFont(extraChasuLabelFont);
        extraChasuLabel.setForeground(new Color(-15132391));
        extraChasuLabel.setText("Extra Chashu");
        confirmPanel.add(extraChasuLabel, new com.intellij.uiDesigner.core.GridConstraints(8, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        diningLabel = new JLabel();
        diningLabel.setBackground(new Color(-721665));
        Font diningLabelFont = this.$$$getFont$$$(null, Font.BOLD | Font.ITALIC, 22, diningLabel.getFont());
        if (diningLabelFont != null) diningLabel.setFont(diningLabelFont);
        diningLabel.setForeground(new Color(-15132391));
        diningLabel.setText("Dining Option");
        confirmPanel.add(diningLabel, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        paymentButton = new JButton();
        paymentButton.setBackground(new Color(-1642256));
        Font paymentButtonFont = this.$$$getFont$$$(null, Font.BOLD, 20, paymentButton.getFont());
        if (paymentButtonFont != null) paymentButton.setFont(paymentButtonFont);
        paymentButton.setForeground(new Color(-15132391));
        paymentButton.setText("Payment");
        confirmPanel.add(paymentButton, new com.intellij.uiDesigner.core.GridConstraints(12, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        noodleChoice.setBackground(new Color(-721665));
        noodleChoice.setEditable(false);
        Font noodleChoiceFont = this.$$$getFont$$$(null, -1, 20, noodleChoice.getFont());
        if (noodleChoiceFont != null) noodleChoice.setFont(noodleChoiceFont);
        noodleChoice.setForeground(new Color(-15132391));
        confirmPanel.add(noodleChoice, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        onionChoice.setBackground(new Color(-721665));
        onionChoice.setEditable(false);
        Font onionChoiceFont = this.$$$getFont$$$(null, -1, 20, onionChoice.getFont());
        if (onionChoiceFont != null) onionChoice.setFont(onionChoiceFont);
        onionChoice.setForeground(new Color(-15132391));
        confirmPanel.add(onionChoice, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        noriChoice.setBackground(new Color(-721665));
        noriChoice.setEditable(false);
        Font noriChoiceFont = this.$$$getFont$$$(null, -1, 20, noriChoice.getFont());
        if (noriChoiceFont != null) noriChoice.setFont(noriChoiceFont);
        noriChoice.setForeground(new Color(-15132391));
        confirmPanel.add(noriChoice, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        chashuChoice.setBackground(new Color(-721665));
        chashuChoice.setEditable(false);
        Font chashuChoiceFont = this.$$$getFont$$$(null, -1, 20, chashuChoice.getFont());
        if (chashuChoiceFont != null) chashuChoice.setFont(chashuChoiceFont);
        chashuChoice.setForeground(new Color(-15132391));
        confirmPanel.add(chashuChoice, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        eggChoice.setBackground(new Color(-721665));
        eggChoice.setEditable(false);
        Font eggChoiceFont = this.$$$getFont$$$(null, -1, 20, eggChoice.getFont());
        if (eggChoiceFont != null) eggChoice.setFont(eggChoiceFont);
        eggChoice.setForeground(new Color(-15132391));
        confirmPanel.add(eggChoice, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        spicinessChoice.setBackground(new Color(-721665));
        spicinessChoice.setEditable(false);
        Font spicinessChoiceFont = this.$$$getFont$$$(null, -1, 20, spicinessChoice.getFont());
        if (spicinessChoiceFont != null) spicinessChoice.setFont(spicinessChoiceFont);
        spicinessChoice.setForeground(new Color(-15132391));
        confirmPanel.add(spicinessChoice, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        extraNori.setBackground(new Color(-721665));
        extraNori.setEditable(false);
        Font extraNoriFont = this.$$$getFont$$$(null, -1, 20, extraNori.getFont());
        if (extraNoriFont != null) extraNori.setFont(extraNoriFont);
        extraNori.setForeground(new Color(-15132391));
        confirmPanel.add(extraNori, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        diningChoice.setBackground(new Color(-721665));
        diningChoice.setEditable(false);
        Font diningChoiceFont = this.$$$getFont$$$(null, -1, 20, diningChoice.getFont());
        if (diningChoiceFont != null) diningChoice.setFont(diningChoiceFont);
        diningChoice.setForeground(new Color(-15132391));
        confirmPanel.add(diningChoice, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        extraEgg.setBackground(new Color(-721665));
        extraEgg.setEditable(false);
        Font extraEggFont = this.$$$getFont$$$(null, -1, 20, extraEgg.getFont());
        if (extraEggFont != null) extraEgg.setFont(extraEggFont);
        extraEgg.setForeground(new Color(-15132391));
        confirmPanel.add(extraEgg, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        bambooChoice.setBackground(new Color(-721665));
        bambooChoice.setEditable(false);
        Font bambooChoiceFont = this.$$$getFont$$$(null, -1, 20, bambooChoice.getFont());
        if (bambooChoiceFont != null) bambooChoice.setFont(bambooChoiceFont);
        bambooChoice.setForeground(new Color(-15132391));
        confirmPanel.add(bambooChoice, new com.intellij.uiDesigner.core.GridConstraints(7, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        extraChashu.setBackground(new Color(-721665));
        extraChashu.setEditable(false);
        Font extraChashuFont = this.$$$getFont$$$(null, -1, 20, extraChashu.getFont());
        if (extraChashuFont != null) extraChashu.setFont(extraChashuFont);
        extraChashu.setForeground(new Color(-15132391));
        confirmPanel.add(extraChashu, new com.intellij.uiDesigner.core.GridConstraints(8, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        memberTextField.setBackground(new Color(-721665));
        memberTextField.setEditable(false);
        Font memberTextFieldFont = this.$$$getFont$$$(null, Font.BOLD | Font.ITALIC, 22, memberTextField.getFont());
        if (memberTextFieldFont != null) memberTextField.setFont(memberTextFieldFont);
        memberTextField.setForeground(new Color(-15132391));
        confirmPanel.add(memberTextField, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        IdTextField.setBackground(new Color(-721665));
        IdTextField.setEditable(false);
        Font IdTextFieldFont = this.$$$getFont$$$(null, -1, 20, IdTextField.getFont());
        if (IdTextFieldFont != null) IdTextField.setFont(IdTextFieldFont);
        IdTextField.setForeground(new Color(-15132391));
        confirmPanel.add(IdTextField, new com.intellij.uiDesigner.core.GridConstraints(11, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        priceLabel = new JLabel();
        priceLabel.setBackground(new Color(-721665));
        Font priceLabelFont = this.$$$getFont$$$(null, Font.BOLD | Font.ITALIC, 22, priceLabel.getFont());
        if (priceLabelFont != null) priceLabel.setFont(priceLabelFont);
        priceLabel.setForeground(new Color(-15132391));
        priceLabel.setText("Price");
        confirmPanel.add(priceLabel, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        valueTextField.setBackground(new Color(-721665));
        Font valueTextFieldFont = this.$$$getFont$$$(null, -1, 20, valueTextField.getFont());
        if (valueTextFieldFont != null) valueTextField.setFont(valueTextFieldFont);
        valueTextField.setForeground(new Color(-15132391));
        confirmPanel.add(valueTextField, new com.intellij.uiDesigner.core.GridConstraints(10, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        cancelButton = new JButton();
        cancelButton.setBackground(new Color(-1642256));
        Font cancelButtonFont = this.$$$getFont$$$(null, Font.BOLD, 20, cancelButton.getFont());
        if (cancelButtonFont != null) cancelButton.setFont(cancelButtonFont);
        cancelButton.setForeground(new Color(-15132391));
        cancelButton.setText("Cancel");
        confirmPanel.add(cancelButton, new com.intellij.uiDesigner.core.GridConstraints(12, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        numTextField.setBackground(new Color(-721665));
        numTextField.setEditable(false);
        Font numTextFieldFont = this.$$$getFont$$$(null, -1, 20, numTextField.getFont());
        if (numTextFieldFont != null) numTextField.setFont(numTextFieldFont);
        numTextField.setForeground(new Color(-15132391));
        confirmPanel.add(numTextField, new com.intellij.uiDesigner.core.GridConstraints(11, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        remainingTextField.setBackground(new Color(-721665));
        remainingTextField.setEditable(false);
        Font remainingTextFieldFont = this.$$$getFont$$$(null, Font.BOLD | Font.ITALIC, 22, remainingTextField.getFont());
        if (remainingTextFieldFont != null) remainingTextField.setFont(remainingTextFieldFont);
        remainingTextField.setForeground(new Color(-15132391));
        confirmPanel.add(remainingTextField, new com.intellij.uiDesigner.core.GridConstraints(11, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        confirmLabel = new JLabel();
        confirmLabel.setBackground(new Color(-721665));
        Font confirmLabelFont = this.$$$getFont$$$(null, Font.BOLD, 28, confirmLabel.getFont());
        if (confirmLabelFont != null) confirmLabel.setFont(confirmLabelFont);
        confirmLabel.setForeground(new Color(-15132391));
        confirmLabel.setText("Confirmation");
        confirmPanel.add(confirmLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
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
        return confirmPanel;
    }
}
