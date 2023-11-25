package src.entities.factories;

import src.api.ApiHandlerClient;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.AudioFeatures;
import se.michaelthelin.spotify.model_objects.specification.Track;
import src.entities.Song;
import src.entities.factories.SongFactory;
import src.entities.factories.SpotifyApiAlbumFactory;

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
                new SpotifyApiAlbumFactory(api).create(t.getAlbum().getId()));
        song.setYearReleased(song.getAlbum().getYearReleased());

        for (ArtistSimplified i : t.getArtists()) {
            song.getArtists().add(i.getName());
        }
        return song;
    }
}
