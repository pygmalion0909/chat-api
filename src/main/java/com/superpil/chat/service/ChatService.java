package com.superpil.chat.service;

import com.superpil.chat.dto.chat.ChatRoomDto;
import com.superpil.chat.entity.chat.ChatRoom;
import com.superpil.chat.repository.ChatRoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChatService {
  
  @Autowired
  ChatRoomRepository chatRoomRepository;

  public void createRoom(ChatRoomDto chatRoomDto) {

    ChatRoom room = ChatRoom.createChatRoom(chatRoomDto);
    log.info("chat room : {}", room);
    chatRoomRepository.save(room);
    
  }

}
