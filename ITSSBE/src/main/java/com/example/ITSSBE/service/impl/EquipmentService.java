//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.service.impl;

import com.example.ITSSBE.converter.EquipmentConverter;
import com.example.ITSSBE.dto.EquipmentDTO;
import com.example.ITSSBE.entity.EpCategory;
import com.example.ITSSBE.entity.Equipment;
import com.example.ITSSBE.entity.Room;
import com.example.ITSSBE.repository.IEpCategoryRepo;
import com.example.ITSSBE.repository.IEquipmentRepo;
import com.example.ITSSBE.repository.IRoomRepo;
import com.example.ITSSBE.service.IEquipmentService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService implements IEquipmentService {
    @Autowired
    private IEquipmentRepo equipmentRepo;
    @Autowired
    private EquipmentConverter equipmentConverter;
    @Autowired
    private IEpCategoryRepo epCategoryRepo;
    @Autowired
    private IRoomRepo roomRepo;

    public EquipmentService() {
    }

    public List<EquipmentDTO> getAllEquipments() {
        List<Equipment> equipments = this.equipmentRepo.findAll();
        return (List)equipments.stream().map((equipment) -> {
            return this.equipmentConverter.toDTO(equipment);
        }).collect(Collectors.toList());
    }

    public EquipmentDTO getEquipment(int id) {
        return this.equipmentConverter.toDTO(this.equipmentRepo.findById(id));
    }

    public EquipmentDTO addEquipment(EquipmentDTO equipmentDTO) {
        EpCategory epCategory = this.epCategoryRepo.findByName(equipmentDTO.getCategory_name());
        Room room = this.roomRepo.findById(equipmentDTO.getRoom_id());
        if (epCategory == null) {
            System.out.println("Chua co thiet bi nay");
            Equipment equipment = (Equipment)this.equipmentRepo.save(this.equipmentConverter.toEntity(equipmentDTO, epCategory, room));
            return this.equipmentConverter.toDTO(equipment);
        } else {
            return null;
        }
    }

    public EquipmentDTO changeEquipment(EquipmentDTO equipmentDTO, int id) {
        Equipment equipment = this.equipmentRepo.findById(id);
        Room room = this.roomRepo.findById(equipmentDTO.getRoom_id());
        EpCategory category = this.epCategoryRepo.findById(equipmentDTO.getCategory_id());
        equipment.setRoom(room);
        equipment.setCategory(category);
        equipment.setPrice(equipmentDTO.getPrice());
        equipment.setPuchase_date(equipmentDTO.getPurchase_date());
        equipment.setName(equipmentDTO.getName());
        equipment.setWarranty_period(equipmentDTO.getWarranty_period());
        Equipment savedEquipment = (Equipment)this.equipmentRepo.save(equipment);
        return this.equipmentConverter.toDTO(savedEquipment);
    }

    public EquipmentDTO deleteEquipment(int id) {
        Equipment equipment = this.equipmentRepo.findById(id);
        equipment.set_deleted(true);
        Equipment savedEquipment = (Equipment)this.equipmentRepo.save(equipment);
        return this.equipmentConverter.toDTO(savedEquipment);
    }
}

//package com.example.ITSSBE.service.impl;
//
//import com.example.ITSSBE.converter.EquipmentConverter;
//import com.example.ITSSBE.dto.EquipmentDTO;
//import com.example.ITSSBE.entity.*;
//import com.example.ITSSBE.repository.*;
//import com.example.ITSSBE.service.IEquipmentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class EquipmentService implements IEquipmentService {
//    @Autowired
//    private IEquipmentRepo equipmentRepo;
//    @Autowired
//    private EquipmentConverter equipmentConverter;
//    @Autowired
//    private IEpCategoryRepo epCategoryRepo;
//    @Autowired
//    private IRoomRepo roomRepo;
//
//    public List<EquipmentDTO> getAllEquipments() {
//        List<Equipment> equipments = equipmentRepo.findAll();
//        return equipments.stream().map(equipment -> equipmentConverter.toDTO(equipment)).collect(Collectors.toList());
//
//    }
//
//    public EquipmentDTO getEquipment(int id) {
//        return equipmentConverter.toDTO(equipmentRepo.findById(id));
//
//    }
//
//    public EquipmentDTO addEquipment(EquipmentDTO equipmentDTO) {
//        EpCategory epCategory = epCategoryRepo.findByName( equipmentDTO.getCategory_name());
//        Room room = roomRepo.findById(equipmentDTO.getRoom_id());
//        if(epCategory == null){
//            System.out.println("Chua co thiet bi nay");
//            Equipment equipment = equipmentRepo.save(equipmentConverter.toEntity(equipmentDTO,epCategory,room));
//            return equipmentConverter.toDTO(equipment);
//        }
//        return null;
//    }
//    public EquipmentDTO changeEquipment(EquipmentDTO equipmentDTO, int id) {
//        Equipment equipment = equipmentRepo.findById(id);
//        Room room = roomRepo.findById(equipmentDTO.getRoom_id());
//        EpCategory category = epCategoryRepo.findById(equipmentDTO.getCategory_id());
//
//        equipment.setRoom(room);
//        equipment.setCategory(category);
//        equipment.setPrice(equipmentDTO.getPrice());
//        equipment.setPuchase_date(equipmentDTO.getPurchase_date());
//        equipment.setName(equipmentDTO.getName());
//        equipment.setWarranty_period(equipmentDTO.getWarranty_period());
//        Equipment savedEquipment = equipmentRepo.save(equipment);
//        return equipmentConverter.toDTO(savedEquipment);
//    }
//    public EquipmentDTO deleteEquipment(int id) {
//        Equipment equipment = equipmentRepo.findById(id);
//        equipment.set_deleted(true);
//        Equipment savedEquipment = equipmentRepo.save(equipment);
//        return equipmentConverter.toDTO(savedEquipment);
//    }
//}
