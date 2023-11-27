package src.data_access;

import src.entities.Song;
import java.util.ArrayList;

public interface TakeQuizDataAccessInterface {

    ArrayList<Song> getTwoRandomSongs();

}
