package com.module.service;


import com.module.model.User;
import com.module.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @PostConstruct
    public void initUsers(){
        userRepo.saveAll(Stream.of(new User("lapasta","mits0s200efta@hotmail.com"),
                                   new User("mpoufos","aaaaa@bbb.com"))
                                   .collect(Collectors.toList()));
    }
}
