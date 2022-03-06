package com.kkb.ggf.controller;

import com.kkb.ggf.bean.User;
import com.kkb.ggf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("all")
    public String getAll(Model model){
        List<User> list = userService.getAll();
        model.addAttribute("users",list);
        // thymeleaf,默认视图解析为 classpath:/templates/*.html
        return "user";
    }

}
