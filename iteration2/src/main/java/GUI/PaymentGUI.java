package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import service.MembershipService;
import service.OrderService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaymentGUI {
    private JFrame frame;
    private JPanel paymentPanel;
    private JRadioButton cashButton;
    private JRadioButton creditCardRadioButton;
    private JButton confirmButton;
    private JButton backButton;
    private JLabel paymentLabel;
    private JLabel textLabel;
    private String method;
    private String[] allchoices;

    public static void main(String[] args) {
        PaymentGUI payment = new PaymentGUI(args);
        payment.frame = new JFrame("Payment");
        payment.frame.setContentPane(payment.paymentPanel);
        payment.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        payment.frame.pack();
        payment.frame.setSize(800, 600);
        payment.frame.setLocationRelativeTo(null);
        payment.frame.setVisible(true);
    }

    public PaymentGUI(final String[] choices) {
        allchoices = choices;
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                ConfirmGUI.main(choices);
            }
        });
        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (method == null) {
                    Object[] options = {"OK"};
                    JOptionPane.showOptionDialog(null, "Method of Payment Must be Chosen!",
                            "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                } else {
                    if (choices.length == 14) {
                        if (!choices[12].substring(8, 9).equals("Y")) {
                            MembershipService member = new MembershipService();
                            member.addVS(choices[12].substring(0, 8), 1);
                        }
                        Object[] options = {"OK"};
                        JOptionPane.showOptionDialog(null,
                                "Sending the Number of Stamps Collected So Far to Your Email or Telephone...\r\n " +
                                        "Please Wait a Moment",
                                "Sending Message", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                null, options, options[0]);
                        try {
                            Robot r = new Robot();
                            r.delay(2000);
                        } catch (AWTException ex) {
                            ex.printStackTrace();
                        }
                    }
                    OrderService order = new OrderService();
                    try {
                        order.setMethods(method);
                        order.setOrder(allchoices);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    frame.dispose();
                    SPaymentGUI.main(null);
                }
            }
        });
        cashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    method = temp.getText();
            }
        });
        creditCardRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton temp = (JRadioButton) e.getSource();
                if (temp.isSelected())
                    method = temp.getText();
            }
        });
    }

}
