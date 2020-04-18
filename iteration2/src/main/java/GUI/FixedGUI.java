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

            String noodles = choices[1];
            if (noodles.equals(softRadioButton.getText())) {
                softRadioButton.setSelected(true);
                noodleChoice = noodles;
            } else if (noodles.equals(mediumdRadioButton.getText())) {
                mediumdRadioButton.setSelected(true);
                noodleChoice = noodles;
            } else if (noodles.equals(firmRadioButton.getText())) {
                firmRadioButton.setSelected(true);
                noodleChoice = noodles;
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

}
