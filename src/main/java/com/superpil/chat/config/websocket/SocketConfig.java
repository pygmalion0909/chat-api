package com.superpil.chat.config.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import lombok.extern.slf4j.Slf4j;

@Configuration // 환경설정 선언
@EnableWebSocketMessageBroker // 웹 소켓 활성화(stomp)
@Slf4j
public class SocketConfig implements WebSocketMessageBrokerConfigurer {

  /**
   * 구독
   */
  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker("/sub");
    config.setApplicationDestinationPrefixes("/pub");
  }

  /**
   * 요청
   */
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    log.info("socket enter : {}", registry);
    registry.addEndpoint("/ws-stomp") // 서버 요청 path
            .setAllowedOrigins("*");
            // .withSockJS(); // 클라이언트에서 sockjs를 사용할때
  }

}