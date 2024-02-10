package edu.eci.ieti.ProyectoIntegrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.eci.ieti.ProyectoIntegrador.repository.User;
import edu.eci.ieti.ProyectoIntegrador.repository.UserDTO;
import edu.eci.ieti.ProyectoIntegrador.service.UserService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users/")
public class UserController {

    private final UserService usersService;

    public UserController(@Autowired UserService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
        User newUser = usersService.save(new User(user));
        URI createdUserUri = URI.create("/v1/users/" + newUser.getId());
        return ResponseEntity.created(createdUserUri).body(newUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> uList = usersService.all();
        return ResponseEntity.ok(uList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable("id") String id) throws Exception{
        Optional<User> user = usersService.findById(id);
        System.out.println(user.getClass());
        if(!user.isPresent()){
            throw new Exception("No user with the id: " + id);
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserDTO user, @PathVariable String id) throws Exception{
        User usr = usersService.findById(id).orElseThrow(() -> new Exception("No user with the id: " + id));
        usr.update(user);
        return ResponseEntity.ok(usersService.save(usr));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) throws Exception{
        Optional<User> usr = usersService.findById(id);
        if(!usr.isPresent()){
            throw new Exception("No user with the id: " + id);
        }
        usersService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}