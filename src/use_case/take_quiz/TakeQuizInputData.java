package use_case.take_quiz;

import entities.Player;
import entities.Quiz;

public class TakeQuizInputData {
    final private Player player;
    final private int numQuestions;

    public TakeQuizInputData(Player p, Quiz q, int numQuestions) {
        this.player = p;
        this.numQuestions = numQuestions;
    }

    public Player getPlayer() {
        return player;
    }

    public int getNumQuestions() {
        return numQuestions;
    }
}
