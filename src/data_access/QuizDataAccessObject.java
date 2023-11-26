package src.data_access;
import src.entities.Song;
import src.entities.factories.SongFactory;

import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.Random;
import java.io.IOException;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class QuestionDataAccessObject {
    public ArrayList<Song> songList;
    public void readCSV(String[] args) throws Exception{

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
                Song song = new Song(currLine);
                SongFactory.create(song); // SOMEHOW FIX?
                songList.add(song);

                // Reading next line
                currLine = br.readLine();
            }
            // Assigning the instance variable to new list of Songs
            this.songList = songList;
        }
    }
    public ArrayList<Song> generateRandomSongs(){
       // Creating a Random object
        Random rand = new Random();

        // Creating an empty ArrayList to store 2 random songs
        ArrayList<Song> finalSongs = new ArrayList<Song>();

        // Getting a random list index 1 and 2
        int ranIndex1 = rand.nextInt(this.songList.size());
        int ranIndex2 = rand.nextInt(this.songList.size());
        // If indexes are equal, we choose a new random index
        while(ranIndex1 == ranIndex2){
            ranIndex2 = rand.nextInt(this.songList.size());
            }
        Song ranSong1 = this.songList.get(ranIndex1);
        Song ranSong2 = this.songList.get(ranIndex2);

        finalSongs.add(ranSong1);
        finalSongs.add(ranSong2);
    return finalSongs;
    }

}
