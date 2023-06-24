package com.chatgpttest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chatgpttest.models.ChatGPTMessageDto;
import com.chatgpttest.models.ChatGPTRequestDto;
import com.chatgpttest.models.ChatGPTResponseDto;

@Service
public class ChatGPTService {

    @Value("${chatgpt.apiKey}")
    private String apiKey;

    @Value("${chatgpt.endpoint}")
    private String endpoint;

    @Value("${chatgpt.model}")
    private String model;

    private RestTemplate restTemplate = new RestTemplate();

    public String fetchChatResponse(String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        List<ChatGPTMessageDto> messages = new ArrayList<>();
        messages.add(new ChatGPTMessageDto("user", message));

        ChatGPTRequestDto request = new ChatGPTRequestDto(messages, model);

        HttpEntity<ChatGPTRequestDto> entity = new HttpEntity<>(request, headers);

        ResponseEntity<ChatGPTResponseDto> apiResponse = restTemplate.exchange(endpoint, HttpMethod.POST, entity,
                ChatGPTResponseDto.class);

        if (apiResponse.getStatusCode() == HttpStatus.OK) {
            ChatGPTResponseDto chatResponseDto = apiResponse.getBody();
            if (Objects.nonNull(chatResponseDto) && Objects.nonNull(chatResponseDto.getChoices())) {
                return chatResponseDto.getChoices().get(0).getMessage().getContent();
            }
        }

        return "Failed to fetch chat response.";
    }
}
