package entities.factories;

import api.ApiHandlerClient;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Image;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Creates an Album from an album ID using the Spotify API
 */

public class SpotifyApiAlbumFactory implements AlbumFactory {
    ApiHandlerClient api;

    public SpotifyApiAlbumFactory(ApiHandlerClient api) {this.api = api;}
    @Override
    public entities.Album create(String id) {

        // NOTE: entities.Album != spotify api Album
        // need to disambiguate since they have the same name
        se.michaelthelin.spotify.model_objects.specification.Album spotifyAlbum = api.makeAlbumRequest(id);

        String title = spotifyAlbum.getName();
        String yearReleased = spotifyAlbum.getReleaseDate();

        // get songs in album
        HashMap<String, String> songs = new HashMap<>();
        Paging<TrackSimplified> tracks = spotifyAlbum.getTracks();
        for (TrackSimplified song : tracks.getItems()) {
            songs.put(song.getId(), song.getName());
        }

        // get artists for the album
        ArrayList<String> artists = new ArrayList<>();
        for (ArtistSimplified i : spotifyAlbum.getArtists()) {
            artists.add(i.getName());
        }

        ArrayList<BufferedImage> coverImages = new ArrayList<>();
        Image[] images = spotifyAlbum.getImages();
        for (Image i : images) {
            try {
                coverImages.add(ImageIO.read(new URL(i.getUrl())));
            } catch (IOException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }

        return new entities.Album(id, title, songs, artists, coverImages, yearReleased);
    }
}
