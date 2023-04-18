package dev.jgrivera.fruition.badge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BadgeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BadgeRepository repository;

    @Test
    public void it_gets_badges() {
        Badge badge1 = new Badge("test 1");
        entityManager.persist(badge1);

        Badge badge2 = new Badge("test 2");
        entityManager.persist(badge2);

        entityManager.flush();

        Iterable<Badge> badges = repository.findAll();

        assertThat(badges).contains(badge1, badge2);
    }

    @Test
    public void it_gets_badge_by_id() throws NoSuchElementException {
        Badge badge = new Badge("test");
        entityManager.persist(badge);
        entityManager.flush();

        Badge foundBadge = repository.findById(badge.getId()).orElseThrow();

        assertThat(foundBadge.getId()).isEqualTo(badge.getId());
    }

    @Test
    public void it_gets_badge_by_name() {
        Badge badge = new Badge("test");
        entityManager.persist(badge);
        entityManager.flush();

        Badge foundBadge = repository.findByName(badge.getName());

        assertThat(foundBadge.getName()).isEqualTo(badge.getName());
    }
}
