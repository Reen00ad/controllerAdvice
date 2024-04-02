package com.example.capstone2.Controller;

import com.example.capstone2.ApiResponce.ApiResponse;
import com.example.capstone2.Model.User;
import com.example.capstone2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    Logger logger= LoggerFactory.getLogger(UserController.class);

    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        logger.info("inside get all user");

        return ResponseEntity.status(200).body(userService.getAllUser());
    }


    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user){

        logger.info("inside add user");

        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user) {
        logger.info("inside update user");
        userService.updateUser(id, user);

        return ResponseEntity.status(200).body(new ApiResponse("user updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        logger.info("inside delete user");
        userService.deleteUser(id);

        return ResponseEntity.status(200).body(new ApiResponse("user deleted"));

    }


}
