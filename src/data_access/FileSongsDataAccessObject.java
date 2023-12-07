package data_access;

import entities.Song;
import entities.factories.SongFactory;
import use_case.take_quiz.TakeQuizDataAccessInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class FileSongsDataAccessObject implements TakeQuizDataAccessInterface {

    private final File csvFile;
    private ArrayList<Song> songList;
    private SongFactory songFactory;

    public FileSongsDataAccessObject(String csvPath, SongFactory songFactory) throws IOException {
        this.csvFile = new File(csvPath);
        this.songList = new ArrayList<>();
        this.songFactory = songFactory;
    }

    // populates the database using the songs ids
    public void init() {

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String row;

            int i = 1; // TODO: debugger counter, can be deleted
            while ((row = reader.readLine()) != null) {

                String id;

                // no comma found, at the last item
                if (row.indexOf(',') == -1) {
                    id = row;
                }

                // comma found, more items
                else {
                    id = row.substring(0, row.indexOf(','));
                }

                songList.add(songFactory.create(id));


                // TODO: debugger line, can be deleted
                System.out.println(Integer.toString(i++) + ". SongID: " + id + " successfully added to database");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public SongFactory getSongFactory() {
        return songFactory;
    }

    /**
     * Useful for checking how many songs the client can request.
     * @return the number of songs in the database
     */
    public int getSongListSize() {
        return songList.size();
    }

    /**
     * Returns a Song arrayList of size numSongs.
     * Note that API limit might be exceeded if too many songs are requested.
     * @param numSongs
     * @return
     * @throws Exception when numSongs is greater than the number of songs in the database songList.
     */
    @Override
    public ArrayList<Song> getRandomSongs(int numSongs) throws Exception{
        if (numSongs > songList.size()) {
            throw new Exception("Error: number of songs requested exceeds number of songs in database!");
        }
        else {
            ArrayList<Song> songPool = new ArrayList<>(songList);
            ArrayList<Song> randomSongs = new ArrayList<>();

            for (int i = 0; i < numSongs; i++) {
                // pick a random index from songPool
                int index = new Random().nextInt(songPool.size());

                // add the song to return list
                randomSongs.add(songPool.get(index));

                // remove the song from the pool
                songPool.remove(index);
            }

            return randomSongs;
        }
    }

    @Override
    public int getNumSongs() {
        return songList.size();
    }
}
