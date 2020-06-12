import java.io.*;
import java.net.*;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.*;
import java.util.*;
import org.apache.http.*;
import sun.net.www.http.HttpClient;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;
public class HttpClientTester
// @author Victor Mendoza
{
    private final static String URL = "https://cisp21profh.pythonanywhere.com/api/spring2020";
    public static void main(final String[] args) throws IOException
        {        
            //java.net.http.HttpClient client = HttpClient.newHttpClient();
           HttpClient client = HttpClient.newHttpClient();

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

                    }
                }          
            } 
        }
    
