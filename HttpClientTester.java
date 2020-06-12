import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.*;
import java.nio.charset.*;
import java.util.*;
public class HttpClientTester
// @author Victor Mendoza
{
    private final static String URL = "https://cisp21profh.pythonanywhere.com/api/spring2020";
    public static void main(final String[] args) throws IOException, URISyntaxException, InterruptedException
        {        
           java.net.http.HttpClient client = HttpClient.newHttpClient();

            if (client != null)
            {
                System.out.println("\nclient object: " + client);
                HttpRequest request = HttpRequest.newBuilder().uri(new URI(URL)).GET().build();
                if (request != null)
                {
                    System.out.println("\nrequest object: " + request);
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    if(response != null)
                    {
                        String bodyString = response.body();
                        HttpHeaders responseHeaders = response.headers();
                        Map<String, List<String>> headerMap = responseHeaders.map();
                        //String responseHeaders = response.headers();
                        System.out.println("response.body:");
                        System.out.println(bodyString);
                        System.out.println("response.headers:");
                        
                        for (Map.Entry<String, List<String>> entry : headerMap.entrySet())
                        {
                            if(entry.getKey().toString().matches("date|content-type|content-length"))
                            {
                                System.out.println(entry.getKey().toString() + ": " + entry.getValue().get(0));    
                            }
                        }
                    }
                }          
            } 
        }
    
}