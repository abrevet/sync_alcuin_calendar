package fr.adam.sync_calendar;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Utils {

    public Utils() {

    }

    public HttpResponse request(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build();
        
        HttpResponse<?> response = client.send(request, BodyHandlers.discarding());
        return response;
    }
}
