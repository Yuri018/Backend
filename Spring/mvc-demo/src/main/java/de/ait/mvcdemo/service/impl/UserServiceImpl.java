package de.ait.mvcdemo.service.impl;

import de.ait.mvcdemo.model.User;
import de.ait.mvcdemo.repository.UserRepository;
import de.ait.mvcdemo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(String name, String email, String password) {
        User user = new User(name, email, password);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
