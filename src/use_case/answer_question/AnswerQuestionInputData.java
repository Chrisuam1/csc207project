package use_case.answer_question;

import entities.Player;
import entities.Question;
import entities.QuizTaker;

public class AnswerQuestionInputData {
    final private QuizTaker quiz;
    final private double score;

    public AnswerQuestionInputData(QuizTaker quiz, double scoreAwarded) {
        this.quiz = quiz;
        this.score = scoreAwarded;
    }

    public QuizTaker getQuiz() {
        return quiz;
    }

    public double getScore() {
        return score;
    }
}
