package use_case.take_quiz;

import entities.Player;
import entities.Quiz;

public class TakeQuizInputData {
    final private Player player;
    final private Quiz quiz;
    final private int numQuestions;

    public TakeQuizInputData(Player p, Quiz q, int numQuestions) {
        this.player = p;
        this.quiz = q;
        this.numQuestions = numQuestions;
    }

    public Player getPlayer() {
        return player;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public int getNumQuestions() {
        return numQuestions;
    }
}
