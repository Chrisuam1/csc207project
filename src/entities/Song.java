package api.src.entities;

import java.util.ArrayList;

public class Song {
    private final String id;
    private String title;
    private ArrayList<String> artists;
    private double popularity;
    private double danceability;
    private String yearReleased;
    private Album album;

    public Song(String id) {
        this.id = id;
    }

    public String getID() {return id;}
    public String getTitle() {return title; }
    public void setTitle(String title) {this.title = title;}

    public ArrayList<String> getArtists() {return artists;}

    public double getPopularity() {return popularity; }
    public void setPopularity(double popularity) {this.popularity = popularity;}

    public double getDanceability() {return danceability; }
    public void setDanceability(double danceability) {this.danceability = danceability;}

    public String getYearReleased() {return yearReleased; }
    public void setYearReleased(String yearReleased) {this.yearReleased = yearReleased;}

    public Album getAlbum() {return album; }
    public void setAlbum(Album album) {this.album = album;}
}
