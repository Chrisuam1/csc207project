package data_access;

import entities.Song;
import use_case.take_quiz.TakeQuizDataAccessInterface;

import java.io.File;
import java.util.ArrayList;

public class FileSongsDataAccessObject implements TakeQuizDataAccessInterface {

    private final File csvFile;
    private ArrayList<Song> songList;

    public FileSongsDataAccessObject(File csvFile) {
        this.csvFile = csvFile;
        this.songList = new ArrayList<>();
    }



    @Override
    public ArrayList<Song> getRandomSongs(int numSongs) {
        return null;
    }
}
