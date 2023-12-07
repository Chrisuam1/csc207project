package interface_adapter.answer_question;

import interface_adapter.ViewManagerModel;
import use_case.answer_question.AnswerQuestionInputBoundary;
import use_case.answer_question.AnswerQuestionInputData;
import use_case.answer_question.AnswerQuestionOutputBoundary;
import use_case.answer_question.AnswerQuestionOutputData;

public class AnswerQuestionPresenter implements AnswerQuestionOutputBoundary {

    private ViewManagerModel viewManagerModel;
    private final AnswerQuestionViewModel answerQuestionViewModel;

    public AnswerQuestionPresenter(ViewManagerModel viewManagerModel, AnswerQuestionViewModel answerQuestionViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.answerQuestionViewModel = answerQuestionViewModel;
    }

    @Override
    public void prepareCorrectAnswerView(AnswerQuestionInputBoundary answerQuestionInputBoundary) {

    }

    @Override
    public void prepareWrongAnswerView(AnswerQuestionInputBoundary answerQuestionInputBoundary) {

    }

    @Override
    public void prepareNextQuestionView(AnswerQuestionInputData answerQuestionInputData) {

    }

    @Override
    public void prepareQuizEndView(AnswerQuestionOutputData answerQuestionOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
