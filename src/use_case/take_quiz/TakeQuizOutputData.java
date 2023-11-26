package src.use_case.take_quiz;

public class TakeQuizOutputData {
    final private int score;
    final private int numQuestions;

    public TakeQuizOutputData(int score, int numQuestions) {
        this.score = score;
        this.numQuestions = numQuestions;
    }

    public int getScore() {
        return score;
    }

    public int getNumQuestions() {
        return numQuestions;
    }
}
