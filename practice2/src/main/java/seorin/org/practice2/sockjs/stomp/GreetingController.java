package seorin.org.practice2.sockjs.stomp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import seorin.org.practice2.sockjs.stomp.dto.HelloMessage;

@RestController
public class GreetingController {

  @MessageMapping("/test")
  @SendTo("/topic/greeting")
  public HelloMessage greeting(HelloMessage request) {
    return new HelloMessage("hello socket!");
  }
}