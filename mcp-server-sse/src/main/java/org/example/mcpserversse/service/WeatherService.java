package org.example.mcpserversse.service;

import org.example.mcpserversse.pojo.WeatherPojo;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Service
public class WeatherService {

    // 响应模板，自然语句格式
    private static final String RESPONSE_TEMPLATE = """
            %s的天气为%s, 气温为%s
            """;

    private final RestClient restClient;

    public WeatherService() {
        String apiUrl = "http://apis.juhe.cn/simpleWeather/query";
        this.restClient = RestClient.builder()
                .baseUrl(apiUrl)
                .defaultHeader("Content-Type", "application/x-www-form-urlencoded")
                .defaultHeader("Accept", "application/json")
                .defaultHeader("User-Agent", "WeatherApiClient/1.0")
                .build();
    }

    @Tool(description = "获得中国的天气信息")
    public String getWeather(
            @ToolParam(description = "城市") String city
    ) throws UnsupportedEncodingException {

        String apiKey = "fc20e2e64ab83128c565216b477a9e2f";
        RestClient.ResponseSpec retrieve = this.restClient.get()
                .uri("?key=" + apiKey + "&city=" + city)
                .retrieve();
        WeatherPojo body = retrieve.body(WeatherPojo.class);
        try {
            return String.format(RESPONSE_TEMPLATE,
                    city,
                    body.getResult().getRealtime().getInfo(),
                    body.getResult().getRealtime().getTemperature()
            );
        } catch (NullPointerException e) {
            return "抱歉，我无法获取到" + city + "的天气信息";
        }
    }
}
