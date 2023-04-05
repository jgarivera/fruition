package dev.jgrivera.fruition.badge;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/badges")
public class BadgePageController {

    @GetMapping(path = {"", "/"}, produces = MediaType.TEXT_HTML_VALUE)
    public String viewHomePage() {
        return "index";
    }
}
