package entities.factories;

import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.AudioFeatures;
import se.michaelthelin.spotify.model_objects.specification.Track;
import api.ApiHandlerClient;
import entities.Song;
import entities.Album;
import java.util.ArrayList;



public class SpotifyApiSongFactory implements SongFactory {
    ApiHandlerClient api;

    public SpotifyApiSongFactory(ApiHandlerClient api) {
        this.api = api;
    }
    @Override
    public Song create(String id) {
        //Song song = new Song(id);
        Track t = api.makeTrackRequest(id);
        AudioFeatures a = api.makeAudioFeaturesRequest(id);

        String name = t.getName();
        double popularity = t.getPopularity();
        double danceability = a.getDanceability();
        Album album = new SpotifyApiAlbumFactory(api).create(t.getAlbum().getId());
        String yearReleased = album.getYearReleased();

        // get all the artists for the track
        ArrayList<String> artists = new ArrayList<>();
        for (ArtistSimplified i : t.getArtists()) {
            artists.add(i.getName());
        }

        return new Song (id, name, artists, popularity, danceability, album, yearReleased);
    }
}
