package use_case.take_quiz;

public interface TakeQuizOutputBoundary {
    void prepareSuccessView(TakeQuizOutputData takeQuizOutputData);

    void prepareFailView(String error);
}
