package dev.jgrivera.fruition.badge;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BadgeController {

    @GetMapping("/badge")
    public Badge getBadge() {
        return new Badge("Test badge!");
    }

}
