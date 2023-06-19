package ru.arromaev.task311.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.arromaev.task311.model.User;
import ru.arromaev.task311.service.UserService;


@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String welcome() {
        return "index";
    }

    @GetMapping(value = "users/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping(value = "users/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "users")
    public String allUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        System.out.println(userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "users/edit/{id}")
    public String editUser(Model model, @PathVariable("id") int id){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "users/edit")
    public String edit(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/";
    }

    @GetMapping("users/delete")
    public String deleteUserById(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
