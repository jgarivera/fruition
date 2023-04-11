package dev.jgrivera.fruition.badge;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/badges")
public class BadgePageController {

    private final BadgeRepository repository;

    public BadgePageController(BadgeRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = {"", "/"}, produces = MediaType.TEXT_HTML_VALUE)
    public String viewHomePage(Model model) {
        List<Badge> badges = new ArrayList<>();
        repository.findAll().forEach(badges::add);

        model.addAttribute("badges", badges);

        return "index";
    }
}
