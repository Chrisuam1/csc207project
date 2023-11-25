package api.src.data_access;

import api.src.entities.Song;
import java.io.File;
import java.util.ArrayList;

/**
 * creates song objects from a csv file
 */
public class FileSongDataAccessObject implements TakeQuizDataAccessInterface {

    private final File csvFile;

    private final ArrayList<Song> songs;

    /**
     * @param numSongs number of Songs we want
     * @return an Arraylist of randomly chosen Songs
     */
    @Override
    public ArrayList<Song> getRandomSongs(int numSongs) {
        return null;
    }
}
