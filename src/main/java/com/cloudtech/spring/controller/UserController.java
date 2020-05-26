package com.cloudtech.spring.controller;

import com.cloudtech.spring.model.User;
import com.cloudtech.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/users")
    ResponseEntity<List<User>> getAll() {
        List<User> result = service.findAll();
        if (result == null || result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("/admin/{id}")
    ResponseEntity<Optional<User>> getById(@Valid @PathVariable("id") Long id) {
        Optional<User> result = null;
        try {
            result = service.findById(id);
        } catch (ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
        }
        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("/login/{param0}")
    ResponseEntity<Optional<User>> getByPrice(@Valid @PathVariable("param0") String param0) {
        Optional<User> result = null;
        try {
            result = service.findByUsername(param0);
        } catch (ChangeSetPersister.NotFoundException e) {
            e.printStackTrace();
        }
        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @PostMapping("/register")
    ResponseEntity<User> create(@Valid @RequestBody User object) {
        User result = service.insert(object);
        if (result == null) {
            return ResponseEntity.badRequest().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
            return ResponseEntity.created(uri).body(result);
        }
    }

    @PatchMapping("/update/{id}")
    ResponseEntity<User> update(@RequestBody User object, @PathVariable Long id) {
        User result = service.update(object, id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @PutMapping("/update")
    ResponseEntity<User> update(@Valid @RequestBody User object) {
        User result = service.update(object);
        if (result == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity delete(@Valid @PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    ResponseEntity<Object> delete(@Valid @RequestBody User object) {
        service.delete(object);
        return ResponseEntity.ok().build();
    }
}