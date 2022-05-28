package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.domain.Vuelo;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/vuelos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UserController {

    private final UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User>saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/vuelos/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));

    }

}
