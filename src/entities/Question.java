package src.entities;

public class Question {
    public String question;
    public String answer;

    public Song song1;

    public Song song2;

    public int pointsAwarded;

    public String getQuestion(){
        return this.question;
    }

    // NOTE: FINISH IMPLEMENTATION(AMELIA)
    public void setQuestion(){
        //...
        // Generate question in form of String using 2 Songs in this.songs, call Song.title
    }

    public String getAnswer(){
        return this.answer;
    }
    public void setAnswer(){
        // Retrieve song in this.songs that has the highest Song.popularity attribute
    }

    public Song getSong1(){
        return this.song1;
    }

    public void setSong1(){
        // Randomly select 2 songs... maybe change Song implementation so that Songs are generated randomly???
        // Maybe choose 2 songs with a popularity rating similar to each other/within certain range
    }

    public Song getSong2(){
        return null;
    }

    public void setSong2(){
        //...
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
