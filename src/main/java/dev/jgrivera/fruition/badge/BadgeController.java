package dev.jgrivera.fruition.badge;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/badges")
public class BadgeController {

    private final BadgeRepository repository;

    public BadgeController(BadgeRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = {"", "/"}, produces = MediaType.APPLICATION_JSON_VALUE)
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

    @PostMapping(path = {"", "/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createBadge(@Valid @RequestBody Badge badge) {
        repository.save(badge);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "Successfully created badge");

        return ResponseEntity.ok().body(map);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Badge> updateBadge(@PathVariable("id") String id, @Valid @RequestBody Badge updateBadge) {
        Optional<Badge> optionalBadge = repository.findById(UUID.fromString(id));

        if (optionalBadge.isPresent()) {
            Badge badge = optionalBadge.get();
            badge.setName(updateBadge.getName());

            Badge updatedBadge = repository.save(badge);
            return ResponseEntity.ok().body(updatedBadge);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Badge> deleteBadge(@PathVariable("id") String id) {
        Optional<Badge> optionalBadge = repository.findById(UUID.fromString(id));

        if (optionalBadge.isPresent()) {
            repository.deleteById(UUID.fromString(id));
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
