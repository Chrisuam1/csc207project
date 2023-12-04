package interface_adapter.take_quiz;

import use_case.take_quiz.TakeQuizOutputBoundary;
import use_case.take_quiz.TakeQuizOutputData;
import use_case.take_quiz.answer_question.AnswerQuestionOutputBoundary;
import use_case.take_quiz.answer_question.AnswerQuestionOutputData;

public class TakeQuizPresenter implements TakeQuizOutputBoundary, AnswerQuestionOutputBoundary {

    @Override
    public void prepareSuccessView(TakeQuizOutputData takeQuizOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }

    @Override
    public void prepareNextQuestionView(AnswerQuestionOutputData answerQuestionOutputData) {

    }

    @Override
    public void prepareQuizEndView(TakeQuizOutputData takeQuizOutputData) {

    }
}
