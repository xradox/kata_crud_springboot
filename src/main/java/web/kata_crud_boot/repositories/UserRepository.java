package web.kata_crud_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.kata_crud_boot.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
