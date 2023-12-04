package entity_tests;

import entities.Song;
import entities.Album;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    private Song song;
    private Album album;
    @BeforeEach
    void init() {
        song = new Song("1BxfuPKGuaTgP7aM0Bbdwr"); // song id for "Cruel Summer" by Taylor Swift
        album = new Album("1NAmidJlEaVgA3MpcPFYGq"); // album id for "Lover" by Taylor Swift
    }
    @Test
    void getId() {
        assertEquals("1BxfuPKGuaTgP7aM0Bbdwr", song.getID());
    }

    @Test
    void getTitle() {
        assertEquals("Cruel Summer", song.getTitle());
    }

    @Test
    void getArtists() {
        ArrayList<String> artists = new ArrayList<String>();
        artists.add("Taylor Swift");
        assertEquals(artists, song.getArtists());
    }

    @Test
    void getPopularity() {
        assertEquals(99, song.getPopularity());
    }

    @Test
    void getDanceability() {
        assertEquals(0.552, song.getDanceability());
    }

    @Test
    void getYearReleased() {
        assertEquals("2019", song.getYearReleased());
    }

    @Test
    void getAlbum() {
        assertEquals(album, song.getAlbum());
    }

}