package com.superpil.chat.controller;

import com.superpil.chat.dto.chat.ChatMessageDto;
import com.superpil.chat.dto.chat.ChatRoomDto;
import com.superpil.chat.service.ChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/chat")
@Slf4j
public class ChatController {
  
  @Autowired
  private ChatService chatService;
  @Autowired
  private SimpMessageSendingOperations messagingTemplate;

  @GetMapping("/room/list")
  public String getRoomList() {
    return "chat/Room";
  }

  @PostMapping("/room")
  public void createRoom(@RequestBody ChatRoomDto chatRoomDto) {
    chatService.createRoom(chatRoomDto);
  }

  @MessageMapping("/message")
  public void handleMessge(ChatMessageDto chatMessageDto) {
    log.info("chatMessageDto : {}", chatMessageDto);
    if (chatMessageDto.equals("enter")) {
      chatMessageDto.setMessage(chatMessageDto.getSender() + "님이 입장하셨습니다.");
      messagingTemplate.convertAndSend("/sub/chat/room/" + chatMessageDto.getRoomKey(), chatMessageDto);
    }
  }

}