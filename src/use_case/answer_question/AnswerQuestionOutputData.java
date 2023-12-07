package use_case.answer_question;

import entities.Player;
import entities.Question;

public class AnswerQuestionOutputData {
    final private double score;

    public AnswerQuestionOutputData(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}
