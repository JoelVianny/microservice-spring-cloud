package com.example.eurekauser.services;

import com.example.eurekauser.entities.User;
import com.example.eurekauser.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
 private  final UserRepository userRepository;


        public List<User> getAllUsers() {
            return userRepository.findAll();
        }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found"));
    }

        public User saveUser(User user) {
          return   userRepository.save(user);
        }

        public User  updateUser(long id ,User user) {
            log.info(user.toString());
            User foundUser = getUserById(id);
            foundUser.setName(user.getName());
            foundUser.setEmail(user.getEmail());
            log.info(foundUser.toString());
            return  userRepository.save(foundUser);


        }

        public String deleteUser(long id){
            userRepository.delete(getUserById(id));
            return  " User deleted";
        }








}
