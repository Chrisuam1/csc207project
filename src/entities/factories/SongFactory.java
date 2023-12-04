package entities.factories;

import entities.Song;

public interface SongFactory {
    Song create(String id);
}
