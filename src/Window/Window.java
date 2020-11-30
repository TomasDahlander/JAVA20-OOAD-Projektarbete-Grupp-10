package Window;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2020-11-24 <br>
 * Time: 15:08 <br>
 * Project: JAVA20-OOAD-Projektarbete-Grupp-10 <br>
 */
public class Window extends JFrame {

    // Paneler
    JPanel eastPanel = new JPanel(new BorderLayout());
    JLabel tableLabel = new JLabel(" Omgång      Poäng ");
    JPanel buttonPanel = new JPanel(new GridLayout(1,3));
    JPanel dicePanel = new JPanel(new GridLayout(3,3));
    JLabel name = new JLabel("Namn: Orvar Karlsson");

    // Knappar
    JButton roll = new JButton("Kasta (3)");
    JButton save = new JButton("Spara highscore");
    JButton show = new JButton("Visa highscore");

    // ScoreBoard
    JPanel scoreBoard = new JPanel(new GridLayout(1,2));
    JPanel scoreBoardRounds = new JPanel(new GridLayout(8,1));
    JPanel scoreBoardScores = new JPanel(new GridLayout(8,1));
    List<JLabel> scoreLabels = new ArrayList<>();
    List<JLabel> roundLabels = new ArrayList<>();

    JToggleButton[] dices = new JToggleButton[5];

    int rolls = 3;

    public Window(){
        setUpJFrame();
        setUpPanels();
        setUpScoreBoard();
        setUpDices();
        setUpListeners(); // added here for test purposes

        this.revalidate();
        this.repaint();

    }

    public void setUpJFrame(){
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(500, 480));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void setUpPanels(){
        this.add(eastPanel,BorderLayout.EAST);
        scoreBoardRounds.setBackground(Color.WHITE);
        scoreBoardScores.setBackground(Color.WHITE);
        scoreBoard.add(scoreBoardRounds);
        scoreBoard.add(scoreBoardScores);
        eastPanel.add(scoreBoard, BorderLayout.CENTER);
        eastPanel.add(tableLabel, BorderLayout.NORTH);
        buttonPanel.add(roll);
        buttonPanel.add(save);
        buttonPanel.add(show);
        buttonPanel.setPreferredSize(new Dimension(500,40));
        this.add(buttonPanel,BorderLayout.SOUTH);
        this.add(name, BorderLayout.NORTH);
        dicePanel.setBackground(Color.WHITE);
        this.add(dicePanel);
    }

    public void setUpScoreBoard(){
        for(int i = 0; i < 8; i++){
            roundLabels.add(new JLabel(String.valueOf(i+1)));
            roundLabels.get(i).setBorder(new EtchedBorder());
            roundLabels.get(i).setHorizontalAlignment(SwingConstants.CENTER);
            roundLabels.get(i).setFont(new Font("MonoSpaced", Font.BOLD, 18));
            scoreBoardRounds.add(roundLabels.get(i));
            if (i == 6) roundLabels.get(i).setText("Bonus");
            if (i == 7) roundLabels.get(i).setText("Summa");
        }

        for(int i = 0; i < 8; i++){
            scoreLabels.add(new JLabel("")); // Just for show. this should be blank
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
                Random rand = new Random();
                dices[count] = new JToggleButton("Orvar Karlsson");
                dices[count].setOpaque(true);
                dices[count].setBackground(Color.PINK);
                dices[count].setBorder(BorderFactory.createLineBorder(Color.WHITE,15));
                dicePanel.add(dices[count]);
                count++;
            }
            else{
                dicePanel.add(new JLabel());
            }
        }
    }

    public void setUpListeners(){
        ActionListener rolling = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                for (int i = 0; i < dices.length; i++) {
                    int x = rand.nextInt(6) + 1;
                    dices[i].setText(String.valueOf(x));
                }
                rolls--;
                roll.setText("Kast (" + rolls + ")");
                if(rolls == 1) rolls = 4;
            }
        };
        roll.addActionListener(rolling);
    }

    public static void main(String[] args) {
        new Window();
    }
}
