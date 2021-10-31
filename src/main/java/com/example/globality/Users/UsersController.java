package com.example.globality.Users;

import com.example.globality.Infrastructure.UserDetailsImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UserDetailsImplementation userDetailsImplementation;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<UsersModel> users = usersRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("userInfo", new UsersModel());
        return "users";
    }
//    @GetMapping("/users")
//    public String getUsers(Model model) {
//        model.addAttribute("users", usersRepository.findAll());
//        return "usersProfile";
//    }

    @GetMapping("/feeds")
    public String getFeeds(Model model) {

        model.addAttribute("followinguser", usersRepository.findAll());

        return "feeds";
    }

    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup";
    }

    @GetMapping("/login")
    public String getLoginPge() {
//        model.addAttribute("userInfo",userRepository.findAll());
        return "logIn";
    }

    @GetMapping("/search/{username}")
    public String afterSearch(@PathVariable(value = "username") String username, Model model) {
        UsersModel usersModel = usersRepository.findUsersModelByUserName(username);
        model.addAttribute("userInfo", usersModel);
        return "searchResult";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable("id") Integer id) {
        UsersModel usersModel = usersRepository.getUsersModelById(id.longValue());
        model.addAttribute("userInfo", usersModel);
        return "edit";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    public RedirectView updateUser(RedirectAttributes redirectAttributes, @PathVariable("id") Long id, @ModelAttribute UsersModel userInfo) {
        userDetailsImplementation.updateUser(id, userInfo);
        String message = (userInfo.isActive() ? "Updated " : "Deleted ") + " user <b>" + userInfo.getUsername() + " " + userInfo.getEmail() + "</b> ✨." + userInfo.getPhoneNumber();
        RedirectView redirectView = new RedirectView("/", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }

}