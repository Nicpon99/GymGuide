package pl.coderslab.final_project.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.final_project.entity.Role;
import pl.coderslab.final_project.entity.User;
import pl.coderslab.final_project.exceptions.ValidationException;
import pl.coderslab.final_project.repository.RoleRepository;
import pl.coderslab.final_project.repository.UserRepository;

import java.util.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Optional<User> findByUserName(String name){
        return userRepository.findByUsername(name);
    }

    @Override
    public void saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public void editUser(User user){
        userRepository.editUser(user.getUsername(), user.getEmail(), user.getId());
    }


    @Override
    public void editPassword(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.editPassword(user.getPassword(), user.getId());
    }

    @Override
    public User registerUser(User user) throws ValidationException {

        List<String> validationFailures = validate(user);
        if (validationFailures.isEmpty()){
            saveUser(user);
            return user;
        } else {
            throw new ValidationException(validationFailures);
        }

    }

    @Override
    public Optional<User> findByEmail(String email){
        return userRepository.findUserByEmail(email);
    }


    @Override
    public Optional<User> findByUsernameWithoutLoggedInUser(User user){
        return userRepository.findByUsernameWithoutLoggedInUser(user.getUsername(), user.getId());
    }

    @Override
    public Optional<User> findByEmailWithoutLoggedInUser(User user){
        return userRepository.findByEmailWithoutLoggedInUser(user.getEmail(), user.getId());
    }

    @Override
    public User editUniqueUser(User user) throws ValidationException{
        List<String> validationFailures = validateEditUser(user);
        if (validationFailures.isEmpty()){
            editUser(user);
            return user;
        } else {
            throw new ValidationException(validationFailures);
        }
    }


    private List<String> validateEditUser(User user){
        Optional<User> byLogin = userRepository.findByUsernameWithoutLoggedInUser(user.getUsername(), user.getId());
        Optional<User> byEmail = userRepository.findByEmailWithoutLoggedInUser(user.getEmail(), user.getId());
        if (byLogin.isPresent() && byEmail.isPresent()){
            return Arrays.asList("Podana nazwa użytkownika jest już używana", "Podany adres e-mail jest już używany");
        } else if (byLogin.isPresent() && byEmail.isEmpty()) {
            return Arrays.asList("Podana nazwa użytkownika jest już używana");
        } else if (byLogin.isEmpty() && byEmail.isPresent()) {
            return Arrays.asList("Podany adres e-mail jest już używany");
        }
        return Collections.emptyList();
    }


    private List<String> validate(User user){
        Optional<User> byLogin = userRepository.findByUsername(user.getUsername());
        Optional<User> byEmail = userRepository.findUserByEmail(user.getEmail());
        if (byLogin.isPresent() && byEmail.isPresent()){
            return Arrays.asList("Podana nazwa użytkownika jest już używana", "Podany adres e-mail jest już używany");
        } else if (byLogin.isPresent() && byEmail.isEmpty()) {
            return Arrays.asList("Podana nazwa użytkownika jest już używana");
        } else if (byLogin.isEmpty() && byEmail.isPresent()) {
            return Arrays.asList("Podany adres e-mail jest już używany");
        }
        return Collections.emptyList();
    }

}
