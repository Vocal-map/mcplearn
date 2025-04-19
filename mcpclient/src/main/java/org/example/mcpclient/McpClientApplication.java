package org.example.mcpclient;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
public class McpClientApplication  {

    @Autowired
    private ChatClient chatClient;

    public static void main(String[] args) {
        SpringApplication.run(McpClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner predefinedQuestions(ConfigurableApplicationContext context) {

        return args -> {
            System.out.println(">>> ASSISTANT: " + chatClient
                    .prompt()
                    .user("今天福州这个城市天气怎么样")
                    .call()
                    .content());
            context.close();
        };
    }
}
