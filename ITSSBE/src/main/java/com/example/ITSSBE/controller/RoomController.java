//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.controller;

import com.example.ITSSBE.entity.Room;
import com.example.ITSSBE.service.IRoomService;
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
@RequestMapping({"/room"})
@CrossOrigin(
        origins = {"http://localhost:3000"}
)
public class RoomController {
    @Autowired
    private IRoomService roomService;

    public RoomController() {
    }

    @PostMapping({"/"})
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        Room newRoom = this.roomService.addRoom(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRoom);
    }

    @GetMapping({"/"})
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> roomList = this.roomService.getAllRooms();
        return ResponseEntity.ok(roomList);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Room> getRoomById(@PathVariable int id) {
        Room room = this.roomService.getRoom(id);
        return room == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(room);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Room> updateRoom(@PathVariable int id, @RequestBody Room room) {
        Room updatedRoom = this.roomService.changeRoom(id, room);
        return updatedRoom == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteRoom(@PathVariable int id) {
        this.roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}

//package com.example.ITSSBE.controller;
//
//import com.example.ITSSBE.entity.Room;
//import com.example.ITSSBE.service.IRoomService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/room")
//@CrossOrigin(origins = "http://localhost:3000")
//public class RoomController {
//
//    @Autowired
//    private IRoomService roomService;
//
//    @PostMapping("/")
//    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
//        Room newRoom = roomService.addRoom(room);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newRoom);
//    }
//
//    @GetMapping("/")
//    public ResponseEntity<List<Room>> getAllRooms() {
//        List<Room> roomList = roomService.getAllRooms();
//        return ResponseEntity.ok(roomList);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Room> getRoomById(@PathVariable int id) {
//        Room room = roomService.getRoom(id);
//        if (room == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(room);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Room> updateRoom(@PathVariable int id, @RequestBody Room room) {
//        Room updatedRoom = roomService.changeRoom(id, room);
//        if (updatedRoom == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(updatedRoom);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRoom(@PathVariable int id) {
//        roomService.deleteRoom(id);
//        return ResponseEntity.noContent().build();
//    }
//}
