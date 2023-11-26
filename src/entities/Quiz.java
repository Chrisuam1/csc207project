package src.entities;
import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;
    private int numQuestions;

    public ArrayList<Question> getQuestions() {return questions;}

    public void setQuestions(ArrayList<Question> questionList) {
        this.questions = questionList;
    }

    public int getNumQuestions(){return numQuestions;}

    public void setNumQuestions(int NumQuestions) {
        this.numQuestions = numQuestions;
    }
}
