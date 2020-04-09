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



    public List<User> fetchUsers(){
        return userRepo.findAll();
    }


    public void save(User user){
        userRepo.save(user);
    }
}
