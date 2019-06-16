package com.lvtuben.bendraw.api.v1;

import com.lvtuben.bendraw.domain.User;
import com.lvtuben.bendraw.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class ApiV1UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/user/{sid}")
    public List<User> getUser(@PathVariable Integer sid) {
        User user = new User();
        user.setSid(sid);
        return userService.getUser(user);
    }
}
