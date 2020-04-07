package com.module.service;


import com.module.model.Email;
import com.module.model.User;
import com.module.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

//    @PostConstruct
//    public void initUsers(){
//        User user1=new User("mits0s200efta@hotmail.com");
//        User user2=new User("aaaaa@bbb.com");
//        user1.setEmails(Arrays.asList(new Email("dasda@dad.com","dada","dasds")));
//
//        userRepo.saveAll(Stream.of(user1,user2).collect(Collectors.toList()));
//
//
//
//    }

    public List<User> fetchUsers(){
        return userRepo.findAll();
    }


}
