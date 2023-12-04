package src.view;

public abstract class ViewModel {
    private final String viewName;

    public ViewModel(String viewName) {
        this.viewName = viewName;
    }
    public String getViewName() {return viewName;}

    public abstract void propertyChanged();
}
