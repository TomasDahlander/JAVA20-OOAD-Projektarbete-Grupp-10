package Yatzy;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {

    // Backgroundcolor
    private Color color = new Color(184,207,229);

    // Panels
    private JPanel topPanel = new JPanel(new GridLayout(1,2,10,10));
    private JPanel middlePanel = new JPanel();
    private JPanel bottomPanel = new JPanel(); // new GridLayout(1,1)

    // Buttons
    private JToggleButton rankedGameButton = new JToggleButton("Ranked Game");
    private JToggleButton unrankedGameButton = new JToggleButton("Not ranked Game");
    private JButton startGameButton = new JButton("Start Game");

    // Textfield
    private JTextField nameField = new JTextField("",14);

    // Label
    private JLabel nameLabel = new JLabel("Enter your name: ");

    public StartPanel(){
        setUpThisJPanel();
        setUpJPanels();
        setUpAndAddToggleButtons();
        setUpAndAddLabel();
        setUpAndAddTextfield();
        setUpAndAddStartGameButton();

        this.revalidate();
        this.repaint();
    }

    public void setUpThisJPanel(){
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        this.setBackground(color);
        this.setLayout(new GridLayout(3,1,10,10));
        this.setPreferredSize(new Dimension(500, 480));
    }

    public void setUpJPanels(){
        topPanel.setOpaque(false);
        middlePanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        this.add(topPanel);
        this.add(middlePanel);
        this.add(bottomPanel);
    }

    public void setUpAndAddToggleButtons(){
        rankedGameButton.setOpaque(true);
        rankedGameButton.setBorder(BorderFactory.createLineBorder(color,30));
        rankedGameButton.setFont(new Font("SansSerif", Font.BOLD,20));
        unrankedGameButton.setOpaque(true);
        unrankedGameButton.setBorder(BorderFactory.createLineBorder(color,30));
        unrankedGameButton.setFont(new Font("SansSerif", Font.BOLD,20));
        topPanel.add(rankedGameButton);
        topPanel.add(unrankedGameButton);
    }

    public void setUpAndAddLabel(){
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
        nameLabel.setVisible(false);
        middlePanel.add(nameLabel, CENTER_ALIGNMENT);
    }

    public void setUpAndAddTextfield(){
        nameField.setHorizontalAlignment(SwingConstants.CENTER);
        nameField.setFont(new Font("SansSerif",Font.ITALIC,25));
        nameField.setVisible(false);
        middlePanel.add(nameField, CENTER_ALIGNMENT);
    }

    public void setUpAndAddStartGameButton(){
        startGameButton.setFont(new Font("SansSerif", Font.BOLD,20));
        startGameButton.setEnabled(false);
        bottomPanel.add(startGameButton);
    }

    public void repaintTextField(){
        middlePanel.revalidate();
        middlePanel.repaint();
    }

    // Getters
    public JTextField getNameField() {
        return nameField;
    }

    public JToggleButton getRankedGameButton() {
        return rankedGameButton;
    }

    public JToggleButton getUnrankedGameButton() {
        return unrankedGameButton;
    }

    public JButton getStartGameButton() {
        return startGameButton;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public Color getColor() {
        return color;
    }
}
