package interface_adapter;

import java.beans.PropertyChangeListener;

public class MainMenuViewModel extends ViewModel {
    public MainMenuViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
