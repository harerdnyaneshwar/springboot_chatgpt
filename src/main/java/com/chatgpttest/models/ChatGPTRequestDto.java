package com.chatgpttest.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatGPTRequestDto {
    private List<ChatGPTMessageDto> messages;
    private String model;

    public ChatGPTRequestDto(List<ChatGPTMessageDto> messages, String model) {
        this.messages = messages;
        this.model = model;
    }
}
