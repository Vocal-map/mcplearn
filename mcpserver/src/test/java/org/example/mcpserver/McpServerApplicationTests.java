package org.example.mcpserver;

import org.example.mcpserver.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static java.net.URLDecoder.decode;
import static java.net.URLEncoder.encode;

@SpringBootTest
class McpServerApplicationTests {

	@Test
	void contextLoads() throws UnsupportedEncodingException {
//		WeatherService service = new WeatherService();
//
//		String weather = service.getWeather("福州");
//		System.out.println(weather);

	}

}
