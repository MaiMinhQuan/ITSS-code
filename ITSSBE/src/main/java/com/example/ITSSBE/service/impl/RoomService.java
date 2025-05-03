//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.service.impl;

import com.example.ITSSBE.entity.Room;
import com.example.ITSSBE.repository.IRoomRepo;
import com.example.ITSSBE.service.IRoomService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements IRoomService {
    @Autowired
    private IRoomRepo roomRepo;

    public RoomService() {
    }

    public Room addRoom(Room room) {
        room.set_deleted(false);
        Room saveRoom = (Room)this.roomRepo.save(room);
        return saveRoom;
    }

    public List<Room> getAllRooms() {
        return this.roomRepo.findAll();
    }

    public Room getRoom(int id) {
        return this.roomRepo.findById(id);
    }

    public Room changeRoom(int id, Room room) {
        Room roomDB = this.roomRepo.findById(id);
        roomDB.setName(room.getName());
        roomDB.setAddress(room.getAddress());
        roomDB.setAcreage(room.getAcreage());
        return (Room)this.roomRepo.save(roomDB);
    }

    public Room deleteRoom(int id) {
        Room room = this.roomRepo.findById(id);
        room.set_deleted(true);
        Room saveRoom = (Room)this.roomRepo.save(room);
        return saveRoom;
    }
}

//package com.example.ITSSBE.service.impl;
//
//import com.example.ITSSBE.entity.Room;
//import com.example.ITSSBE.repository.IRoomRepo;
//import com.example.ITSSBE.service.IRoomService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class RoomService implements IRoomService {
//    @Autowired
//    private IRoomRepo roomRepo;
//
//    public Room addRoom(Room room){
//        room.set_deleted(false);
//        Room saveRoom = roomRepo.save(room);
//        return saveRoom;
//    }
//
//    public List<Room> getAllRooms() {
//        return roomRepo.findAll();
//    }
//
//    public Room getRoom(int id) {
//        return roomRepo.findById(id);
//    }
//
//    public Room changeRoom(int id, Room room) {
//        Room roomDB = roomRepo.findById(id);
//        roomDB.setName(room.getName());
//        roomDB.setAddress(room.getAddress());
//        roomDB.setAcreage(room.getAcreage());
//        return roomRepo.save(roomDB);
//    }
//
//    public Room deleteRoom(int id) {
//        Room room = roomRepo.findById(id);
//        room.set_deleted(true);
//        Room saveRoom = roomRepo.save(room);
//        return saveRoom;
//    }
//}
