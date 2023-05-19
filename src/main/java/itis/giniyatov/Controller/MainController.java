package itis.giniyatov.Controller;


import itis.giniyatov.Model.Message;
import itis.giniyatov.Model.User;
import itis.giniyatov.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String firstPage(Map<String, Object> model) {
        return "FirstPage";
    }



    @GetMapping("/main")
    public String mainPage(@RequestParam(required = false, defaultValue = "") String check, Model model) {
        Iterable<Message> messages = messageRepo.findAll();
        if (check != null && !check.isEmpty()) {
            messages = messageRepo.findByTag(check);
        } else {
            messages = messageRepo.findAll();
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", check);

        return "main";
    }


    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User usr,
            @Valid Message message,
            BindingResult result,
            Model model,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        message.setAuthor(usr);

        if (result.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(result);

            model.mergeAttributes(errorsMap);
            model.addAttribute("message", message);
        } else {
            if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);

                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                String uuidfile = UUID.randomUUID().toString();
                String resultFilename = uuidfile + "." + file.getOriginalFilename();
                System.out.println("112211"+uploadPath);

                file.transferTo(new File(uploadPath + "/" + resultFilename));

                message.setFilename(resultFilename);
            }

            model.addAttribute("message", null);

            messageRepo.save(message);
        }
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);

        return "main";
    }
}
