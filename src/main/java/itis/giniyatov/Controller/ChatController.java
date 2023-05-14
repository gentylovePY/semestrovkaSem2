package itis.giniyatov.Controller;

import itis.giniyatov.Model.MessageChat;
import itis.giniyatov.Model.OutputMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/*
 * Chat Controller listens for chat topic and responds with a message.
 *
 * @Author Jay Sridhar
 */
@Controller
public class ChatController 
{
    @MessageMapping("/chat/{topic}")
    @SendTo("/topic/messages")
    public OutputMessage send(@DestinationVariable("topic") String topic,
                              MessageChat messageChat) throws Exception
    {
	return new OutputMessage(messageChat.getFrom(), messageChat.getText(), topic);
    }
}
