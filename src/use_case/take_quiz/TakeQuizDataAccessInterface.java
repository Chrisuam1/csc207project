package use_case.take_quiz;

import entities.Song;
import java.util.ArrayList;

public interface TakeQuizDataAccessInterface {

    ArrayList<Song> getRandomSongs(int numSongs) throws Exception;
    int getNumSongs();  // get the number of songs in the database
}
