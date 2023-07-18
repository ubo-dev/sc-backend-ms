package com.ubo.scmicroservices.userservice.service;

import com.ubo.scmicroservices.userservice.model.entity.User;
import com.ubo.scmicroservices.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void registerUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }

    public Long deleteUserById(Long id)
    {
        userRepository.deleteById(id);

        return id;
    }

}
