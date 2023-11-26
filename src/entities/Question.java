package src.entities;

public class Question {
    public Song answer;

    public Song song1;

    public Song song2;

    public int pointsAwarded;

    public Song getAnswer(){
        return this.answer;
    }
    public void setAnswer(){
        if (this.song1.getPopularity() > this.song2.getPopularity()){
            this.answer = song1;
        }
        else{
            this.answer = song2;
        }
    }

    public Song getSong1(){
        return this.song1;
    }

    public void setSong1(){
        // Randomly select 2 songs... maybe change Song implementation so that Songs are generated randomly???
        // Maybe choose 2 songs with a popularity rating similar to each other/within certain range
    }

    public Song getSong2(){
        ...
    }

    public void setSong2(){
        ...
    }
    public int getPointsAwarded(){
        return this.pointsAwarded;
    }
    // NOTE: FINISH IMPLEMENTATION(AMELIA)
    public void setPointsAwarded(){
        // Set points by difficulty; take difference in Song.popularity and multiply to get points
        int points = 0;
        this.pointsAwarded = points;
    }
}
