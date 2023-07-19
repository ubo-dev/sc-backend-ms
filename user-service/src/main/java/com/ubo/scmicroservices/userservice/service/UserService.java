package com.ubo.scmicroservices.userservice.service;

import com.ubo.scmicroservices.userservice.constants.ScConstants;
import com.ubo.scmicroservices.userservice.exception.UserNotFoundException;
import com.ubo.scmicroservices.userservice.model.entity.User;
import com.ubo.scmicroservices.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void registerUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy(ScConstants.ADMIN_ROLE);
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

    public User updateUser(User userObject, User user)
    {
        userObject.setName(user.getName());
        userObject.setLastName(user.getLastName());
        userObject.setEmail(user.getEmail());
        userObject.setPhoneNumber(user.getPhoneNumber());
        userObject.setBirthDate(user.getBirthDate());
        userObject.setUpdatedAt(LocalDateTime.now());
        userObject.setUpdatedBy(ScConstants.USER_ROLE);

        return userRepository.save(userObject);


    }

    public User findUserById(Long id)
    {
        Optional<User> optional = userRepository.findById(id);

        if (optional.isPresent())
        {
            log.info("User with id:" + id + " is listed.");
            return optional.get();
        }

        throw new UserNotFoundException("User not found with ID: " + id);
    }
}
