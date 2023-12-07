package use_case.take_quiz.answer_question;

import entities.Player;
import entities.Question;

public class AnswerQuestionInputData {
    final private Player player;
    final private Question question;

    public AnswerQuestionInputData(Player player, Question question) {
        this.player = player;
        this.question = question;
    }

    public Player getPlayer() {
        return player;
    }

    public Question getQuestion() {
        return question;
    }
}
