package com.superpil.chat.entity.chat;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.superpil.chat.dto.chat.ChatRoomDto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_chat_room")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ChatRoom {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "room_id")
  private int id;
  @Column(name = "room_key")
  private String roomKey;
  @Column(name = "room_name")
  private String roomName;
  @Column(name = "create_date")
  private LocalDateTime createDate;
  @Column(name = "modify_date")
  private LocalDateTime modifyDate;

  public static ChatRoom createChatRoom(ChatRoomDto chatRoomDto) {
    ChatRoom room = new ChatRoom();
    room.roomKey = UUID.randomUUID().toString();
    room.roomName = chatRoomDto.getRoomName();
    room.createDate = LocalDateTime.now();
    return room;
  }

}
