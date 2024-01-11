package seorin.org.practice2.sockjs.stomp;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketBrokerConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    // 구독 경로!
    registry.enableSimpleBroker("/queue", "/topic"); // 스프링 내장 브로커 사용
    // queue 1:1
    // topic 1:n (구독)
    registry.setApplicationDestinationPrefixes("/app"); // 핸들러로 라우팅해줌
  }
  
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/stomp/chatting")
        .setAllowedOrigins("*")
//        .withSockJS()
    ;

  }
}