package com.example.javacrudapi.controller;

import com.example.javacrudapi.entity.UserEntity;
import com.example.javacrudapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController{

    private UserRepository userRepository;

    @GetMapping()
    public Iterable<UserEntity> getAllUsers() {
        return this.userRepository.findAll();
    }

    // The 'optional' word simply means that we can return null if the requested user does not exist.
    @GetMapping(value = "/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Long id){
        return this.userRepository.findById(id);
    }

    @PostMapping()
    public void postUser(@RequestBody UserEntity user){
        this.userRepository.save(user);
    }

    @PutMapping(value = "/{id}")
    public void updateUser(@RequestBody UserEntity user, @PathVariable Long id){
        Optional<UserEntity> oldUser = this.userRepository.findById(id);
        if(oldUser.isPresent()){
            UserEntity newUser = oldUser.get();
            newUser.setEmail(user.getEmail());
            newUser.setPromo(user.getPromo());
            newUser.setUsername(user.getUsername());
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            // on ne s'occupe pas des mobilités ici
            this.userRepository.save(newUser);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id){
        this.userRepository.deleteById(id);
        // improvement : also delete all mobilities related to this user
    }
}
