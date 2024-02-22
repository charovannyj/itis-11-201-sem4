package ru.kpfu.itis.nikolaev.controller;

import ru.kpfu.itis.nikolaev.util.HttpClient;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private HttpClient httpClient;
    public MyController(HttpClient httpClient) {
        this.httpClient = httpClient;

    }

    @GetMapping("/weather")
    protected String getWeather()  {
        Float kelvinCelsius = 273.15F;
        String API = "630038a3144129b2eca8f66b4ec7ec82";
        String weather = httpClient.get("https://api.openweathermap.org/data/2.5/weather?q=" + "Kazan" + "&appid=" + API, null);
        JSONObject json = new JSONObject(weather);
        String temperature = String.valueOf(json.getJSONObject("main").getFloat("temp")-kelvinCelsius);
        String humidity = String.valueOf(json.getJSONObject("main").getInt("humidity"));
        String description = json.getJSONArray("weather").getJSONObject(0).getString("description");
        StringBuilder sb = new StringBuilder();
        sb.append("Weather in Kazan:" + "<br>");
        sb.append("temperature: " + temperature + "<br>");
        sb.append("humidity: " + humidity + "<br>");
        sb.append("description: " + description + "<br>");
        return sb.toString();
    }
    @GetMapping("/currency")
    protected String getCurrency()  {
        String currency = httpClient.get("https://open.er-api.com/v6/latest/USD", null);
        JSONObject json = new JSONObject(currency);
        String currencyUsdRub = String.valueOf(json.getJSONObject("rates").get("RUB"));
        String resultAnswer = String.valueOf(new StringBuilder().append("Dollar to ruble exchange rate - " + currencyUsdRub));
        return resultAnswer;
    }
}

