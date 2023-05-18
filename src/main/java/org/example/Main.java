package org.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

import static java.net.http.HttpResponse.BodyHandlers.ofString;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {


        String url = "https://httpbin.org/delay/2";
        // wyslanie requestu
        String response = request(url);

        // obrobka odpowiedzi
        process(response);
    }

    private static String request(String url1) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url1))
                    .timeout(Duration.ofSeconds(1))
                    //.GET()
                    .POST(HttpRequest.BodyPublishers.ofString("{\"imie\":\"natalia\"}"))
                    .header("Content-Type", "application/json")
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            var response = client.send(request, ofString());
            if (response.statusCode() != 200) {
                System.exit(1);
                //status to kod erroru
            }
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static void process(String response1) {
        System.out.println(response1);
    }
}