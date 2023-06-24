package com.chatgpttest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatGPTMessageDto {
    private String role;
    private String content;
    
    public ChatGPTMessageDto(String role, String content) {
        this.role = role;
        this.content = content;
    }
}
    