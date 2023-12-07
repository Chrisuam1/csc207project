package interface_adapter.answer_question;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AnswerQuestionViewModel extends ViewModel {

    public final String QUESTION_LABEL = "which song is more popular?";
    public final String SCORE_LABEL = "score:";

    private AnswerQuestionState state = new AnswerQuestionState();

    public AnswerQuestionViewModel() {
        super("question");
    }

    public void setState(AnswerQuestionState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the AnswerQuestion Presenter will call to let the ViewModel know
    // to alert the View
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public AnswerQuestionState getState() {
        return state;
    }

}
