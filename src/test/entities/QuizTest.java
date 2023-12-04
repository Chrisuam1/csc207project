package test.entities;

import entities.Question;
import entities.Quiz;
import entities.Song;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class QuizTest {
    private Song song1;
    private Song song2;
    private Song song3;
    private Song song4;
    private Question question1;
    private Question question2;
    private ArrayList<Question> questionList;
    private Quiz quiz;


    @Before
    public void init() {
        song1 = new Song(
                "a",
                "titleA",
                new ArrayList<>(Arrays.asList("Amanda","Alan")),
                50,
                0.5,
                null,
                "2001");

        song2 = new Song(
                "b",
                "titleB",
                new ArrayList<>(Arrays.asList("Bart","Bertha")),
                55,
                0.6,
                null,
                "2011");
        song3 = new Song(
                "c",
                "titleC",
                new ArrayList<>(Arrays.asList("Carl","Chris")),
                90,
                0.8,
                null,
                "1991");

        song4 = new Song(
                "d",
                "titleD",
                new ArrayList<>(Arrays.asList("Dave","Diana")),
                30,
                0.4,
                null,
                "2020");
        question1 = new Question(song1, song2);
        question2 = new Question(song3, song4);
        questionList = new ArrayList<>();
        questionList.add(question1);
        questionList.add(question2);
        quiz = new Quiz();
        quiz.addQuestionList(questionList);

    }

    @Test
    public void getQuestions() {assertEquals(questionList, quiz.getQuestions());}

    @Test
    public void getNumQuestions() {assertEquals(2, quiz.getNumQuestions());}

    @Test
    public void getTotalPoints() {assertEquals(216.66, quiz.getTotalPoints(),0.01);}

}