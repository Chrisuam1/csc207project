import data_access.QuizDataAccessObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.take_quiz.TakeQuizInputBoundary;

class TakeQuizInteractorTest {
    @Test
    void SuccessTest() {
        TakeQuizInputData inputData = new TakeQuizInputData();
        TakeQuizDataAccessInterface quizRepository = new QuizDataAccessObject();

        TakeQuizOutputBoundary successPresenter = new TakeQuizOutputBoundary() {
            public void prepareSuccessView(TakeQuizOutputData quiz) {
                // check desired objects from output data were outputted correctly
            }

            public void prepareFailView(String error) {
                Assertions.fail("Use case failure is unexpected.");
            }
        };
        TakeQuizInputBoundary interactor = new TakeQuizInteractor(quizRepository, successPresenter); // may take in more things?
        interactor.execute(inputData);
    }


}

