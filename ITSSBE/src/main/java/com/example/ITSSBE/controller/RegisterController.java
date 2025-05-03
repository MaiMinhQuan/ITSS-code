//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.controller;

import com.example.ITSSBE.dto.RegisterDTO;
import com.example.ITSSBE.service.IRegisterService;
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
@RequestMapping({"/register"})
public class RegisterController {
    @Autowired
    private IRegisterService registerService;

    public RegisterController() {
    }

    @GetMapping({"/"})
    public ResponseEntity<Object> getRegisters() {
        return new ResponseEntity(this.registerService.getRegisters(), HttpStatus.OK);
    }

    @PostMapping({""})
    public ResponseEntity<Object> addRegister(@RequestBody RegisterDTO registerDTO) {
        return new ResponseEntity(this.registerService.addRegister(registerDTO), HttpStatus.CREATED);
    }

    @PatchMapping({"/{id}"})
    public ResponseEntity<Object> editRegister(@RequestBody RegisterDTO registerDTO, @PathVariable int id) {
        return new ResponseEntity(this.registerService.changeRegister(registerDTO, id), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Object> getRegister(@PathVariable int id) {
        return new ResponseEntity(this.registerService.getRegister(id), HttpStatus.OK);
    }

    @GetMapping({"/customer/{customerId}"})
    public ResponseEntity<Object> getRegisterByCustomerId(@PathVariable int customerId) {
        return new ResponseEntity(this.registerService.getRegisterByCustomerId(customerId), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Object> deleteRegister(@PathVariable int id) {
        this.registerService.deleteRegister(id);
        return null;
    }
}

//package com.example.ITSSBE.controller;
//
//import com.example.ITSSBE.dto.RegisterDTO;
//import com.example.ITSSBE.service.IRegisterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/register")
//public class RegisterController {
//    @Autowired
//    private IRegisterService registerService;
//    @GetMapping("/")
//    public ResponseEntity<Object> getRegisters(){
//        return new ResponseEntity<>(registerService.getRegisters(), HttpStatus.OK);
//    }
//    @PostMapping("")
//    public ResponseEntity<Object> addRegister(@RequestBody RegisterDTO registerDTO){
//        return new ResponseEntity<>( registerService.addRegister( registerDTO), HttpStatus.CREATED);
//    }
//    @PatchMapping("/{id}")
//    public ResponseEntity<Object> editRegister(@RequestBody RegisterDTO registerDTO, @PathVariable int id){
//        return new ResponseEntity<>(registerService.changeRegister( registerDTO, id), HttpStatus.OK);
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getRegister(@PathVariable int id){
//        return new ResponseEntity<>(registerService.getRegister(id), HttpStatus.OK);
//    }
//    @GetMapping("/customer/{customerId}")//yes
//    public ResponseEntity<Object> getRegisterByCustomerId(@PathVariable int customerId){
//        return new ResponseEntity<>(registerService.getRegisterByCustomerId(customerId), HttpStatus.OK);
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteRegister( @PathVariable int id){
//        registerService.deleteRegister(id);
//        return null;
//    }
//
//}
