package dev.jgrivera.fruition.badge;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BadgeRepository {
    private final List<Badge> badges;

    public BadgeRepository() {
        badges = new ArrayList<>();
        badges.add(new Badge("1", "Test badge!"));
    }

    public Badge getBadge(String id) {
        for (Badge badge : badges) {
            if (badge.id().equals(id)) {
                return badge;
            }
        }
        return null;
    }

    public List<Badge> getBadges() {
        return badges;
    }
}
