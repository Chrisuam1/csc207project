package entities;

import java.util.LinkedList;

/**
 * A class that goes through a Quiz until all the Questions have been accessed.
 */
public class QuizTaker {
    private final Quiz quiz;
    private LinkedList<Question> questions;

    public QuizTaker(Quiz quiz) {
        this.quiz = quiz;

        // make a copy of the questions in quiz
        // we will remove questions from this arraylist as questions are answered
        questions = new LinkedList<>();
        questions.addAll(quiz.getQuestions());
    }

    public boolean hasMoreQuestions() {
        return !questions.isEmpty();
    }

    public Question getNextQuestion() {
        return questions.pop();
    }
}
