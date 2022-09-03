package mk.ukim.finki.dnic.typingapp.repository;

import mk.ukim.finki.dnic.typingapp.domain.identity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

    Optional<User> findByUsername(String username);

}
