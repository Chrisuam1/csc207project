package use_case.answer_question;

import entities.Player;
import entities.Question;
import entities.QuizTaker;

public class AnswerQuestionInputData {
    final private QuizTaker quiz;

    public AnswerQuestionInputData(QuizTaker quiz) {
        this.quiz = quiz;
    }

    public QuizTaker getQuiz() {
        return quiz;
    }
}
