package api.src.entities;

import api.src.api.ApiHandlerClient;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Image;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.TrackSimplified;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class SpotifyApiAlbumFactory implements AlbumFactory {
    ApiHandlerClient api;

    public SpotifyApiAlbumFactory(ApiHandlerClient api) {this.api = api;}
    @Override
    public Album create(String id) {
        Album album = new Album(id);
        se.michaelthelin.spotify.model_objects.specification.Album spotifyAlbum =
                api.makeAlbumRequest(album.getId());

        album.setTitle(spotifyAlbum.getName());
        album.setYearReleased(spotifyAlbum.getReleaseDate());

        Image[] images = spotifyAlbum.getImages();
        for (Image i : images) {
            try {
                album.getCoverImages().add(ImageIO.read(new URL(i.getUrl())));
            } catch (IOException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }

        ArtistSimplified[] artists = spotifyAlbum.getArtists();
        for (ArtistSimplified i : artists) {
            album.getArtists().add(i.getName());
        }

        Paging<TrackSimplified> tracks = spotifyAlbum.getTracks();
        for (TrackSimplified i : tracks.getItems()) {
            album.getSongs().add(
                    new SpotifyApiSongFactory(api).create(i.getId())
            ); // Iterate through all the TrackSimplified-s and create Song objects
        }
        return album;
    }
}
