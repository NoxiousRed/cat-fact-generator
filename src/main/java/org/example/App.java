package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


/**
 * A program to specify an API URL, make a Http request to that API and collect the resulting JSON,
 * parse that JSON into a java object, and print the information the user wants to see.
 */
public class App
{

    //URL for querying the API to return the JSON that API creates
    private static final String POSTS_API_URL = "https://catfact.ninja/fact";

    public static void main( String[] args ) throws IOException, InterruptedException {

        //Simple greeting to show that the system is processing
        System.out.println("Welcome to the Random Cat Fact Generator!");
        System.out.println("Getting your random cat fact...\n");
        
        //build a new get request for the Http client for specified API URL
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                //make sure we're only accepting JSONs into the program
                .header("accept", "application/json")
                .uri(URI.create(POSTS_API_URL))
                .build();
        //Collect the response JSON for further manipulation
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        /*parse JSON into java object and print only the information we want the user to see.
        in this case, that information is just the fact while forgoing the data for the length of
        the string returned with the JSON.
         */
        ObjectMapper mapper = new ObjectMapper();
        //Build the Fact object by mapping the response to the returned JSON
        Fact fact = mapper.readValue(response.body(), new TypeReference<Fact>() {});
        System.out.println(fact);
    }
}