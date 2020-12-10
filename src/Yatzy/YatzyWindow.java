package Yatzy;

import javax.swing.*;

public class YatzyWindow extends JFrame {

    private JPanel mainPanel = new JPanel();
    private StartPanel startPanel = new StartPanel();
    private YatzyPanel yatzyPanel = new YatzyPanel();

    public YatzyWindow(){
        setUpJFrame();
        changePanelTo(startPanel);

    }

    public void setUpJFrame(){
        add(mainPanel);
        this.setLocation(300,150);
        this.setSize(530,530);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void changePanelTo(JPanel panel) {
        mainPanel.removeAll();
        mainPanel.add(panel);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // Getters
    public StartPanel getStartPanel() {
        return startPanel;
    }

    public YatzyPanel getYatzyPanel() {
        return yatzyPanel;
    }
}
