package api.src.api;
public interface ApiHandler {
    String getClientID();
    void setClientID();
    String getClientSecret();
    void setClientSecret();
    void authenticate();
    boolean checkIsAuthenticated();
}
