package de.ait.app1.services.impl;

import de.ait.app1.models.User;
import de.ait.app1.repositories.UserRepository;
import de.ait.app1.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    // dependency injection
    public final UserRepository userRepository; // зависимость на UserRepository

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // бизнес-логика
    @Override
    public User addUser(String email, String password) {
        // валидация email
        if(email == null || email == "" || email.equals(" ")) {
            throw new IllegalArgumentException("Email can't be empty");
        }
        // валидация password
        if(password == null || password == "" || password.equals(" ")) {
            throw new IllegalArgumentException("Password can't be empty");
        }

        // проверить, что такого пользователя еще нет
        User existedUser = userRepository.findByEmail(email);
        if(existedUser != null) {
            throw new IllegalArgumentException("User already exists.");
        }

        User user = new User(email, password);

        userRepository.save(user);

        return user;

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}