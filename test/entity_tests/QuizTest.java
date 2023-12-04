package entity_tests;

import entities.Question;
import entities.Quiz;
import entities.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {
    private Song song1;
    private Song song2;
    private Song song3;
    private Song song4;

    private ArrayList<Song> songList1;
    private ArrayList<Song> songList2;
    private Question question1;
    private Question question2;
    private ArrayList<Question> questionList;
    private Quiz quiz;


    @BeforeEach
    void init() {
        song1 = new Song("5sdQOyqq2IDhvmx2lHOpwd"); // song id for super shy by newjeans
        song2 = new Song("2D4dV2KXDTszzJ3p3cFqhA"); // song id for less than zero by the weeknd
        song3 = new Song("1Qrg8KqiBpW07V7PNxwwwL"); // song id for kill bill by sza
        song4 = new Song("7D0RhFcb3CrfPuTJ0obrod"); // song id for sparks by coldplay
        songList1 = new ArrayList<>();
        songList2 = new ArrayList<>();
        songList1.add(song1);
        songList1.add(song2);
        songList2.add(song3);
        songList2.add(song4);
        question1 = new Question(songList1);
        question2 = new Question(songList2);
        questionList = new ArrayList<>();
        questionList.add(question1);
        questionList.add(question2);
        quiz = new Quiz(2);
        quiz.setQuestions(questionList);

    }

    @Test
    void getQuestions() {assertEquals(questionList, quiz.getQuestions());}

    @Test
    void getNumQuestions() {assertEquals(2, quiz.getNumQuestions());}

}