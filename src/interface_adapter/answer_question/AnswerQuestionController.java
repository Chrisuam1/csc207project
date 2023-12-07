package interface_adapter.answer_question;

import use_case.answer_question.AnswerQuestionInputBoundary;

public class AnswerQuestionController {

    final AnswerQuestionInputBoundary answerQuestionInteractor;

    public AnswerQuestionController(AnswerQuestionInputBoundary answerQuestionInteractor) {
        this.answerQuestionInteractor = answerQuestionInteractor;
    }

    public void execute() {

    }
}
