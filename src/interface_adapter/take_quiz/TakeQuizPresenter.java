package interface_adapter.take_quiz;

import entities.Question;
import entities.QuizTaker;
import interface_adapter.ViewManagerModel;
import interface_adapter.answer_question.AnswerQuestionState;
import interface_adapter.answer_question.AnswerQuestionViewModel;
import use_case.take_quiz.TakeQuizOutputBoundary;
import use_case.take_quiz.TakeQuizOutputData;
import use_case.answer_question.AnswerQuestionOutputBoundary;
import use_case.answer_question.AnswerQuestionOutputData;
import view.AnswerQuestionView;

public class TakeQuizPresenter implements TakeQuizOutputBoundary {

    private final AnswerQuestionViewModel answerQuestionViewModel;
    private final ViewManagerModel viewManagerModel;

    public TakeQuizPresenter(AnswerQuestionViewModel answerQuestionViewModel, ViewManagerModel viewManagerModel) {
        this.answerQuestionViewModel = answerQuestionViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(TakeQuizOutputData takeQuizOutputData) {

        AnswerQuestionState answerQuestionState = new AnswerQuestionState();
        answerQuestionState.setQuizTaker(takeQuizOutputData.getQuizTaker());
        answerQuestionState.setScore(0.0);
        this.answerQuestionViewModel.setState(answerQuestionState);
        this.answerQuestionViewModel.firePropertyChanged();
        this.viewManagerModel.setActiveView(answerQuestionViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

//        QuizTaker quiz = takeQuizOutputData.getQuizTaker();
//
//        int i = 1;
//        while (quiz.hasMoreQuestions()) {
//
//            Question currentQuestion = quiz.popNextQuestion();
//
//            System.out.println(
//                    "Question " + i++ + ": "
//                            + "\n\t" + currentQuestion.getSong1().getPopularity() + ": " + currentQuestion.getSong1().getTitle()
//                            + "\n\t" + currentQuestion.getSong2().getPopularity() + ": " + currentQuestion.getSong2().getTitle()
//                            + "\n\t" + "Answer: " + currentQuestion.getAnswer().getTitle()
//                            + "\n\t" + "Points awarded: " + currentQuestion.getPointsAwarded()
//            );
//        }
//        System.out.println(takeQuizOutputData.getQuizTaker());
    }

    @Override
    public void prepareFailView(String error) {

    }
}
