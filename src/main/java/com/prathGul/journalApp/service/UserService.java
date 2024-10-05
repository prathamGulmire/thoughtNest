package com.prathGul.journalApp.service;

import com.prathGul.journalApp.entity.JournalEntry;
import com.prathGul.journalApp.entity.User;
import com.prathGul.journalApp.repository.JournalEntryRepository;
import com.prathGul.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
//    no need to above create logger instance if u r putting @slf4j annotaion to the class.
//    u can directly use "log" instance which is inbuild created by slf4j.

    public boolean saveNewUser(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(List.of("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            log.error("Error occurred for {}: ", user.getUserName());
//            log.warn("hahahahahaha!!");
//            log.info("hahahahahaha!!");
//            log.trace("hahahahahaha!!");
            log.debug("hehehehehe!!");
            return false;
        }
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> getEntryById(ObjectId id){
        return userRepository.findById(id);
    }

    public String deleteEntryById(ObjectId id){
        userRepository.deleteById(id);
        return "Deleted Successfully!!";
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

//    public boolean updateEntryById(ObjectId id){
//        journalEntryRepository.
//    }
}
