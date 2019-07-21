package com.backend.projeto.config;

import com.backend.projeto.entity.User;
import com.backend.projeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<User> user = userRepository.findAll();

        if(user.isEmpty()){
            this.createUser("Joanes","joanestecnico@gmail.com","joanes123");
            this.createUser("joseane","joseane.tecst@gmail.com","joseane123");
        }
    }
    public void createUser(String name, String email, String password){
        userRepository.save(new User(name, email, password));
    }

}
