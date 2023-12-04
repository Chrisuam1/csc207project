package use_case.take_quiz.answer_question;

import use_case.take_quiz.TakeQuizOutputData;

public interface AnswerQuestionOutputBoundary {

    void prepareNextQuestionView (AnswerQuestionOutputData answerQuestionOutputData);
    void prepareQuizEndView (TakeQuizOutputData takeQuizOutputData);

    void prepareFailView(String error);
}
