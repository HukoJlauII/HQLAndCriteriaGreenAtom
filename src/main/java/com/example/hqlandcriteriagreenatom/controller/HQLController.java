package com.example.hqlandcriteriagreenatom.controller;

import com.example.hqlandcriteriagreenatom.dao.impl.UserDAOImplCriteria;
import com.example.hqlandcriteriagreenatom.dao.impl.UserDAOImplHQL;
import com.example.hqlandcriteriagreenatom.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description of the class or method
 *
 * @author HukoJlauII
 */
@RestController
@RequestMapping("/hql/users")
@RequiredArgsConstructor
public class HQLController {

    private UserDAOImplHQL userDAO;


    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userDAO.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userDAO.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userDAO.findById(id);
        if (existingUser != null) {
            user.setId(existingUser.getId());
            userDAO.update(user);
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        User user = userDAO.findById(id);
        if (user != null) {
            userDAO.delete(user);
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

