package com.dailpe.application.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dailpe.application.Dtos.CreateUser;
import com.dailpe.application.Dtos.DeleteUser;
import com.dailpe.application.Dtos.UpdateUser;
import com.dailpe.application.Models.User;
import com.dailpe.application.Services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserControllers {

    private final UserService userService;

    @PostMapping("/create_user")
    public ResponseEntity<String> createUser(@Validated @RequestBody CreateUser user){
        return userService.createUser(user);
    }

    @GetMapping("/get_users")
    public ResponseEntity<List<User>> getUsers(
        @RequestParam(value = "pageNumber",defaultValue = "1",required = false) int pageNumber,
        @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize

    ){
        return userService.getUsers(pageNumber,pageSize);
    }

    @PostMapping("/update_user")
    public ResponseEntity<String> updateUser(@RequestBody UpdateUser user){
        return ResponseEntity.ok().body("Data Intrepation not clear. Give some sample input data");
    }

    @PostMapping("/delete_user")
    public ResponseEntity<String> userDelete(@RequestBody DeleteUser deleteUser){
        return userService.deleteUser(deleteUser);
    }
}
