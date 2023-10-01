package api;
import okhttp3.*;

import java.io.IOException;

public class getLyrics {
    private static final String API_URL = "https://api.lyrics.ovh/v1/artist/title";

    public void main(String artist, String title) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.lyrics.ovh/v1/artist/title?artist=Coldplay&title=Adventure%20of%20a%20Lifetime")
                .get()
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response);
    }
}