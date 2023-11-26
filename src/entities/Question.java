package src.entities;

import java.util.ArrayList;

import java.lang.Math;

public class Question {
    public Song answer;

    public Song song1;

    public Song song2;

    public double pointsAwarded;

    public Song getAnswer() {
        return this.answer;
    }

    public void setAnswer() {
        if (this.song1.getPopularity() > this.song2.getPopularity()) {
            this.answer = song1;
        } else {
            this.answer = song2;
        }
    }

    // IMPORTANT: SETTER SETS BOTH SONG1 & SONG1 AT ONCE!!!
    public void setSongs(ArrayList<Song> songlist) {
        this.song1 = songlist.get(0);
        this.song2 = songlist.get(1);
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

    public void setPointsAwarded() {
        this.pointsAwarded = (1 / (this.song1.getPopularity() - this.song2.getPopularity())) * 1000;
    }
}