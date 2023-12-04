package entities.factories;

import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.AudioFeatures;
import se.michaelthelin.spotify.model_objects.specification.Track;
import api.ApiHandlerClient;
import entities.Song;
import entities.Album;
import java.util.ArrayList;

/**
 * Creates a Song from a song ID using the spotify API
 */

public class SpotifyApiSongFactory implements SongFactory {
    ApiHandlerClient api;

    public SpotifyApiSongFactory(ApiHandlerClient api) {
        this.api = api;
    }

    @Override
    public Song create(String id) {

        // get the song and its features using the API
        Track spotifySong = api.makeTrackRequest(id);
        AudioFeatures spotifySongFeatures = api.makeAudioFeaturesRequest(id);

        String name = spotifySong.getName();
        double popularity = spotifySong.getPopularity();
        double danceability = spotifySongFeatures.getDanceability();
        Album album = new SpotifyApiAlbumFactory(api).create(spotifySong.getAlbum().getId());
        String yearReleased = album.getYearReleased();

        // get artists for the track
        ArrayList<String> artists = new ArrayList<>();
        for (ArtistSimplified artist : spotifySong.getArtists()) {
            artists.add(artist.getName());
        }

        return new Song (id, name, artists, popularity, danceability, album, yearReleased);
    }
}
