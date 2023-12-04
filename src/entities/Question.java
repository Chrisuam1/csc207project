package entities;

import java.util.ArrayList;

import java.lang.Math;

public class Question {
    public Song answer;

    public Song song1;

    public Song song2;

    public double pointsAwarded;

    public Question(ArrayList<Song> songList){
        // Setting song1 and song2 attributes
        this.song1 = songList.get(0);
        this.song2 = songList.get(1);
        // Setting answer attribute
        if (this.song1.getPopularity() > this.song2.getPopularity()) {
            this.answer = song1;
        } else {
            this.answer = song2;
        }
        // Setting pointsAwarded attribute
        this.pointsAwarded = (1 / (this.song1.getPopularity() - this.song2.getPopularity())) * 1000;
    }

    public Song getAnswer() {
        return this.answer;
    }

    public Song getSong1() {
        return this.song1;
    }

    public Song getSong2() {
        return this.song2;
    }

    public double getPointsAwarded() {
        return this.pointsAwarded;
    }
}