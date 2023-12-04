package data_access;
import entities.Song;
import src.entities.factories.SongFactory;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Random;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class QuizDataAccessObject {
    private ArrayList<Song> songList;
    private SongFactory factory;

    public QuizDataAccessObject(SongFactory factory) {this.factory = factory;}

    public void readCSV() throws IOException {

        // Creating an ArrayList to store id's
        ArrayList<Song> songList = new ArrayList<Song>();

        // Getting path to csv
        Path pathToFile = Paths.get("/top100id"); // FIX FILE NAME

        // Using imported BufferedReader class to read csv, is faster than Scanner
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            // Reading the first line
            String currLine = br.readLine();

            // Looping through all lines of csv until there are none left
            while (currLine != null) {
                songList.add(factory.create(currLine));
                // Reading next line
                currLine = br.readLine();
            }
            // Assigning the instance variable to new list of Songs
            this.songList = songList;
        }
    }
    public ArrayList<Song> getSongList(){
        return this.songList;
    }
}