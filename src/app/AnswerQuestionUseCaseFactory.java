package app;

import interface_adapter.answer_question.AnswerQuestionViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.answer_question.AnswerQuestionController;
import interface_adapter.answer_question.AnswerQuestionPresenter;
import use_case.answer_question.AnswerQuestionInputBoundary;
import use_case.answer_question.AnswerQuestionInteractor;
import use_case.answer_question.AnswerQuestionOutputBoundary;
import view.AnswerQuestionView;
import view.ResultsView;

import javax.xml.transform.Result;


public class AnswerQuestionUseCaseFactory {

    private AnswerQuestionUseCaseFactory() {}

    public static AnswerQuestionView create(ViewManagerModel viewManagerModel, AnswerQuestionViewModel answerQuestionViewModel, ResultsView resultsView) {
        AnswerQuestionController answerQuestionController = createAnswerQuestionUseCase(viewManagerModel,answerQuestionViewModel, resultsView);
        return new AnswerQuestionView(answerQuestionController, answerQuestionViewModel);
    }

    private static AnswerQuestionController createAnswerQuestionUseCase(ViewManagerModel viewManagerModel, AnswerQuestionViewModel answerQuestionViewModel, ResultsView resultsView) {
        AnswerQuestionOutputBoundary answerQuestionOutputBoundary = new AnswerQuestionPresenter(viewManagerModel, answerQuestionViewModel, resultsView);
        AnswerQuestionInputBoundary answerQuestionInteractor = new AnswerQuestionInteractor(answerQuestionOutputBoundary);
        return new AnswerQuestionController(answerQuestionInteractor);
    }
}
