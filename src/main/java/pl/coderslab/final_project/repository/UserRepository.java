package pl.coderslab.final_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.final_project.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET username = ?1, email = ?2 WHERE id = ?3", nativeQuery = true)
    void editUser(String username, String email, Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET password = ?1 WHERE id = ?2", nativeQuery = true)
    void editPassword(String password, Long id);

}
