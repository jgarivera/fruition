package dev.jgrivera.fruition.badge;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
public class BadgeController {

    private final BadgeRepository repository;

    public BadgeController(BadgeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public Iterable<Badge> getBadges() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Badge> getBadge(@PathVariable String id) {
        return repository.findById(UUID.fromString(id));
    }
}
