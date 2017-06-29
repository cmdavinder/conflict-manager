package com.hcl.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String main(Map<String, Object> model){
        return "main";
    }
}
