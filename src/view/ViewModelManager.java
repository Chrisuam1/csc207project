package src.view;

public class ViewModelManager {
    ViewModel currentView;

    public ViewModelManager(ViewModel currentView) {
        this.currentView = currentView;
    }

    public void setCurrentView(ViewModel view) {
        this.currentView = view;
    }

    public ViewModel getCurrentView() {
        return currentView;
    }
}
