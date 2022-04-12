import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class LeaderboardPanel extends JPanel {
    static final int SCREEN_WIDTH = 300;
    static final int SCREEN_HEIGHT = 600;
    public String highScore;

    LeaderboardPanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        startLeaderboard();
    }

    public void startLeaderboard(){


    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        leaderboardDisplay(g);
    }

    public String toString(int score, int position){
        return highScore = "Congratulations! You have achieved a new high score of " + score +
                ", and are in position "+ position;
    }

    GamePanel gamepanel = new GamePanel();
    int[] scoreList = gamepanel.getScoreList();
    int score = gamepanel.getApplesEaten();
    int position = 0;
    public String scorePosition() {


        for (int i = 0; i < scoreList.length; i++) {
            if (score > scoreList[i]) {
                position = i;
                scoreList[i] = score;
                break;
            }
        }
        return toString(score, position);
    }

    public void leaderboardDisplay(Graphics g){
        g.setColor(Color.green);
        g.setFont(new Font("Ink Free", Font.BOLD, 50));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString(scorePosition(), (SCREEN_WIDTH - metrics.stringWidth(scorePosition())) / 2,
                SCREEN_HEIGHT / 5);

        g.setFont(new Font("Ink Free", Font.BOLD, 20));
        FontMetrics list = getFontMetrics(g.getFont());
        for(int i =0; i<scoreList.length; i++){
            g.drawString(i+1 + ": "+ scoreList[i], (SCREEN_WIDTH - list.stringWidth(i+1 + ": "+ scoreList[i])) / 2,
                    SCREEN_HEIGHT / (i+1));
        }
    }
}
