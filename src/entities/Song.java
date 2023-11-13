package api.src.entities;

public class Song {
    private final int id;
    private String title;
    private String artist;
    private double popularity;
    private double danceability;
    private int yearReleased;
    private Album album;

    public Song(int id) {
        this.id = id;
    }

    public int getID() {return id;}
    public String getTitle() {return title; }
    public void setTitle(String title) {this.title = title;}

    public String getArtist() {return artist; }

    public double getPopularity() {return popularity; }

    public double getDanceability() {return danceability; }

    public int getYearReleased() {return yearReleased; }

    public Album getAlbum() {return album; }
}
