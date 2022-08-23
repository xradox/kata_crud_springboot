package web.kata_crud_boot.DAO;

import web.kata_crud_boot.models.User;
import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();



    User getUser(int id);


    void saveUser(User user);


    void updateUser(User updated);

    void deleteUser(int id);
}
