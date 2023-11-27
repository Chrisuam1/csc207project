package use_case.take_quiz;
import entities.Song;

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
public class TakeQuizInteractor implements TakeQuizInputBoundary{

    public void execute(TakeQuizInputData inputData) {

    }

    public ArrayList<Song> generateRandomSongs(){
        ArrayList<Song> songList = new ArrayList<Song>();

        // Creating a Random object
        Random rand = new Random();

        // Creating an empty ArrayList to store 2 random songs
        ArrayList<Song> finalSongs = new ArrayList<Song>();

        // Getting a random list index 1 and 2
        int ranIndex1 = rand.nextInt(songList.size());
        int ranIndex2 = rand.nextInt(songList.size());
        // If indexes are equal, we choose a new random index
        while(ranIndex1 == ranIndex2){
            ranIndex2 = rand.nextInt(songList.size());
            }
        Song ranSong1 = songList.get(ranIndex1);
        Song ranSong2 = songList.get(ranIndex2);

        finalSongs.add(ranSong1);
        finalSongs.add(ranSong2);

        return finalSongs;
    }
}
