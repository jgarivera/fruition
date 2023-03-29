package dev.jgrivera.fruition.badge;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/badges")
public class BadgeController {

    private final BadgeRepository repository;

    public BadgeController(BadgeRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Badge>> getBadges() {
        Iterable<Badge> badges = repository.findAll();

        return ResponseEntity.ok().body(badges);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Badge> getBadge(@PathVariable String id) {
        Optional<Badge> badge = repository.findById(UUID.fromString(id));

        if (badge.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(badge.get());
        }
    }
}
