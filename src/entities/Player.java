package entities;

public class Player implements Comparable<Player>{

    private static int ID_GENERATOR = 0;
    private final int id;
    private final String name;
    private double score;

    public Player(String name) {
        this.id = ID_GENERATOR++;
        this.name = name;
        score = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    // value for point to be determined by taking the difference of the popularity of the two songs
    // and assigning point value accordingly. Point values to be decided later.
    public void setScore(double score) {
        this.score = score;
    }

    public void addScore(double score) {
        this.score += score;
    }

    // Allows players to be sorted based on score, used in Leaderboard
    @Override
    public int compareTo(Player otherPlayer) {
        return Double.compare(this.score, otherPlayer.score);
    }

}
