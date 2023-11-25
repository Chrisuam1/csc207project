package src.entities.factories;

import src.entities.Album;

public interface AlbumFactory {
    Album create(String id);
}
