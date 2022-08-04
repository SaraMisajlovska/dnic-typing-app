package mk.ukim.finki.dnic.typingapp.repository;

import mk.ukim.finki.dnic.typingapp.domain.identity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
