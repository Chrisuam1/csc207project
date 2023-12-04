package entity_tests;

import entities.Question;
import entities.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    private Song song1;

    private Song song2;
    private ArrayList<Song> songList;
    private Question question;

    @BeforeEach
    void init() {
        song1 = new Song("5sdQOyqq2IDhvmx2lHOpwd"); // song id for super shy by newjeans
        song2 = new Song("2D4dV2KXDTszzJ3p3cFqhA"); // song id for less than zero by the weeknd
        songList = new ArrayList<>();
        songList.add(song1);
        songList.add(song2);
        question = new Question(songList);
    }

    @Test
    void getAnswer() {assertEquals(song1, question.getAnswer());}
    @Test
    void getSong1() {assertEquals(song1, question.getSong1());}
    @Test
    void getSong2() {assertEquals(song2, question.getSong2());}

    // super shy popularity is 90, less than zero popularity is 78. (1/(90-78))*1000 = 250/3 = 83.3333333...
    @Test
    void getPointsAwarded() {assertEquals(83.33, question.getPointsAwarded());}





}