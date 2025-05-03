//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.controller;

import com.example.ITSSBE.dto.ProcessDTO;
import com.example.ITSSBE.service.IProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping({"/process"})
public class ProcessController {
    @Autowired
    private IProcessService processService;

    public ProcessController() {
    }

    @GetMapping({"/"})
    public ResponseEntity<Object> getAllProcess() {
        return new ResponseEntity(this.processService.getAllProcess(), HttpStatus.OK);
    }

    @PostMapping({""})
    public ResponseEntity<Object> addProcess(@RequestBody ProcessDTO processDTO) {
        return new ResponseEntity(this.processService.addProcess(processDTO), HttpStatus.CREATED);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Object> getProcessByRegisterId(@PathVariable int id) {
        return new ResponseEntity(this.processService.getProcessByRegisterId(id), HttpStatus.OK);
    }
}

//package com.example.ITSSBE.controller;
//
//import com.example.ITSSBE.dto.ProcessDTO;
//import com.example.ITSSBE.service.IProcessService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/process")
//public class ProcessController {
//    @Autowired
//    private IProcessService processService;
//    @GetMapping("/")//yes
//    public ResponseEntity<Object> getAllProcess(){
//        return new ResponseEntity<>( processService.getAllProcess() , HttpStatus.OK);
//    }
//    @PostMapping("")
//    public ResponseEntity<Object> addProcess(@RequestBody ProcessDTO processDTO){
//        return new ResponseEntity<>(processService.addProcess(processDTO), HttpStatus.CREATED);
//    }
//    @GetMapping("/{id}")//yes
//    public ResponseEntity<Object> getProcessByRegisterId(@PathVariable int id){
//        return new ResponseEntity<>(processService.getProcessByRegisterId(id), HttpStatus.OK);
//    }
//
//}
