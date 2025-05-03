//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.controller;

import com.example.ITSSBE.dto.EquipmentDTO;
import com.example.ITSSBE.service.IEquipmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping({"/equipment"})
public class EquipmentController {
    @Autowired
    private IEquipmentService equipmentService;

    public EquipmentController() {
    }

    @GetMapping({"/"})
    public ResponseEntity<List<EquipmentDTO>> getAllEquipments() {
        List<EquipmentDTO> equipmentList = this.equipmentService.getAllEquipments();
        return ResponseEntity.ok(equipmentList);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<EquipmentDTO> getEquipmentById(@PathVariable int id) {
        EquipmentDTO equipment = this.equipmentService.getEquipment(id);
        return equipment == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(equipment);
    }

    @PostMapping({"/"})
    public ResponseEntity<EquipmentDTO> addEquipment(@RequestBody EquipmentDTO equipmentDTO) {
        EquipmentDTO newEquipment = this.equipmentService.addEquipment(equipmentDTO);
        return newEquipment == null ? ResponseEntity.status(HttpStatus.BAD_REQUEST).build() : ResponseEntity.status(HttpStatus.CREATED).body(newEquipment);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<EquipmentDTO> changeEquipment(@RequestBody EquipmentDTO equipmentDTO, @PathVariable int id) {
        EquipmentDTO updatedEquipment = this.equipmentService.changeEquipment(equipmentDTO, id);
        return updatedEquipment == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updatedEquipment);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteEquipment(@PathVariable int id) {
        this.equipmentService.deleteEquipment(id);
        return ResponseEntity.noContent().build();
    }
}

//package com.example.ITSSBE.controller;
//
//import com.example.ITSSBE.dto.EquipmentDTO;
//import com.example.ITSSBE.service.IEquipmentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/equipment")
//public class EquipmentController {
//
//    @Autowired
//    private IEquipmentService equipmentService;
//
//    @GetMapping("/")
//    public ResponseEntity<List<EquipmentDTO>> getAllEquipments() {
//        List<EquipmentDTO> equipmentList = equipmentService.getAllEquipments();
//        return ResponseEntity.ok(equipmentList);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<EquipmentDTO> getEquipmentById(@PathVariable int id) {
//        EquipmentDTO equipment = equipmentService.getEquipment(id);
//        if (equipment == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(equipment);
//    }
//
//    @PostMapping("/")
//    public ResponseEntity<EquipmentDTO> addEquipment(@RequestBody EquipmentDTO equipmentDTO) {
//        EquipmentDTO newEquipment = equipmentService.addEquipment(equipmentDTO);
//        if (newEquipment == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).body(newEquipment);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<EquipmentDTO> changeEquipment(@RequestBody EquipmentDTO equipmentDTO, @PathVariable int id) {
//        EquipmentDTO updatedEquipment = equipmentService.changeEquipment(equipmentDTO, id);
//        if (updatedEquipment == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(updatedEquipment);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEquipment(@PathVariable int id) {
//        equipmentService.deleteEquipment(id);
//        return ResponseEntity.noContent().build();
//    }
//}
