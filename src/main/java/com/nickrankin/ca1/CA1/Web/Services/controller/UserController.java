package com.nickrankin.ca1.CA1.Web.Services.controller;

import com.nickrankin.ca1.CA1.Web.Services.exception.UserNotFoundException;
import com.nickrankin.ca1.CA1.Web.Services.model.User;
import com.nickrankin.ca1.CA1.Web.Services.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UsersRepository repo;

    private Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UsersRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/users/all")
    List<User> users() {
        return this.repo.findAll();
    };
    @PostMapping("/users/save")
    User newUser(@RequestBody User user) {
        return repo.save(user);
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User user, @PathVariable Long id) {
        return repo.findById(id).map(currentUser -> {
            currentUser.setName(user.getName());
            currentUser.setAddress(user.getAddress());
            currentUser.setPin(user.getPin());

            return repo.save(currentUser);
        }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repo.deleteById(id);
    }



    @PostMapping("users/login")
    ResponseEntity login(@RequestParam String pps_no, @RequestParam String pin) {
        log.info("Logging in with " + pps_no + " PIN: " + pin);

        List<User> foundUsers = repo.findUserByPpsNumber(pps_no);

        if(foundUsers.isEmpty()) {
            log.error("User not found with pps no: " + pps_no);
            return new ResponseEntity<String>("Not logged in!", HttpStatus.NOT_FOUND);
        } else {
            User user = foundUsers.getFirst();
            log.info("Found user " + user.getName());

            log.error(user.toString());

            if(user.getPin().equals(pin)) {
                return new ResponseEntity<User>(user, HttpStatus.OK);

            } else {
                return new ResponseEntity<String>("Error: Not logged in!", HttpStatus.UNAUTHORIZED);
            }
        }
    }

    @GetMapping("/users/{pps_no}")
    ResponseEntity<User> user(@PathVariable String pps_no) {
        List<User> users = repo.findUserByPpsNumber(pps_no);

        if(users.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<User>(users.getFirst(), HttpStatus.OK);

        }
    }
}

@ControllerAdvice
class UserNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(UserNotFoundException ex) {
        return ex.getMessage();
    }
}
