package edu.eci.ieti.ProyectoIntegrador.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.eci.ieti.ProyectoIntegrador.repository.User;

@Service
public class UserServiceMap implements UserService{
    private Map<String,User> users = new HashMap<>();
    private List<User> uList = new ArrayList<>();

    @Override
    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        User doomie = users.get(id);
        return Optional.ofNullable(doomie);
    }

    @Override
    public List<User> all() {
        for(User u: users.values()){
            uList.add(u);
        }
        return uList;
    }

    @Override
    public void deleteById(String id) throws Exception {
        if(users.get(id) == null){
            throw new Exception("No user found with the id " + id);
        }
        users.remove(id);
    }

    @Override
    public User update(User user, String userId) throws Exception {
        if(users.get(userId) == null){
            throw new Exception("No user found with the id " + userId);
        }
        users.put(userId, user);
        return users.get(userId);
    }
}
