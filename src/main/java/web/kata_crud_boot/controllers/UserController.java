package web.kata_crud_boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.kata_crud_boot.models.User;
import web.kata_crud_boot.services.UserServiceImpl;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "pages/index";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable int id, Model model) {
        model.addAttribute("user", service.getUser(id));
        return "pages/userpage";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("newUser") User newUser) {
        return "pages/new";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable int id, Model model) {
        model.addAttribute("user", service.getUser(id));
        return "pages/edit";
    }

    @PostMapping
    public String saveUser(User user) {
        service.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute User updated) {
        service.updateUser(updated);
        return "redirect:/users";
    }
}
