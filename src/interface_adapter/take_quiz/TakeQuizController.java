package interface_adapter.take_quiz;

import use_case.take_quiz.TakeQuizInputBoundary;
import use_case.take_quiz.TakeQuizInputData;
import use_case.take_quiz.answer_question.AnswerQuestionInputData;

public class TakeQuizController {

    final TakeQuizInputBoundary takeQuizInteractor;

    public TakeQuizController(TakeQuizInputBoundary takeQuizInteractor) {
        this.takeQuizInteractor = takeQuizInteractor;
    }

    public void execute(int numQuestions) {
        TakeQuizInputData takeQuizInputData = new TakeQuizInputData(numQuestions);
        takeQuizInteractor.execute(takeQuizInputData);
    }
}