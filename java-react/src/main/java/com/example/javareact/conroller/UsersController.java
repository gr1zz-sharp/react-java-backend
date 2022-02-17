package com.example.javareact.conroller;

import com.example.javareact.entity.Users;
import com.example.javareact.links.UserLinks;
import com.example.javareact.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UsersController {

    @Autowired
    UsersService usersService;


    @GetMapping(path = UserLinks.LIST_USERS)
    public ResponseEntity<?> listUsers() {
        List<Users> resource = usersService.getUsers();
        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = UserLinks.ADD_USER)
    public ResponseEntity<?> saveUser(@RequestBody Users user) {
        Users resource = usersService.saveUser(user);
        return ResponseEntity.ok(resource);
    }
}
