package Yatzy;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class YatzyPanel extends JPanel {

    // Panels
    private JPanel eastPanel = new JPanel(new BorderLayout());
    private JLabel tableLabel = new JLabel(" Omgång      Poäng ");
    private JPanel buttonPanel = new JPanel(new GridLayout(1,3));
    private JPanel dicePanel = new JPanel(new GridLayout(3,3));

    // Buttons
    private JButton rollButton = new JButton("Starta omgång");
    private JButton showScoreButton = new JButton("Visa highscore");

    // ScoreBoard
    private JPanel scoreBoard = new JPanel(new GridLayout(1,2));
    private JPanel scoreBoardRounds = new JPanel(new GridLayout(8,1));
    private JPanel scoreBoardScores = new JPanel(new GridLayout(8,1));
    private List<JLabel> scoreLabels = new ArrayList<>();
    private List<JLabel> roundLabels = new ArrayList<>();

    private JToggleButton[] diceButtons = new JToggleButton[5];

    public YatzyPanel(){
        setUpThisJPanel();
        setUpPanels();
        setUpScoreBoard();
        setUpDices();

        this.revalidate();
        this.repaint();
    }

    public void setUpThisJPanel(){
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 480));
    }

    public void setUpPanels(){
        this.add(eastPanel,BorderLayout.EAST);
        scoreBoardRounds.setBackground(Color.WHITE);
        scoreBoardScores.setBackground(Color.WHITE);
        scoreBoard.add(scoreBoardRounds);
        scoreBoard.add(scoreBoardScores);
        eastPanel.add(scoreBoard, BorderLayout.CENTER);
        eastPanel.add(tableLabel, BorderLayout.NORTH);
        buttonPanel.add(rollButton);
        buttonPanel.add(showScoreButton);
        buttonPanel.setPreferredSize(new Dimension(500,40));
        this.add(buttonPanel,BorderLayout.SOUTH);
        dicePanel.setBackground(Color.WHITE);
        this.add(dicePanel);
    }

    public void setUpScoreBoard(){
        for(int i = 0; i < 8; i++){
            roundLabels.add(new JLabel(String.valueOf(i+1)));
            roundLabels.get(i).setBorder(new EtchedBorder());
            roundLabels.get(i).setOpaque(true);
            roundLabels.get(i).setBackground(Color.white);
            roundLabels.get(i).setHorizontalAlignment(SwingConstants.CENTER);
            roundLabels.get(i).setFont(new Font("MonoSpaced", Font.BOLD, 18));
            scoreBoardRounds.add(roundLabels.get(i));
            if (i == 6) roundLabels.get(i).setText("Bonus");
            if (i == 7) roundLabels.get(i).setText("Summa");
        }

        for(int i = 0; i < 8; i++){
            scoreLabels.add(new JLabel(""));
            scoreLabels.get(i).setFont(new Font("MonoSpaced", Font.PLAIN, 20));
            scoreLabels.get(i).setBorder(new EtchedBorder());
            scoreLabels.get(i).setHorizontalAlignment(SwingConstants.CENTER);
            scoreBoardScores.add(scoreLabels.get(i));
        }
    }

    public void setUpDices(){
        int count = 0;

        for(int i = 0; i < 9; i++){
            if(i%2 == 0){
                diceButtons[count] = new JToggleButton("0");
                diceButtons[count].setOpaque(true);
                diceButtons[count].setBackground(Color.GREEN);
                diceButtons[count].setFont(new Font("MonoSpaced", Font.BOLD, 100));
                diceButtons[count].setBorder(BorderFactory.createLineBorder(Color.WHITE,15));
                dicePanel.add(diceButtons[count]);
                count++;
            }
            else{
                dicePanel.add(new JLabel());
            }
        }
    }

    public void setDieColor(Color color) {
        for (JToggleButton die : diceButtons) {
            die.setBackground(color);
        }
    }

    // Getters
    public JButton getRollButton() {
        return rollButton;
    }

    public JButton getShowScoreButton() {
        return showScoreButton;
    }

    public List<JLabel> getScoreLabels() {
        return scoreLabels;
    }

    public List<JLabel> getRoundLabels() {
        return roundLabels;
    }

    public JToggleButton[] getDiceButtons() {
        return diceButtons;
    }
}

