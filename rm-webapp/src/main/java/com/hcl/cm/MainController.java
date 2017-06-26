package com.hcl.cm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class MainController {

    @RequestMapping("/main")
    public String main(Map<String, Object> model){
        model.put("message", "Hello");
        return "main";
    }

    @RequestMapping("/project")
    public String project(Map<String, Object> model){
        model.put("message", "Hello");
        return "/project/addProject";
    }
}
