package web.kata_crud_boot.services;

import org.springframework.stereotype.Service;
import web.kata_crud_boot.models.User;
import web.kata_crud_boot.repositories.UserRepository;
import web.kata_crud_boot.repositories.UserRepositoryEntityManager;


import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    private final UserRepositoryEntityManager entityManager;

    public UserService(UserRepository repository, UserRepositoryEntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }

    public List<User> getAllUsers() {
        return entityManager.getAllUsers();
    }

    public User getUser(int id) {
        return  entityManager.getUser(id);
    }

    public void saveUser(User user) {
        entityManager.saveUser(user);
    }

    public void updateUser(User updated) {
        entityManager.updateUser(updated);
    }

    public void deleteUser(int id) {
        entityManager.deleteUser(id);
    }
}
