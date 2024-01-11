package seorin.org.practice2.socketio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

  private MessageType type;
  private String content;
  private String room;

  public Message(MessageType type, String content) {
    this.type = type;
    this.content = content;
  }
}