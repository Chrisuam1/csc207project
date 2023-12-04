package test;


import org.junit.Test;
import entities.Player;
import entities.Question;
import entities.Quiz;
import entities.Song;
import use_case.take_quiz.TakeQuizInputData;

import java.util.ArrayList;
import java.util.Arrays;

public class TakeQuizInteractorTest {

    @Test
    public void TakeQuizInteractor() {

        Song song1 = new Song(
                "a",
                "titleA",
                new ArrayList<>(Arrays.asList("Amanda","Alan")),
                0.1,
                0.1,
                null,
                "2001");

        Song song2 = new Song(
                "b",
                "titleB",
                new ArrayList<>(Arrays.asList("Bart","Bertha")),
                0.2,
                0.3,
                null,
                "2011");

        Song song3 = new Song(
                "c",
                "titleC",
                new ArrayList<>(Arrays.asList("Claire","Chris")),
                0.3,
                0.1,
                null,
                "2021");

        Question question1 = new Question(song1, song2);
        Question question2 = new Question(song2, song3);
        Question question3 = new Question(song3, song1);

        ArrayList<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));

        Player player = new Player("Joe Hisashi");
        Quiz quiz = new Quiz(questions);

        int NUM_SONGS = 10;
        TakeQuizInputData inputData = new TakeQuizInputData(player, quiz, NUM_SONGS);
    }

}
