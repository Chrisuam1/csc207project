package src.entities;
import java.util.ArrayList;

public class Quiz {
    private int quizType;
    private ArrayList<Question> questions;
    private int numQuestions;

    public int getQuizType() {return quizType;}

    public void setQuizType(int quizType){
        this.quizType = quizType;
    }

    public ArrayList<Question> getQuestions() {return questions;}

    public int getNumQuestions(){return numQuestions;}

    public void setNumQuestions(int NumQuestions) {
        this.numQuestions = numQuestions;
    }

    // setter for questions
    public void generateQuestions(Question question) {
        int i = 0;
        while (i <= numQuestions) {
            // TODO: implement setQuestion
            //question.setQuestion();
            i++;
        }
    }
}
