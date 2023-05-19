package itis.giniyatov.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageAjaxController {

    @PostMapping("/send-message")
    @ResponseBody
    public String sendMessage(@RequestBody MessageRequest request) {

        String name = request.getName();
        return "Message sent successfully";
    }

    public static class MessageRequest {
        private String name;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
