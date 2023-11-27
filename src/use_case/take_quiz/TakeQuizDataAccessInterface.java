package use_case.take_quiz;

import entities.Song;
import java.util.ArrayList;

public interface TakeQuizDataAccessInterface {

    ArrayList<Song> getTwoRandomSongs();

}
