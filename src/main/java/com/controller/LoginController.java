package com.controller;

import com.config.LoginHandlerInterceptor;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session,HttpSession session1){
        if (userService.login(username,password)){
            System.out.println(username + " " + password + " ");
            session.setAttribute("loginUser",username);

            String userType=userService.getUserById(username).getUserType();
            System.out.println("用户类型:"+userType);
            if (userType.equals("管理员")){
                session1.setAttribute("userType","admin");
            }
            else if (userType.equals("普通用户")){
                session1.setAttribute("userType","user");
            }
            return "redirect:/main.html";
        }
        else {
            model.addAttribute("msg","用户名或者密码错误！");
            return "index";
        }
    }

    //注销，返回登陆页面
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }

    //返回登陆界面
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }

    //注册页面
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "/register";
    }

    //注册
    @GetMapping("/userRegister")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("password2") String password2, Model model){
        System.out.println(username + "=" + password + "=" );
        if (!password.equals(password2)){
            model.addAttribute("pad","两次密码不相同！");
            return "register";
        }
        else{
            userService.addUser(username, password);
            model.addAttribute("succ","注册成功，请登录！");
            return "index";
        }

    }

}
