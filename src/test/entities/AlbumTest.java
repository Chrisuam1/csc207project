package test.entities;

import entities.Album;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class AlbumTest {
    private Album album;

    private HashMap<String, String> songs;

    private HashMap<String, String> FrankSongs;
    private ArrayList<String> artists;

    @Before
    public void init() {
        songs = new HashMap<>();
        songs.put("b", "songB");
        songs.put("c", "songC");
        artists = new ArrayList<>();
        artists.add("Frank Sinatra");
        album = new Album("a", "albumA", songs, artists, null, "1980");
    }

    @Test
    public void getID() {assertEquals("a", album.getId());}

    @Test
    public void getTitle() {assertEquals("albumA", album.getTitle());}

    @Test

    public void getSongs() {assertEquals(songs, album.getSongs());}

    @Test
    public void getArtists() {assertEquals(artists, album.getArtists());}

    @Test
    public void getYearReleased() {assertEquals("1980", album.getYearReleased());}




}