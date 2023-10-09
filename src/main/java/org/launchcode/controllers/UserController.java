package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {
private String error = "Passwords do not match.";
    @GetMapping("")
    public String displayAddUserForm(){
         return "/user/add";
    }
    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
    model.addAttribute("user",user);

    if(!user.getPassword().equals(verify)){
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("verify", verify);
        model.addAttribute("error", error);
        return "/user/add";
    }
    return "user/index";
    }
}
