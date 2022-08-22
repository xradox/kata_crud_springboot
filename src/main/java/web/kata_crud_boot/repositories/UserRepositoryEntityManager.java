package web.kata_crud_boot.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.kata_crud_boot.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepositoryEntityManager {

    @PersistenceContext
    private EntityManager manager;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        TypedQuery<User> list = manager.createQuery("SELECT u from User u", User.class);
        return list.getResultList();
    }

    @Transactional(readOnly = true)
    public User getUser(int id) {
        return  manager.find(User.class, id);
    }

    @Transactional
    public void saveUser(User user) {
        manager.persist(user);
    }

    @Transactional
    public void updateUser(User updated) {
        manager.merge(updated);
    }

    @Transactional
    public void deleteUser(int id) {
        User user = manager.find(User.class, id);
        manager.remove(user);
    }
}
