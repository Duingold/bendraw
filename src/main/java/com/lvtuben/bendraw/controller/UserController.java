package com.lvtuben.bendraw.controller;

import com.lvtuben.bendraw.common.ApiResult;
import com.lvtuben.bendraw.domain.User;
import com.lvtuben.bendraw.request.TestTimeParamRequest;
import com.lvtuben.bendraw.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.List;


@Controller("user/")
@Validated
@Api(description = "用户控制器")
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

    @PostMapping(value = "finduser/{sid}")
    public String findUser(@PathVariable Integer sid, ModelMap model) {
        User user = new User();
        user.setSid(sid);
        user =userService.getUser(user).get(0);
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("userlist")
    public String findUser( ModelMap model) {
        model.addAttribute("user", userService.getUser(new User()));
        return "idex";
    }

    @PostMapping("/test")
    @ApiOperation("测试自定义时间校验器")
    @ApiResponse(code = 200,message = "响应数据",response = ApiResult.class)
    public @ResponseBody ApiResult testValidator(@RequestBody @Valid @ApiParam TestTimeParamRequest request){

        return new ApiResult("200", "成功");
    }
}
