//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.controller;

import com.example.ITSSBE.dto.UserDTO;
import com.example.ITSSBE.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping({"/user"})
public class UserController {
    @Autowired
    private IUserService userService;

    public UserController() {
    }

    @PostMapping({"/login"})
    public ResponseEntity<Object> login(@RequestBody UserDTO userDTO) {
        UserDTO confirmUserDTO = this.userService.getUserDTO(userDTO);
        return confirmUserDTO == null ? null : new ResponseEntity(confirmUserDTO, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Object> getUserInfo(@PathVariable int id) {
        return new ResponseEntity(this.userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping({"/register"})
    public ResponseEntity<Object> addUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity(this.userService.addUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping({"/role"})
    public ResponseEntity<Object> getRoles() {
        return new ResponseEntity(this.userService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping({"/staff"})
    public ResponseEntity<Object> getStaff() {
        return new ResponseEntity(this.userService.getAllStaff(), HttpStatus.OK);
    }

    @GetMapping({"/customer"})
    public ResponseEntity<Object> geTCustomer() {
        return new ResponseEntity(this.userService.getAllCustomers(), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        this.userService.deleteUser(id);
        return null;
    }

    @PatchMapping({"/"})
    public ResponseEntity<Object> updateUser(@RequestBody UserDTO user) {
        return new ResponseEntity(this.userService.updateUser(user), HttpStatus.OK);
    }
}

//package com.example.ITSSBE.controller;
//
//import com.example.ITSSBE.dto.UserDTO;
//import com.example.ITSSBE.service.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/user")
//public class UserController {
//    @Autowired
//    private IUserService userService;
//    @PostMapping("/login")
//    public ResponseEntity<Object> login(@RequestBody UserDTO userDTO){
//        UserDTO confirmUserDTO = userService.getUserDTO( userDTO);
//        if (confirmUserDTO == null) return null;
//        return new ResponseEntity<>(confirmUserDTO, HttpStatus.OK);
//    }
//    @GetMapping("/{id}")//yes
//    public ResponseEntity<Object> getUserInfo(@PathVariable int id){
//        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
//    }
//    @PostMapping("/register")//yes
//    public ResponseEntity<Object> addUser( @RequestBody UserDTO userDTO){
//        return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.CREATED);
//    }
//    @GetMapping("/role")
//    public ResponseEntity<Object> getRoles(){
//        return new ResponseEntity<>( userService.getAllRoles(), HttpStatus.OK);
//    }
//    @GetMapping("/staff")//yes
//    public ResponseEntity<Object> getStaff(){
//        return new ResponseEntity<>( userService.getAllStaff(), HttpStatus.OK);
//    }
//    @GetMapping("/customer")//yes
//    public ResponseEntity<Object> geTCustomer(){
//        return new ResponseEntity<>( userService.getAllCustomers(), HttpStatus.OK);
//    }
//    @DeleteMapping("/{id}")//yes
//    public ResponseEntity<Object> deleteUser(@PathVariable int id){
//        userService.deleteUser(id);
//        return null;
//    }
//    @PatchMapping("/")//yes
//    public ResponseEntity<Object> updateUser( @RequestBody UserDTO user){
//        return new ResponseEntity<>(userService.updateUser(user ), HttpStatus.OK);
//    }
//}
