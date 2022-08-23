package web.kata_crud_boot.DAO;

import org.springframework.stereotype.Repository;

import web.kata_crud_boot.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager manager;


    public List<User> getAllUsers() {
        TypedQuery<User> list = manager.createQuery("SELECT u from User u", User.class);
        return list.getResultList();
    }


    public User getUser(int id) {
        return  manager.find(User.class, id);
    }


    public void saveUser(User user) {
        manager.persist(user);
    }


    public void updateUser(User updated) {
        manager.merge(updated);
    }

    public void deleteUser(int id) {
        User user = manager.find(User.class, id);
        manager.remove(user);
    }
}
