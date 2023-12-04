package entities;
import java.util.ArrayList;

public class Quiz {
    private ArrayList<Question> questions;
    private int numQuestions;
    private double totalPoints;

    public Quiz() {
        questions = new ArrayList<>();
        numQuestions = 0;
        totalPoints = 0.0;
    }

    public Quiz(ArrayList<Question> questions) {
        this(); // calling the default constructor
        this.addQuestionList(questions);
    }

    public void addQuestion(Question question) {
        questions.add(question);
        numQuestions += 1;
        totalPoints += question.getPointsAwarded();
    }

    public void addQuestionList(ArrayList<Question> questionList) {
        questions.addAll(questionList);
        numQuestions += questionList.size();
        for (Question q : questionList) {
            totalPoints += q.getPointsAwarded();
        }
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public double getTotalPoints() {
        return totalPoints;
    }
}
