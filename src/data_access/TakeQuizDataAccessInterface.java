package api.src.data_access;

import api.src.entities.Song;
import java.util.ArrayList;

public interface TakeQuizDataAccessInterface {

    ArrayList<Song> getRandomSongs(int numSongs);

}
