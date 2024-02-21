package com.example.chatgptbasedcookingingredients.service;

import com.example.chatgptbasedcookingingredients.model.ChatGptRequest;
import com.example.chatgptbasedcookingingredients.model.ChatGptResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service

public class IngredientService {
    private RestClient restClient;

    public IngredientService(@Value("${open.ai.key}") String apiKey, @Value("${open.ai.url}") String url){

        restClient = RestClient.builder()
                .defaultHeader("Authorization", apiKey)
                .baseUrl(url)
                .build();
    }

    public String categorizeIngredient(String ingredient) {
        ChatGptRequest request = new ChatGptRequest(ingredient);
        ChatGptResponse response = restClient.post()
                .body(request)
                .retrieve()
                .body(ChatGptResponse.class);

        return response.getAnswer();
    }



}
