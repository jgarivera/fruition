package dev.jgrivera.fruition.badge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BadgeController {

    @Autowired
    private BadgeRepository repository;

    @GetMapping("/")
    public List<Badge> getBadges() {
        return repository.getBadges();
    }

    @GetMapping("/{id}")
    public Badge getBadge(@PathVariable String id) {
        return repository.getBadge(id);
    }
}
