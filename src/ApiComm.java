import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiComm {
    private final String URL_BASE = "https://v6.exchangerate-api.com/v6/";
    private final HttpClient client;

    public ApiComm() {
        this.client = HttpClient.newHttpClient();
    }

    public JsonObject requestData(String apikey) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE + apikey + "codes"))
                .build();
        try {
            HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), JsonObject.class);
        } catch (IOException | InterruptedException | IllegalAccessError e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public JsonObject requestData (String apikey, String codeFrom, String codeTo) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.URL_BASE + apikey + "/pair/" + codeFrom + "/" + codeTo ))
                .build();
        try {
            HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), JsonObject.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
