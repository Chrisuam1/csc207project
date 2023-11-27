package use_case.take_quiz;

import entities.Player;
import entities.Quiz;

public class TakeQuizInputData {
    final private Player player;
    final private Quiz quiz;

    public TakeQuizInputData(Player p, Quiz q) {
        this.player = p;
        this.quiz = q;
    }

    public Player getPlayer() {
        return player;
    }

    public Quiz getQuiz() {
        return quiz;
    }
}
