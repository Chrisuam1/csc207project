package use_case.take_quiz;

import entities.Question;
import entities.Quiz;
import entities.QuizTaker;
import entities.Song;

import java.util.ArrayList;

public class TakeQuizOutputData {
    private QuizTaker quizTaker;

    public TakeQuizOutputData(QuizTaker quizTaker) {
        this.quizTaker = quizTaker;
    }

    public TakeQuizOutputData(ArrayList<Song> songs) {
        Quiz quiz = new Quiz();
        for (int i = 0; i < songs.size() - 1; i += 2) {
            quiz.addQuestion(new Question(songs.get(i), songs.get(i + 1)));
        }
        quizTaker = new QuizTaker(quiz);
    }

    public QuizTaker getQuizTaker() {
        return quizTaker;
    }
}
