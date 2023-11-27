package entities;
import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;
    private int numQuestions;

    public Quiz() {
        questions = new ArrayList<>();
        numQuestions = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
        numQuestions += 1;
    }

    public void addQuestionList(ArrayList<Question> questionList) {
        questions.addAll(questionList);
        numQuestions += questionList.size();
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getNumQuestions() {
        return numQuestions;
    }
}
