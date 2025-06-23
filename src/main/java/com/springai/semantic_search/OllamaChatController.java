package com.springai.semantic_search;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaChatController {
    private final ChatClient chatClient;

    public OllamaChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/ollama/chat")
    public String chat(@RequestParam("msg")  String msg) {
        return chatClient
                .prompt()
                .system("You are a helpful assistant.")
                .user(msg)
                .call()
                .content();
    }
}