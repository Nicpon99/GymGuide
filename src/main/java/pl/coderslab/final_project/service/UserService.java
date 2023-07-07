package pl.coderslab.final_project.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.final_project.entity.User;
import pl.coderslab.final_project.exceptions.ValidationException;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUserName(String name);

    void saveUser(User user);

    public void editUser(User user);

    public void editPassword(User user);

    public User registerUser(User user) throws ValidationException;

    public Optional<User> findByEmail(String email);

    public User editUniqueUser(User user) throws ValidationException;

}
