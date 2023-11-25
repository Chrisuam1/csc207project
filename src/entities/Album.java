package api.src.entities;

import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Image;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Album {
    private final String id;
    private String title;
    private ArrayList<Song> songs;
    private ArrayList<String> artists;
    private ArrayList<BufferedImage> coverImages;
    private String yearReleased;

    Album(String id) {
        this.id = id;
    }

    public String getId() {return id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public ArrayList<Song> getSongs() {return songs;}
    public ArrayList<String> getArtists() {return artists;}
    public ArrayList<BufferedImage> getCoverImages() {return coverImages;}
    public String getYearReleased() {return yearReleased;}
    public void setYearReleased(String year) {this.yearReleased = year;}
}
