package entities;
public class Player {

    private final String name;
    private double score;

    public Player(String name) {
        this.name = name;
        score = 0.0;
    }

    public String getName() {return name;}
    public double getScore() {return score;}

    // value for point to be determined by taking the difference of the popularity of the two songs
    // and assigning point value accordingly. Point values to be decided later.
    public void setScore(double score) {
        this.score = score;
    }

    public void addScore(double score) {
        this.score += score;
    }
}
