package use_case.answer_question;

import use_case.take_quiz.TakeQuizOutputData;

public interface AnswerQuestionOutputBoundary {

    void prepareCorrectAnswerView(AnswerQuestionInputBoundary answerQuestionInputBoundary);
    void prepareWrongAnswerView(AnswerQuestionInputBoundary answerQuestionInputBoundary);
    void prepareNextQuestionView (AnswerQuestionInputData answerQuestionInputData);
    void prepareQuizEndView (AnswerQuestionOutputData answerQuestionOutputData);
    void prepareFailView(String error);
}
