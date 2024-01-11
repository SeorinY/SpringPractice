package seorin.org.practice2.socketio;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class SocketConfig {

  @Bean
  public SocketIOServer socketIOServer() {
    com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
//    config.setPort(socketProperties.getPort());
    // config.setHostname("*");
    config.setPort(8081);
    config.setOrigin("*");
//    config.setExceptionListener(exceptionListener);
    SocketIOServer server = new SocketIOServer(config);
//    mappingSupporter.addListeners(server);
//    server.addConnectListener(connectController::onConnect);
//    server.addDisconnectListener(disConnectController::onDisconnect);
//    server.addEventListener("send_message", Message.class, onChatReceived());
    return server;
  }

//  private DataListener<Message> onChatReceived() {
//    return (senderClient, data, ackSender) -> {
//      log.info(data.toString());
//      senderClient.getNamespace().getBroadcastOperations().sendEvent("get_message", data.getMessage());
//
//    };
//  }
}