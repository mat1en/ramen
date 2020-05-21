package GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import service.StatisticsService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewStats {
    private JFrame frame0;
    private JButton soupButton;
    private JButton noodlesButton;
    private JButton springOnionButton;
    private JButton spicinessButton;
    private JButton addOnsButton;
    private JButton diningOptionsButton;
    private JButton backButton;
    private JPanel ViewStatsPanel;
    private JLabel viewStatsLabel;

/*    public ViewStats() {
        frame0 = new JFrame("ViewStats");
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame0.dispose();
                ManagementGUI.main(null);
            }
        });
    }*/


    public ViewStats() {
        frame0 = new JFrame("ViewStats");
        frame0.setContentPane(ViewStatsPanel);
        frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame0.setSize(600, 500);
        frame0.setPreferredSize(new Dimension(600, 500));
        frame0.setLocationRelativeTo(null);
        frame0.pack();
        frame0.setVisible(true);

        StatisticsService statisticsService = new StatisticsService();

        soupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message="Tonkotsu: "+statisticsService.getStatistics("Tonkotsu")+"\n" +
                        "Shoyu: "+statisticsService.getStatistics("Shoyu")+"\n" +
                        "Shio: "+statisticsService.getStatistics("Shio");
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, new String(message),
                        "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
            }
        });
        noodlesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message="Soft: "+statisticsService.getStatistics("Soft")+"\n" +
                        "Medium: "+statisticsService.getStatistics("Medium")+"\n" +
                        "Firm: "+statisticsService.getStatistics("Firm");
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, new String(message),
                        "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
            }
        });
        springOnionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message="No please: "+statisticsService.getStatistics("No please")+"\n" +
                        "Just a little: "+statisticsService.getStatistics("Just a little")+"\n" +
                        "A lot!: "+statisticsService.getStatistics("A lot!");
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, new String(message),
                        "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
            }
        });
        spicinessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message="1: "+statisticsService.getStatistics("Spiciness1")+"\n" +
                        "2: "+statisticsService.getStatistics("Spiciness2")+"\n" +
                        "3: "+statisticsService.getStatistics("Spiciness3")+"\n" +
                        "4: "+statisticsService.getStatistics("Spiciness4")+"\n" +
                        "5: "+statisticsService.getStatistics("Spiciness5");
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, new String(message),
                        "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
            }
        });
        addOnsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message="Nori: "+statisticsService.getStatistics("Nori")+statisticsService.getStatistics("AddNori")+"\n" +
                        "Chasu: "+statisticsService.getStatistics("Chasu")+statisticsService.getStatistics("AddChasu")+"\n" +
                        "Boiled eggs: "+statisticsService.getStatistics("Egg")+statisticsService.getStatistics("AddEgg")+"\n" +
                        "Bamboo shoots: "+statisticsService.getStatistics("AddBamboo");
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, new String(message),
                        "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
            }
        });
        diningOptionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message="Eat in: "+statisticsService.getStatistics("Eat in")+"\n" +
                        "Take-away: "+statisticsService.getStatistics("Take-away");
                Object[] options = {"OK"};
                JOptionPane.showOptionDialog(null, new String(message),
                        "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame0.dispose();
                ManagementGUI.main(null);
            }
        });
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
        ViewStatsPanel = new JPanel();
        ViewStatsPanel.setLayout(new GridLayoutManager(10, 2, new Insets(0, 0, 0, 0), -1, -1));
        ViewStatsPanel.setBackground(new Color(-721665));
        viewStatsLabel = new JLabel();
        viewStatsLabel.setEnabled(true);
        Font viewStatsLabelFont = this.$$$getFont$$$(null, Font.BOLD, 28, viewStatsLabel.getFont());
        if (viewStatsLabelFont != null) viewStatsLabel.setFont(viewStatsLabelFont);
        viewStatsLabel.setText("View Stats");
        ViewStatsPanel.add(viewStatsLabel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        ViewStatsPanel.add(spacer1, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        soupButton = new JButton();
        Font soupButtonFont = this.$$$getFont$$$(null, -1, 20, soupButton.getFont());
        if (soupButtonFont != null) soupButton.setFont(soupButtonFont);
        soupButton.setText("Soup");
        ViewStatsPanel.add(soupButton, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, -1), null, 0, false));
        noodlesButton = new JButton();
        Font noodlesButtonFont = this.$$$getFont$$$(null, -1, 20, noodlesButton.getFont());
        if (noodlesButtonFont != null) noodlesButton.setFont(noodlesButtonFont);
        noodlesButton.setText("Noodles");
        ViewStatsPanel.add(noodlesButton, new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, -1), null, 0, false));
        springOnionButton = new JButton();
        Font springOnionButtonFont = this.$$$getFont$$$(null, -1, 20, springOnionButton.getFont());
        if (springOnionButtonFont != null) springOnionButton.setFont(springOnionButtonFont);
        springOnionButton.setText("Spring Onion");
        ViewStatsPanel.add(springOnionButton, new GridConstraints(4, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, -1), null, 0, false));
        spicinessButton = new JButton();
        Font spicinessButtonFont = this.$$$getFont$$$(null, -1, 20, spicinessButton.getFont());
        if (spicinessButtonFont != null) spicinessButton.setFont(spicinessButtonFont);
        spicinessButton.setText("Spiciness");
        ViewStatsPanel.add(spicinessButton, new GridConstraints(5, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, -1), null, 0, false));
        addOnsButton = new JButton();
        Font addOnsButtonFont = this.$$$getFont$$$(null, -1, 20, addOnsButton.getFont());
        if (addOnsButtonFont != null) addOnsButton.setFont(addOnsButtonFont);
        addOnsButton.setText("Add-ons");
        ViewStatsPanel.add(addOnsButton, new GridConstraints(6, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, -1), null, 0, false));
        diningOptionsButton = new JButton();
        Font diningOptionsButtonFont = this.$$$getFont$$$(null, -1, 20, diningOptionsButton.getFont());
        if (diningOptionsButtonFont != null) diningOptionsButton.setFont(diningOptionsButtonFont);
        diningOptionsButton.setText("Dining Options");
        ViewStatsPanel.add(diningOptionsButton, new GridConstraints(7, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, -1), null, 0, false));
        final Spacer spacer2 = new Spacer();
        ViewStatsPanel.add(spacer2, new GridConstraints(8, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        backButton = new JButton();
        Font backButtonFont = this.$$$getFont$$$(null, -1, 20, backButton.getFont());
        if (backButtonFont != null) backButton.setFont(backButtonFont);
        backButton.setText("Back");
        ViewStatsPanel.add(backButton, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        ViewStatsPanel.add(spacer3, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
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
        return ViewStatsPanel;
    }

    /*    public static void main(String[] args) {
        frame0.setContentPane(new ViewStats().ViewStatsPanel);
        frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame0.setSize(600, 500);
        frame0.setPreferredSize(new Dimension(600, 500));
        frame0.setLocationRelativeTo(null);
        frame0.pack();
        frame0.setVisible(true);
    }*/

    public static void main(String[] args) {
        ViewStats viewStats = new ViewStats();
    }
}
