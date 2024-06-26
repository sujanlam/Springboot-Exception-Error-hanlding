package com.excptn.service;

import com.excptn.exceptions.UserNotFoundException;
import com.excptn.dto.UserRequest;
import com.excptn.entity.User;
import com.excptn.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest) {
        User user = User.build(0, userRequest.getName(), userRequest.getEmail(),
                userRequest.getMobile(), userRequest.getGender(),
                userRequest.getAge(), userRequest.getNationality());
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getOneUserById(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);
        if(user != null){
            return user;
        }else {
            throw new UserNotFoundException("User not found with this: "+id);
        }

    }
}
