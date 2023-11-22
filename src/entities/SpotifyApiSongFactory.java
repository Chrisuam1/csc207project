package api.src.entities;

import api.src.api.ApiHandlerClient;
import se.michaelthelin.spotify.model_objects.specification.AudioFeatures;
import se.michaelthelin.spotify.model_objects.specification.Track;

public class SpotifyApiSongFactory implements SongFactory {
    ApiHandlerClient api;

    public SpotifyApiSongFactory(ApiHandlerClient api) {
        this.api = api;
    }
    @Override
    public void create(Song song) {
        Track t = api.makeTrackRequest(song.getID());
        AudioFeatures a = api.makeAudioFeaturesRequest(song.getID());

        song.setTitle(t.getName());
        song.setArtists(t.getArtists());
        song.setPopularity(t.getPopularity());
        song.setDanceability(a.getDanceability());
        // TODO: song.setYearReleased(); needs album implementation
    }
}
