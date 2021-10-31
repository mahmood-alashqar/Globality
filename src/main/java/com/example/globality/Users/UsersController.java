package com.example.globality.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/")
    public String homePage(){
        return "logIn";
    }
    @GetMapping("/users")
    public String getUsers(Model model)
    {
        model.addAttribute("users",usersRepository.findAll());
        return "usersProfile";
    }
    @GetMapping("/feeds")
    public String getFeeds (Model model){

        model.addAttribute("followinguser",usersRepository.findAll());

        return "feeds";
    }
    @GetMapping("/signup")
    public String getSignupPage(){
        return "signup";
    }
    @GetMapping("/login")
    public String getLoginPge(){
//        model.addAttribute("userInfo",userRepository.findAll());
        return "logIn";
    }
}
