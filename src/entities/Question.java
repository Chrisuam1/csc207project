package entities;

/**
 * A question that asks which of two songs is more popular (as determined by spotify).
 * Awards more points if the two songs have similar popularity scores.
 */

public class Question {

    private final Song answer;
    private final Song song1;
    private final Song song2;
    private final double pointsAwarded;

    /**
     * Creates a question based on two songs' popularity
     * Precondition: song1.popularity != song2.popularity
     * @param song1
     * @param song2
     */
    public Question(Song song1, Song song2) {
        this.song1 = song1;
        this.song2 = song2;
        pointsAwarded = calculatePointsAwarded();
        answer = calculateAnswer();
    }

    public Song getAnswer(){
        return this.answer;
    }

    public Song getSong1(){
        return this.song1;
    }

    public Song getSong2(){
        return song2;
    }

    public double getPointsAwarded(){
        return this.pointsAwarded;
    }

    // helper method that determines how many points are awarded
    private double calculatePointsAwarded() {
        return ((1 /
                Math.abs(
                        (this.song1.getPopularity() - this.song2.getPopularity())
                )) * 1000);
    }

    // helper method that determines the answer
    private Song calculateAnswer() {
        if (song1.getPopularity() > song2.getPopularity()) {
            return song1;
        }
        else return song2;
    }
}
