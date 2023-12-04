package entity_tests;

import entities.Album;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {
    private Album album;
    private ArrayList<String> artists;

    @BeforeEach
    void init() {
        album = new Album("1NAmidJlEaVgA3MpcPFYGq"); // album id for "Lover" by Taylor Swift
        artists.add("Taylor Swift");
    }

    @Test
    void getID() {assertEquals("1NAmidJlEaVgA3MpcPFYGq", album.getId());}

    @Test
    void getTitle() {assertEquals("Lover", album.getTitle());}

//    @Test
//    void getSongs() {assertEquals();}

    @Test
    void getArtists() {assertEquals(artists, album.getArtists());}

//    @Test
//    void getBufferedImage() {assertEquals();}

    @Test
    void getYearReleased() {assertEquals("2019", album.getYearReleased());}




}