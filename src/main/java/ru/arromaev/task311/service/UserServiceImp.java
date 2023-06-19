package ru.arromaev.task311.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.arromaev.task311.model.User;
import ru.arromaev.task311.repository.UserRepository;


import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public void editUser(User user) {
        userRepository.editUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }
}
