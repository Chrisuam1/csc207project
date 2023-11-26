package src.use_case.take_quiz;
import src.entities.Question;
import src.entities.Quiz;
import src.entities.Song;
import src.entities.factories.SongFactory;
import src.data_access.QuizDataAccessObject; // OR CHANGE TO THE DAO INTERFACE!

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
public class TakeQuizInteractor{

    // STEP 1: Create a SongFactory object to use in DAO
    // IMPORTANT NOTE: FIX THIS!!
    SongFactory songFactory = new SongFactory(); // FIX!!!

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // STEP 2: Use DAO to create Masterlist of Songs from DAO
    QuizDataAccessObject quizDao = new QuizDataAccessObject(songFactory);

    // IMPORTANT NOTE: below code "try/catch", etc. is to handle the case where Quiz.readcsv throws an exception
    {
        try {
            quizDao.readCSV();  // Setting quizDao.songlist attribute to be the masterlist
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }// Setting quiz's songlist attribute using csv
    ArrayList<Song> masterlist = quizDao.getSongList();

    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    // STEP 3: Create Quiz Object
    Quiz quiz = new Quiz();
    // IMPORTANT NOTE: Below quiz.setNumQuestions method doesn't work unless...
    // you put {} around it, it's because it returns void.
    // Find a way to set limit of input to be <= 50.
    {quiz.setNumQuestions(50);}

    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    // STEP 4: Helper method for GENERATING 2 RANDOM SONGS FROM MASTERLIST
    public ArrayList<Song> generate2RandomSongs(){
       // Creating a Random object
        Random rand = new Random();

        // Creating an empty ArrayList to store 2 random songs
        ArrayList<Song> finalSongs = new ArrayList<Song>();

        // Getting a random list index 1 and 2
        int size = masterlist.size();
        int ranIndex1 = rand.nextInt(size);
        int ranIndex2 = rand.nextInt(size);

        Song ranSong1 = masterlist.get(ranIndex1);
        Song ranSong2 = masterlist.get(ranIndex2);

        // If indexes are equal OR songs have same popularity, we choose a new random index/song
        while((ranIndex1 == ranIndex2) || (ranSong1.getPopularity() == ranSong2.getPopularity())){
            ranIndex2 = rand.nextInt(masterlist.size());
            }

        Song finalRanSong2 = masterlist.get(ranIndex2);

        // Storing both songs in empty ArrayList
        finalSongs.add(ranSong1);
        finalSongs.add(finalRanSong2);
    return finalSongs;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // STEP 5: Generate all questions and store in Quiz.questions attribute
    public void generateAllQuestions(){
        int i = 0;
        ArrayList<Question> questionList = new ArrayList<Question>();
        // Loop through as many times as num_questions
        while (i <= quiz.getNumQuestions()) {
            // Create a Question object
            Question question = new Question();
            // Generating 2 random songs and setting those as Question.song1 and Question.song2 attributes
            question.setSongs(this.generate2RandomSongs());
            // Setting Question attributes Question.pointsAwarded and Question.answer
            question.setAnswer();
            question.setPointsAwarded();
            // Adding Question object to ArrayList
            questionList.add(question);
            i++;
        }
        // Storing list of ALL QUESTIONS in Quiz object
        quiz.setQuestions(questionList);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    // STEP 6: CONTINUE...
}
