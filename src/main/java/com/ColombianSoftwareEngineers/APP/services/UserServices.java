package com.ColombianSoftwareEngineers.APP.services;

import com.ColombianSoftwareEngineers.APP.entities.User;
import com.ColombianSoftwareEngineers.APP.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServices {
    UserRepository repository;

    public UserServices(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User newUser){
        return this.repository.save(newUser);
    }

    public User findByAuth0id(String auth0id){
        return this.repository.findByAuth0idUser(auth0id);
    }
    public User findByEmailUser(String email) { return this.repository.findByEmailUser(email); }

    public User getOrCreateUser(Map<String, Object> userData){
        String auth0id = (String) userData.get("sub");
        User user = findByAuth0id(auth0id);
        if(user == null){
            String email = (String) userData.get("email");
            String name = (String) userData.get("nickname");
            String image = (String) userData.get("picture");
            User newUser = new User(name=name, email=email, image=image, auth0id=auth0id);
            return createUser(newUser);
        }
        return user;
    }
}
