package entities;

import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Image;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Album {
    private final String id;
    private final String title;
    private final HashMap<String, String> songs;    // map of {id : songName}
    private final ArrayList<String> artists;
    private final ArrayList<BufferedImage> coverImages;
    private final String yearReleased;

    public Album(String id,
                 String title,
                 HashMap<String, String> songs,
                 ArrayList<String> artists,
                 ArrayList<BufferedImage> coverImages,
                 String yearReleased) {
        this.id = id;
        this.title = title;
        this.songs = songs;
        this.artists = artists;
        this.coverImages = coverImages;
        this.yearReleased = yearReleased;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public HashMap<String, String> getSongs() {
        return songs;
    }

    public ArrayList<String> getArtists() {
        return artists;
    }

    public ArrayList<BufferedImage> getCoverImages() {
        return coverImages;
    }

    public String getYearReleased() {
        return yearReleased;
    }
}
