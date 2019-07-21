package com.backend.projeto.controller;


import com.backend.projeto.entity.User;
import com.backend.projeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> listUser() {
        return userRepository.findAll();
    }
}
