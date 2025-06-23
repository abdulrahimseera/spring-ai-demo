package com.springai.semantic_search;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaChatController {
    private final ChatClient chatClient;

    public OllamaChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ollama/generate")
    public String generate(@RequestParam String message) {
        return chatClient.prompt(message).toString();
    }
}