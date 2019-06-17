package com.dhu.mylibrary.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dhu.mylibrary.entity.User;
import com.dhu.mylibrary.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huihui
 * @since 2019-06-01
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService service;
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("index")
    public ModelAndView index(){
        ModelAndView mv =new ModelAndView("index");
        return mv;
    }
    @GetMapping("login")
    public ModelAndView login(){
        ModelAndView mv =new ModelAndView("login");
        return mv;
    }
    @PostMapping("login")
    public ModelAndView login_post(String username,String password){
        ModelAndView mv =new ModelAndView("login");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("userName",username);
        wrapper.eq("password",password);
        User user = service.getOne(wrapper);
        if(user != null){
            mv.setViewName("index");
        }
        return mv;
    }
    @GetMapping("pass")
    public ModelAndView pass(){
        ModelAndView mv =new ModelAndView("pass");
        return mv;
    }
    @GetMapping("personnew")
    public ModelAndView person(){
        ModelAndView mv =new ModelAndView("personnew");
        return mv;
    }
    @PostMapping("changepass")
    public String changePass(String newpass,Integer userId){
        service.changePass(newpass,userId);
        return "true";
    }

    @PostMapping("signup")
    public void signup(String userName,String password)
    {
        service.signup(userName,password);
    }

}
