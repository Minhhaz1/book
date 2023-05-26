package bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookstore.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
    User getUserByEmailAndPassword(String email, String password);
    boolean findByEmailAndPassword(String email, String password);
    User getUserById(Integer id);
}
