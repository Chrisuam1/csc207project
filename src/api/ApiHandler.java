package api;
public interface ApiHandler {
    String getClientID();
    void setClientID(String id);
    String getClientSecret();
    void setClientSecret(String secret);
    void authenticate();
    boolean checkIsAuthenticated();
}
