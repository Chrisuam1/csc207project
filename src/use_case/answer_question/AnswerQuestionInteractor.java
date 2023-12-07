package use_case.answer_question;

public class AnswerQuestionInteractor implements AnswerQuestionInputBoundary{

    private final AnswerQuestionOutputBoundary answerQuestionPresenter;

    public AnswerQuestionInteractor(AnswerQuestionOutputBoundary answerQuestionPresenter) {
        this.answerQuestionPresenter = answerQuestionPresenter;
    }

    @Override
    public void execute(AnswerQuestionInputData answerQuestionInputData) {

    }
}
