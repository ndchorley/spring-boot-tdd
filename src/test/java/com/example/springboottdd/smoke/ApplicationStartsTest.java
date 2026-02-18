package com.example.springboottdd.smoke;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationStartsTest {
    @Test
    void the_application_is_up_and_running() throws IOException, InterruptedException {
        var request =
            HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        var response =
            HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        assertThat(response.statusCode()).isEqualTo(200);
    }
}
