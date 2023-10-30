package api.src.entities;
public class Album {

    private final String title;
    private final Song[] songs;

    private final String artist;

    private final String cover;

    private final Integer yearReleased;

    Album(String title, Song[] songs, String artist, String cover, Integer yearReleased) {
        this.title = title;
        this.songs = songs;
        this.artist = artist;
        this.cover = cover;
        this.yearReleased = yearReleased;
    }

    public String getTitle() {return title; }

    public Song[] getSongs() {return songs; }

    public String getArtist() {return artist; }

    public String getCover() {return cover; }

    public Integer getYearReleased() {return yearReleased; }
}
