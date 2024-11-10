package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("add")
    public String displayAddUserForm(Model model){
        model.addAttribute("title", "Add user");
        return "user/add";
    }
    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if (verify.equals(user.getPassword())){
            model.addAttribute("message", "Welcome, " + user.getUserName() + "!");
            return "user/index";
        }
        else{
            model.addAttribute("error", "Passwords do not match!");
            model.addAttribute("username", user.getUserName());
            model.addAttribute("email", user.getEmail());
            return "user/add";
        }
    }
}
