package com.backall.msg.resource;

import com.backall.msg.domain.websocket.GreetingMessage;
import com.backall.msg.domain.websocket.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;

@Controller
public class GreetingResource {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public GreetingMessage greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new GreetingMessage("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @PostMapping("/greetings")
    public void greet(String greeting) {
        String text = "[" + new Date() + "]:" + greeting;
        simpMessagingTemplate.convertAndSend("/topic/greetings", text);
    }

}
