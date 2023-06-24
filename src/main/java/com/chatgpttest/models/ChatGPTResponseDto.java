package com.chatgpttest.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatGPTResponseDto {
    private List<ChatGPTResponseChoice> choices;
}