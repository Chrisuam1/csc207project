package app;

import api.ApiHandlerClient;
import data_access.FileSongsDataAccessObject;
import entities.Question;
import entities.Quiz;
import entities.Song;
import entities.factories.SpotifyApiSongFactory;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String id = "";
        String secret = "";
        ApiHandlerClient api = new ApiHandlerClient(id, secret);
        api.authenticate();

        try {

            // should create a new database using the csv file "topSongs.csv"
            FileSongsDataAccessObject dao = new FileSongsDataAccessObject("topSongs.csv", new SpotifyApiSongFactory(api));

            // dao.songlist should only have 10 songs in it
            System.out.println("Number of songs in database: " + Integer.toString(dao.getSongListSize()));

            // get 4 random songs from db, so we can create a quiz with 2 questions
            ArrayList<Song> randomSongs = dao.getRandomSongs(4);

            // TODO: ensure that these songs do not have equal popularity
            Question q1 = new Question(randomSongs.get(0), randomSongs.get(1));
            Question q2 = new Question(randomSongs.get(2), randomSongs.get(3));

            Quiz testQuiz = new Quiz();
            testQuiz.addQuestion(q1);
            testQuiz.addQuestion(q2);

            for (Question q : testQuiz.getQuestions()) {
                System.out.println("Which is more popular: ");
                System.out.println("\t" + q.getSong1().getTitle() + " or " + q.getSong2().getTitle());
                System.out.println("\t" + q.getSong1().getTitle() + ": " + (q.getSong1().getPopularity()));
                System.out.println("\t" + q.getSong2().getTitle() + ": " + (q.getSong2().getPopularity()));
                System.out.println("\tThe correct answer is: " + q.getAnswer().getTitle());
                System.out.println("\tPoints awarded: " + q.getPointsAwarded());
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
