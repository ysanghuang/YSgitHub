package com.asiainfo.springboot_helloworld_quick.controller;

import com.asiainfo.springboot_helloworld_quick.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class HelloController {

    @Autowired
    private Person person;

    @RequestMapping("/hello")
    public Person hello(){
        return person;
    }
}
