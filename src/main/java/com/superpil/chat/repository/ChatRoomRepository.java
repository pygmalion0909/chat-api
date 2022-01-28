package com.superpil.chat.repository;

import com.superpil.chat.entity.chat.ChatRoom;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer>{
  
}
