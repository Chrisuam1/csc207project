package use_case.take_quiz;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
        } else if (inputData.getNumQuestions() * 2 > takeQuizDataAccessObject.getNumSongs()) {
            takeQuizPresenter.prepareFailView("Not enough songs in database.");
        } else {

            // chose an appropriate amount of songs
            try {
                TakeQuizOutputData outputData = new TakeQuizOutputData(
                    takeQuizDataAccessObject.getRandomSongs(inputData.getNumQuestions() * 2));
                takeQuizPresenter.prepareSuccessView(outputData);
            } catch (Exception e) {
                takeQuizPresenter.prepareFailView(e.getMessage());
            }
        }
    }
}