package com.lvtuben.bendraw.controller;

import com.lvtuben.bendraw.domain.User;
import com.lvtuben.bendraw.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;


@Controller
@RequestMapping(value = "user/", method = RequestMethod.GET)
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getUser/{sid}")
    @ResponseBody
    public List<User> GetUser(@PathVariable @Max(value = 100,message = "最大100") Integer sid) {
        User user = new User();
        user.setSid(sid);
        return userService.getUser(user);
    }


    @GetMapping("del/{sid}")
    @ResponseBody
    public Integer deleteUser(@PathVariable Integer sid) {
        return userService.deleteUser(sid);
    }

    @GetMapping("finduser/{sid}")
    public String findUser(@PathVariable Integer sid, ModelMap model) {
        User user = new User();
        user.setSid(sid);
        user =userService.getUser(user).get(0);
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping("userlist")
    public String findUser( ModelMap model) {
        model.addAttribute("user", userService.getUser(new User()));
        return "idex";
    }
}
