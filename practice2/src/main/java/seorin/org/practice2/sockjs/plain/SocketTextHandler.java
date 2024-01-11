package seorin.org.practice2.sockjs.plain;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
public class SocketTextHandler extends TextWebSocketHandler {

  // 임의의 세션
  private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    log.info("접속 성공");
    sessions.add(session);
  }

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    String payload = message.getPayload();
    log.info("payload = {}", payload);
    for (WebSocketSession s : sessions) {
      if (!session.equals(s)) {
        s.sendMessage(message);
      }
    }
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    log.info("접속 해제");
    sessions.remove(session);
  }
}
