import javax.swing.*;

public class Leaderboard extends JFrame {
    Leaderboard(){
        this.add(new LeaderboardPanel());
        this.setTitle("Leaderboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}