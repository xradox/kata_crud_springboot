package web.kata_crud_boot;


import org.springframework.stereotype.Component;
import web.kata_crud_boot.models.User;
import web.kata_crud_boot.services.UserServiceImpl;

import javax.annotation.PostConstruct;

@Component
public class DbRecordsInit {

    private final UserServiceImpl service;

    public DbRecordsInit(UserServiceImpl service) {
        this.service = service;
    }

    @PostConstruct
    public void addDataToDb() {
        for (int i = 0; i < 5; i++) {
            service.saveUser(new User("Name" + i, "Lastname" + i, 1999 + i));
        }
    }
}
