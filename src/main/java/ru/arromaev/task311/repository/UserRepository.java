package ru.arromaev.task311.repository;

import ru.arromaev.task311.model.User;
import java.util.List;

public interface UserRepository {

    void addUser(User user);

    List<User> getAllUsers();

    void editUser(User user);

    void deleteUser(int id);

    User getUserById(int id);
}
