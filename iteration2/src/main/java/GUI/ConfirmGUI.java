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
}
