package entities;
import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;
    private int numQuestions;

    public Quiz(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questionList) {
        this.questions = questionList;
    }

    public int getNumQuestions() {
        return numQuestions;
    }
}
