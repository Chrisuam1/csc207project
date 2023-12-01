package src.entities.factories;

import src.entities.Song;

public interface SongFactory {
    Song create(String id);
}
