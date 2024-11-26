//package com.example.moamz.socket;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//@Component
//@Slf4j
//public class WebSocketHandler extends TextWebSocketHandler {
//    // 클라이언트가 보내는 메세지 요청을 처리할 핸들러
//    // 텍스트 기반의 통신이기 때문에 TextWebSocketHandler를 상속받는다.
//
//    // 소켓 연결 확인
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        log.info("{} 연결됨", session.getId());
//        session.sendMessage(new TextMessage("WebSocket 연결 완료"));
//
//    }
//
//}
