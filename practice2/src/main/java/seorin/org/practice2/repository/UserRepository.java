package seorin.org.practice2.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import seorin.org.practice2.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	Optional<User> findByUsername(String username);
}
