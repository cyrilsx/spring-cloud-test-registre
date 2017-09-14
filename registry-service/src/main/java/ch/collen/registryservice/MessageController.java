package ch.collen.registryservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cyril on 13/09/17.
 */
@RestController
public class MessageController {

    @Value("${welcome.message}")
    private String message;

    @RequestMapping(path = "/message")
    public String message() {
        return message;
    }

}
