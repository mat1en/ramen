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
}
