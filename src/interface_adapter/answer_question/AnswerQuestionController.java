package interface_adapter.answer_question;

import entities.QuizTaker;
import use_case.answer_question.AnswerQuestionInputBoundary;
import use_case.answer_question.AnswerQuestionInputData;

public class AnswerQuestionController {

    final AnswerQuestionInputBoundary answerQuestionInteractor;

    public AnswerQuestionController(AnswerQuestionInputBoundary answerQuestionInteractor) {
        this.answerQuestionInteractor = answerQuestionInteractor;
    }

    public void executeCorrectAnswer(QuizTaker quizTaker, double score) {
        AnswerQuestionInputData inputData = new AnswerQuestionInputData(quizTaker, score);
        answerQuestionInteractor.executeAnsweredCorrectly(inputData);
    }

    public void executeIncorrectAnswer(QuizTaker quizTaker, double score) {
        AnswerQuestionInputData inputData = new AnswerQuestionInputData(quizTaker, score);
        answerQuestionInteractor.executeAnsweredIncorrectly(inputData);
    }
}
