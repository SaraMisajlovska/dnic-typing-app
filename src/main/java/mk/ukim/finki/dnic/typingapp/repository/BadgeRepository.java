package mk.ukim.finki.dnic.typingapp.repository;

import mk.ukim.finki.dnic.typingapp.domain.models.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {
}
