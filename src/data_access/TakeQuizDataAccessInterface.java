package data_access;

import entities.Song;
import java.util.ArrayList;

public interface TakeQuizDataAccessInterface {

    ArrayList<Song> getTwoRandomSongs();

}
