package web.kata_crud_boot.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.kata_crud_boot.DAO.UserDAO;
import web.kata_crud_boot.models.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional(readOnly = true)
    public User getUser(int id) {
        return  userDAO.getUser(id);
    }

    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Transactional
    public void updateUser(User updated) {
        userDAO.updateUser(updated);
    }

    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
