package pl.coderslab.final_project.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.final_project.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUserName(String name);

    void saveUser(User user);

    public void editUser(User user);

    public void editPassword(User user);
}
