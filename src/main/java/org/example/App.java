package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class App
{

    private static final String POSTS_API_URL = "https://catfact.ninja/fact";

    public static void main( String[] args ) throws IOException, InterruptedException {

        System.out.println("Welcome to the Random Cat Fact Generator!");
        System.out.println("Getting your random cat fact...\n");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POSTS_API_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        //parse JSON into objects
        //ObjectMapper mapper = new ObjectMapper();

    }
}