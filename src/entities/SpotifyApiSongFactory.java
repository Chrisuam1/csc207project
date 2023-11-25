package api.src.entities;

import api.src.api.ApiHandlerClient;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.AudioFeatures;
import se.michaelthelin.spotify.model_objects.specification.Track;

public class SpotifyApiSongFactory implements SongFactory {
    ApiHandlerClient api;

    public SpotifyApiSongFactory(ApiHandlerClient api) {
        this.api = api;
    }
    @Override
    public Song create(String id) {
        Song song = new Song(id);
        Track t = api.makeTrackRequest(song.getID());
        AudioFeatures a = api.makeAudioFeaturesRequest(song.getID());

        song.setTitle(t.getName());
        song.setPopularity(t.getPopularity());
        song.setDanceability(a.getDanceability());
        song.setAlbum(
                new Album(t.getAlbum().getId(), new SpotifyApiAlbumFactory(api)));
        song.setYearReleased(song.getAlbum().getYearReleased());

        for (ArtistSimplified i : t.getArtists()) {
            song.getArtists().add(i.getName());
        }
        return song;
    }
}
