package fr.adam.sync_calendar;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Authentication {

    private String LOGIN = "abrevet.ira2023";
    private String PASS = "d72c17";

    private String LOGIN_NAME_TOKEN = "UcAuthentification1$UcLogin1$txtLogin";
    private String PASS_NAME_TOKEN = "UcAuthentification1$UcLogin1$txtPassword";

    private String AUTHENTICATION_URL = "https://esaip.alcuin.com/OpDotNet/Noyau/Login.aspx";

    public Authentication() {
        this.keep_session();
    }

    private void keep_session(){
        CookieManager cookieManager = new CookieManager();  
        CookieHandler.setDefault(cookieManager);
    }

    public HashMap<String, String> getInputs() throws IOException {
        Document document = Jsoup.connect("https://esaip.alcuin.com/OpDotNet/Noyau/Login.aspx").get();
        Elements inputs = document.getElementsByTag("input");
        
        HashMap<String, String> data = new HashMap<String, String>();
        for (Element el : inputs) {
            data.put(el.select("input[name]").val(), el.select("input[value]").val());
        }
        return data;
    }

    public int authenticate(HashMap<String, String> data) throws IOException, InterruptedException {

        data.replace(LOGIN_NAME_TOKEN, LOGIN);
        data.replace(PASS_NAME_TOKEN, PASS);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(AUTHENTICATION_URL))
        .POST(BodyPublishers.ofString(data.toString()))
        .build();
        
        HttpResponse<?> response = client.send(request, BodyHandlers.discarding());
        
        return response.statusCode();
    }
}
