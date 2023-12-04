package test.entities;

import api.ApiHandlerClient;
import entities.Album;
import entities.factories.SpotifyApiAlbumFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class SpotifyAlbumFactoryTest {
    private static Album album;
    private static ArrayList<String> artists;

    @BeforeClass
    public static void init() {
        String ID = System.getenv("ID");
        String SECRET = System.getenv("SECRET");
        ApiHandlerClient api = new ApiHandlerClient(ID, SECRET);
        api.authenticate();
        SpotifyApiAlbumFactory spotifyApiAlbumFactory = new SpotifyApiAlbumFactory(api);

        album = spotifyApiAlbumFactory.create("1NAmidJlEaVgA3MpcPFYGq"); // album id for "Lover" by Taylor Swift
        artists = new ArrayList<>();
        artists.add("Taylor Swift");
    }

    @Test
    public void getID() {assertEquals("1NAmidJlEaVgA3MpcPFYGq", album.getId());}

    @Test
    public void getTitle() {assertEquals("Lover", album.getTitle());}

//    @Test
//    public void getSongs() {assertEquals();}

    @Test
    public void getArtists() {assertEquals(artists, album.getArtists());}

//    @Test
//    public void getBufferedImage() {assertEquals();}

    @Test
    public void getYearReleased() {assertEquals("2019-08-23", album.getYearReleased());}




}