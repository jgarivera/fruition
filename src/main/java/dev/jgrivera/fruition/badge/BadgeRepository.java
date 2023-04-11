package dev.jgrivera.fruition.badge;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BadgeRepository extends CrudRepository<Badge, UUID> {
    Badge findByName(String name);
}