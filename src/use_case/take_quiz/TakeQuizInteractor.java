package use_case.take_quiz;

public class TakeQuizInteractor implements TakeQuizInputBoundary {

    final TakeQuizOutputBoundary takeQuizPresenter;
    final TakeQuizDataAccessInterface takeQuizDataAccessObject;

    public TakeQuizInteractor(TakeQuizOutputBoundary takeQuizPresenter,
                              TakeQuizDataAccessInterface takeQuizDataAccessObject) {
        this.takeQuizPresenter = takeQuizPresenter;
        this.takeQuizDataAccessObject = takeQuizDataAccessObject;
    }

    @Override
    public void execute(TakeQuizInputData inputData) {
        if (takeQuizDataAccessObject.getNumSongs() == 0) {
            takeQuizPresenter.prepareFailView("No songs in database.");
        } else if (inputData.getNumQuestions() > takeQuizDataAccessObject.getNumSongs()) {
            takeQuizPresenter.prepareFailView("Not enough songs in database.");
        } else {

            //TakeQuizOutputData outputData = new TakeQuizOutputData();
            // chose an appropriate amount of songs
            //takeQuizPresenter.prepareSuccessView();
        }
    }
}