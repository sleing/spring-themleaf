package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/finduser")
    public String finduser(Model model){
        List<User> users = userService.findusers();
        model.addAttribute("users", users);
        return "emp/userlist";
    }
    @RequestMapping("/deleteuser")
    public String deleteuser(@RequestParam("id") Integer eid){
        userService.deleteuser(eid);
        return "emp/userlist";
    }
    @RequestMapping("/toUpdateuser")
    public String toUpdateuser(@RequestParam("username") String username,Model model){
        User user = userService.getUserById(username);
        model.addAttribute("user", user);
        return "emp/userupdate";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/finduser";
    }

}
