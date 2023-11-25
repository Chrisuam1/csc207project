package src.entities;
public class Player {

    private String name;
    private int score;

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }
    public int getScore() {return score;}

    // value for point to be determined by taking the difference of the popularity of the two songs and assigning point value accordingly. Point values to be decided later.
    public void setScore(int point) {
        this.score = score + point;
    }
}
