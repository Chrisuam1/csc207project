package use_case.take_quiz;

import entities.Player;
import entities.Quiz;

public class TakeQuizInputData {
    // final private Player;
    final private int numQuestions;

    public TakeQuizInputData(int numQuestions) {
        // this.player = p;
        this.numQuestions = numQuestions;
    }

//    public Player getPlayer() {
//        return player;
//    }

    public int getNumQuestions() {
        return numQuestions;
    }
}
