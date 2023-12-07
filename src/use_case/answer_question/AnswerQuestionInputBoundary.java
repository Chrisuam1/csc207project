package use_case.answer_question;

public interface AnswerQuestionInputBoundary {

    void executeAnsweredCorrectly(AnswerQuestionInputData answerQuestionInputData);
    void executeAnsweredIncorrectly(AnswerQuestionInputData answerQuestionInputData);
}
