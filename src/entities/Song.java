package api.src.entities;

public class Song {

    private final String title;

    private final String artist;

    private final Integer popularity;

    private final Integer danceability;

    private final Integer yearReleased;

    private final Album album;

    Song(String title, String artist, Integer popularity, Integer danceability, Integer yearReleased, Album album) {
        this.title = title;
        this.artist = artist;
        this.popularity = popularity;
        this.danceability = danceability;
        this.yearReleased = yearReleased;
        this.album = album;
    }

    public String getTitle() {return title; }

    public String getArtist() {return artist; }

    public Integer getPopularity() {return popularity; }

    public Integer getDanceability() {return danceability; }

    public Integer getYearReleased() {return yearReleased; }

    public Album getAlbum() {return album; }


}
