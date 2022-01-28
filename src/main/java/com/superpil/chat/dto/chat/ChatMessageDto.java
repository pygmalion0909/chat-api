package com.superpil.chat.dto.chat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageDto {

  private String type;
  private String roomKey;
  private String sender;
  private String message;
  
}
