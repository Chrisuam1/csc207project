package test.entities;

import entities.Song;
import entities.Album;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SongTest {
    private Song song;
    private Album album;
    @Before
    public void init() {
        song = new Song(
                "a",
                "titleA",
                new ArrayList<>(Arrays.asList("Amanda","Alan")),
                50,
                0.4,
                null,
                "2001");
    }
    @Test
    public void getId() {
        assertEquals("a", song.getId());
    }

    @Test
    public void getTitle() {
        assertEquals("titleA", song.getTitle());
    }

    @Test
    public void getArtists() {
        ArrayList<String> artists = new ArrayList<String>();
        artists.add("Amanda");
        artists.add("Alan");
        assertEquals(artists, song.getArtists());
    }

    @Test
    public void getPopularity() {
        assertEquals(50, song.getPopularity(),0);
    }

    @Test
    public void getDanceability() {
        assertEquals(0.4, song.getDanceability(),0);
    }

    @Test
    public void getYearReleased() {
        assertEquals("2001", song.getYearReleased());
    }

    @Test
    public void getAlbum() {
        assertEquals(null, song.getAlbum());
    }

}