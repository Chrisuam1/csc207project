package entities;

import java.util.ArrayList;

/**
 * Represents a song from Spotify's database
 */

public class Song {
    private final String id;
    private final String title;
    private final ArrayList<String> artists;
    private final double popularity;
    private final double danceability;
    private final Album album;
    private final String yearReleased;

    public Song(String id,
                String title,
                ArrayList<String> artists,
                double popularity,
                double danceability,
                Album album,
                String yearReleased) {
        this.id = id;
        this.title = title;
        this.artists = artists;
        this.popularity = popularity;
        this.danceability = danceability;
        this.album = album;
        this.yearReleased = yearReleased;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getArtists() {
        return artists;
    }

    public double getPopularity() {
        return popularity;
    }

    public double getDanceability() {
        return danceability;
    }

    public Album getAlbum() {
        return album;
    }

    public String getYearReleased() {
        return yearReleased;
    }
}
