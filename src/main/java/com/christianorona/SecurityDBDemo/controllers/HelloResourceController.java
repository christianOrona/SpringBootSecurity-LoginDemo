package com.christianorona.SecurityDBDemo.controllers;

import com.christianorona.SecurityDBDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rest/hello")
@RestController
public class HelloResourceController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public @ResponseBody List    hello (){
        return userRepository.findAll();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/secured/all")
    public String securedHello(){
        return "Secured Hello There";
    }
    @GetMapping("/secured/alternate")
    public String alternate() {
        return "alternate";
    }

}
