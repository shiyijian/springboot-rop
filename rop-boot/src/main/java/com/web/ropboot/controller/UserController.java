package com.web.ropboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userController")
public class UserController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
