package test.entities;

import api.ApiHandlerClient;
import entities.Song;
import entities.factories.SpotifyApiSongFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class SpotifySongFactoryTest {
    private static Song song;

    private static ArrayList<String> artistList;

    @BeforeClass
    public static void init() {
        String ID = System.getenv("ID");
        String SECRET = System.getenv("SECRET");
        ApiHandlerClient api = new ApiHandlerClient(ID, SECRET);
        api.authenticate();
        SpotifyApiSongFactory spotifyApiSongFactory = new SpotifyApiSongFactory(api);

        song = spotifyApiSongFactory.create("5sdQOyqq2IDhvmx2lHOpwd"); // song id for "Super Shy" by NewJeans
        artistList = new ArrayList<>();
        artistList.add("NewJeans");
    }

    @Test
    public void getId() {
        assertEquals("5sdQOyqq2IDhvmx2lHOpwd", song.getId());
    }

    @Test
    public void getTitle() {assertEquals("Super Shy", song.getTitle());}

    @Test
    public void getArtists() {assertEquals(artistList, song.getArtists());}

    @Test
    public void getYearReleased() {assertEquals("2023-07-7", song.getYearReleased());}




}