package Yatzy;

import java.io.Serializable;
import java.time.LocalDate;

public class Score implements Serializable {

    private String playerName;
    private int score;
    private LocalDate date;

    public Score(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
        this.date = LocalDate.now();
    }

    // Getter
    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("%-10s %4d %12s",playerName,score,date.toString());
    }
}
