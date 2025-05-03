//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.controller;

import com.example.ITSSBE.entity.Package;
import com.example.ITSSBE.service.IPackageService;
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
@RequestMapping({"/package"})
@CrossOrigin
public class PackageController {
    @Autowired
    private IPackageService packageService;

    public PackageController() {
    }

    @GetMapping({"/"})
    public ResponseEntity<Object> getAllPackages() {
        return new ResponseEntity(this.packageService.getAllPackages(), HttpStatus.OK);
    }

    @PostMapping({""})
    public ResponseEntity<Object> addPackage(@RequestBody Package pa) {
        return new ResponseEntity(this.packageService.addPackage(pa), HttpStatus.CREATED);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Object> getPackageById(@PathVariable int id) {
        return new ResponseEntity(this.packageService.getPackage(id), HttpStatus.OK);
    }

    @PatchMapping({"/{id}"})
    public ResponseEntity<Object> editPackageById(@PathVariable int id, @RequestBody Package pa) {
        return new ResponseEntity(this.packageService.changePackage(id, pa), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Object> deletePackageById(@PathVariable int id) {
        this.packageService.deletePackage(id);
        return null;
    }
}

//package com.example.ITSSBE.controller;
//
//import com.example.ITSSBE.entity.Package;
//import com.example.ITSSBE.service.IPackageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/package")
//@CrossOrigin
//public class PackageController {
//    @Autowired
//    private IPackageService packageService;
//    @GetMapping("/")
//    public ResponseEntity<Object> getAllPackages(){
//        return new ResponseEntity<>( packageService.getAllPackages() , HttpStatus.OK);
//    }
//    @PostMapping("")
//    public ResponseEntity<Object> addPackage(@RequestBody Package pa){
//        return new ResponseEntity<>(packageService.addPackage(pa), HttpStatus.CREATED);
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getPackageById(@PathVariable int id){
//        return new ResponseEntity<>(packageService.getPackage(id), HttpStatus.OK);
//    }
//    @PatchMapping("/{id}")
//    public ResponseEntity<Object> editPackageById( @PathVariable int id, @RequestBody Package pa){
//        return new ResponseEntity<>( packageService.changePackage(id, pa), HttpStatus.OK);
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deletePackageById( @PathVariable int id){
//        packageService.deletePackage(id);
//        return null;
//    }
//}
