package interface_adapter.answer_question;

import interface_adapter.ViewManagerModel;
import use_case.answer_question.AnswerQuestionInputBoundary;
import use_case.answer_question.AnswerQuestionInputData;
import use_case.answer_question.AnswerQuestionOutputBoundary;
import use_case.answer_question.AnswerQuestionOutputData;
import view.ResultsView;

public class AnswerQuestionPresenter implements AnswerQuestionOutputBoundary {

    private ViewManagerModel viewManagerModel;
    private final AnswerQuestionViewModel answerQuestionViewModel;
    private final ResultsView resultsView;

    public AnswerQuestionPresenter(ViewManagerModel viewManagerModel, AnswerQuestionViewModel answerQuestionViewModel, ResultsView resultsView) {
        this.viewManagerModel = viewManagerModel;
        this.answerQuestionViewModel = answerQuestionViewModel;
        this.resultsView = resultsView;
    }

    @Override
    public void prepareCorrectAnswerView(AnswerQuestionInputData answerQuestionInputData) {
        AnswerQuestionState state = answerQuestionViewModel.getState();
        double currentScore = state.getScore();
        state.setScore(currentScore + answerQuestionInputData.getScore());
        answerQuestionInputData.getQuiz().popNextQuestion();
        state.setQuizTaker(answerQuestionInputData.getQuiz());
        answerQuestionViewModel.setState(state);
        answerQuestionViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(answerQuestionViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareWrongAnswerView(AnswerQuestionInputData answerQuestionInputData) {
        AnswerQuestionState state = answerQuestionViewModel.getState();
        answerQuestionInputData.getQuiz().popNextQuestion();
        // Change everything else but the score
        state.setQuizTaker(answerQuestionInputData.getQuiz());
        answerQuestionViewModel.setState(state);
        answerQuestionViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(answerQuestionViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareNextQuestionView(AnswerQuestionInputData answerQuestionInputData) {

    }

    @Override
    public void prepareQuizEndView(AnswerQuestionOutputData outputData) {
        AnswerQuestionState state = answerQuestionViewModel.getState();
        state.setScore(state.getScore() + outputData.getScore());
        resultsView.updateFields();
        viewManagerModel.setActiveView(resultsView.viewName);
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}
