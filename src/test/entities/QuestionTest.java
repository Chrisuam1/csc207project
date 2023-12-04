package test.entities;

import entities.Question;
import entities.Song;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class QuestionTest {

    private Song song1;

    private Song song2;
    private ArrayList<Song> songList;
    private Question question;

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
        question = new Question(song1, song2);
    }

    @Test
    public void getAnswer() {assertEquals(song2, question.getAnswer());}
    @Test
    public void getSong1() {assertEquals(song1, question.getSong1());}
    @Test
    public void getSong2() {assertEquals(song2, question.getSong2());}

    // song1 popularity is 50, song2 popularity is 55. |(1/(50-55))*1000| = 200
    @Test
    public void getPointsAwarded() {assertEquals(200, question.getPointsAwarded(), 0);}





}