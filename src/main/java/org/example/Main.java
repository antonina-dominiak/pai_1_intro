package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.time.Duration;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static final int N = 3;

    public static void main(String[] args) {

        String url = "https://httpbin.org/delay/2";
        // wyslanie requestu
        String response = request(url);

        // obrobka odpowiedzi
        process(response);

    }

    private static String request(String url1) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            int retryCount = 0;
            int backoffDelay = 1;
            while (retryCount < N) {
                try {
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(new URI(url1))
                            .timeout(Duration.ofSeconds(backoffDelay))
                            //.GET()
                            .POST(HttpRequest.BodyPublishers.ofString("{\"imie\":\"natalia\"}"))
                            .header("Content-Type", "application/json")
                            .build();
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    if (response.statusCode() == 200) {
                        return response.body();
                    }

                } catch (HttpTimeoutException e) {

                }
                retryCount++;
                Thread.sleep(1000 * backoffDelay);
                backoffDelay ^= 2;
            }

            return null;

/*            var response = client.send(request, ofString());
            if (response.statusCode() != 200) {
                System.exit(1);
            }
            return response.body();*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static void process(String response1) {
        System.out.println(response1);
    }
}