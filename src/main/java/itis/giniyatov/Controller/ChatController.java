package itis.giniyatov.Controller;

import itis.giniyatov.Model.MessageChat;
import itis.giniyatov.Model.OutputMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class ChatController 
{
    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }
    @MessageMapping("/chat/{topic}")
    @SendTo("/topic/messages")
    public OutputMessage send(@DestinationVariable("topic") String topic,
                              MessageChat messageChat) throws Exception
    {
	return new OutputMessage(messageChat.getFrom(), messageChat.getText(), topic);
    }



}



