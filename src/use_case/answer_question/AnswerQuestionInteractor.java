package use_case.answer_question;

public class AnswerQuestionInteractor implements AnswerQuestionInputBoundary{

    private final AnswerQuestionOutputBoundary answerQuestionPresenter;

    public AnswerQuestionInteractor(AnswerQuestionOutputBoundary answerQuestionPresenter) {
        this.answerQuestionPresenter = answerQuestionPresenter;
    }

    @Override
    public void executeAnsweredCorrectly(AnswerQuestionInputData answerQuestionInputData) {
        if (answerQuestionInputData.getQuiz().hasMoreQuestions()) {
            answerQuestionPresenter.prepareCorrectAnswerView(answerQuestionInputData);
        } else {
            AnswerQuestionOutputData outputData = new AnswerQuestionOutputData(answerQuestionInputData.getScore());
            answerQuestionPresenter.prepareQuizEndView(outputData);
        }
    }

    @Override
    public void executeAnsweredIncorrectly(AnswerQuestionInputData answerQuestionInputData) {
        if (answerQuestionInputData.getQuiz().hasMoreQuestions()) {
            answerQuestionPresenter.prepareWrongAnswerView(answerQuestionInputData);
        } else {
            AnswerQuestionOutputData outputData = new AnswerQuestionOutputData(0.0);
            answerQuestionPresenter.prepareQuizEndView(outputData);
        }
    }
}
