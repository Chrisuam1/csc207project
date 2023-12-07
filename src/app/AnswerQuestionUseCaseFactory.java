package app;

import interface_adapter.AnswerQuestionViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.answer_question.AnswerQuestionController;
import interface_adapter.answer_question.AnswerQuestionPresenter;
import use_case.answer_question.AnswerQuestionInputBoundary;
import use_case.answer_question.AnswerQuestionInteractor;
import use_case.answer_question.AnswerQuestionOutputBoundary;
import view.AnswerQuestionView;


public class AnswerQuestionUseCaseFactory {

    private AnswerQuestionUseCaseFactory() {}

    public static AnswerQuestionView create(ViewManagerModel viewManagerModel, AnswerQuestionViewModel answerQuestionViewModel) {
        AnswerQuestionController answerQuestionController = createAnswerQuestionUseCase(viewManagerModel,answerQuestionViewModel);
        return new AnswerQuestionView(answerQuestionController, answerQuestionViewModel);
    }

    private static AnswerQuestionController createAnswerQuestionUseCase(ViewManagerModel viewManagerModel, AnswerQuestionViewModel answerQuestionViewModel) {
        AnswerQuestionOutputBoundary answerQuestionOutputBoundary = new AnswerQuestionPresenter(viewManagerModel, answerQuestionViewModel);
        AnswerQuestionInputBoundary answerQuestionInteractor = new AnswerQuestionInteractor(answerQuestionOutputBoundary);
        return new AnswerQuestionController(answerQuestionInteractor);
    }
}
