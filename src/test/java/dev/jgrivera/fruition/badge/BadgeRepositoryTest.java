package dev.jgrivera.fruition.badge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BadgeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BadgeRepository repository;

    @Test
    public void it_gets_badges_by_name() throws Exception {
        Badge badge = new Badge("test");
        entityManager.persist(badge);
        entityManager.flush();

        Badge foundBadge = repository.findByName(badge.getName());

        assertThat(foundBadge.getName()).isEqualTo(badge.getName());
    }
}
