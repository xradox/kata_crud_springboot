package web.kata_crud_boot.services;

import web.kata_crud_boot.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(int id);

    void saveUser(User user);

    void updateUser(User updated);

    void deleteUser(int id);
}
