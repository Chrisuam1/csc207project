package use_case.take_quiz.answer_question;

import entities.Player;
import entities.Question;

public class AnswerQuestionOutputData {
    final private Player player;
    final private Question nextQuestion;
    final private boolean correctlyAnswered;

    public AnswerQuestionOutputData(Player player, Question nextQuestion, boolean correctlyAnswered) {
        this.player = player;
        this.nextQuestion = nextQuestion;
        this.correctlyAnswered = correctlyAnswered;
    }

    public Player getPlayer() {
        return player;
    }

    public Question getNextQuestion() {
        return nextQuestion;
    }

    public boolean isCorrectlyAnswered() {
        return correctlyAnswered;
    }
}
