package bryant;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	String url = "https://api.openweathermap.org/data/2.5/weather";
    Scanner scannerUserInput = new Scanner(System.in);
    String param1 =  scannerUserInput.nextLine();
    String param2 = scannerUserInput.nextLine();
    String param3 = "imperial";
    String charset = "UTF-8";
    String query = null;
    InputStream response = null;


    try {
        query =  String.format("q=%s&appid=%s&units=%s",
                 URLEncoder.encode(param1, charset),
                 URLEncoder.encode(param2, charset),
                 URLEncoder.encode(param3, charset));
        URLConnection connection = new URL(url + "?" + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        response = connection.getInputStream();
    } catch (IOException e) {
        e.printStackTrace();
    }

    if (response != null) {
        try (Scanner scanner = new Scanner(response)) {
            String responseBody = scanner.useDelimiter("\\A").next();
            System.out.println(responseBody);
            Gson gson = new Gson();
            WeatherConditions weatherConditions = gson.fromJson(responseBody, WeatherConditions.class);
            weatherConditions.display();
        }
    }

    }
}
