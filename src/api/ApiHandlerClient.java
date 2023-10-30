package api.src.api;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;

public class ApiHandlerClient implements ApiHandler {
    private String clientID;
    private String clientSecret;
    private SpotifyApi API;
    private ClientCredentials credentials;
    private boolean isAuthenticated = false;

    public ApiHandlerClient(String id, String secret) {
        this.clientID = id;
        this.clientSecret = secret;
    }

    @Override
    public void authenticate() {
        try {
            credentials = new SpotifyApi.Builder()
                    .setClientId(clientID)
                    .setClientSecret(clientSecret)
                    .build()
                    .clientCredentials()
                    .build()
                    .execute();
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return;
        }
        API = new SpotifyApi.Builder()
                .setClientId(clientID)
                .setClientSecret(clientSecret)
                .setAccessToken(credentials.getAccessToken())
                .build();
        isAuthenticated = true;
    }

    /*// Getters and Setters //*/
    @Override
    public boolean checkIsAuthenticated() {return isAuthenticated;}
    @Override
    public String getClientID() {return clientID;}
    @Override
    public void setClientID(String id) {this.clientID = id;}
    @Override
    public String getClientSecret() {return clientSecret;}
    @Override
    public void setClientSecret(String secret) {this.clientSecret = secret;}
}
