//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.service.impl;

import com.example.ITSSBE.converter.UserConverter;
import com.example.ITSSBE.dto.UserDTO;
import com.example.ITSSBE.entity.Role;
import com.example.ITSSBE.entity.User;
import com.example.ITSSBE.repository.IRoleRepo;
import com.example.ITSSBE.repository.IUserRepo;
import com.example.ITSSBE.service.IUserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private IRoleRepo roleRepo;

    public UserService() {
    }

    public UserDTO getUserDTO(UserDTO userDTO) {
        User user = this.userRepo.findByGmailAndPassword(userDTO.getGmail(), userDTO.getPassword());
        return user == null ? null : this.userConverter.toDTO(user);
    }

    public UserDTO getUserById(int id) {
        return this.userConverter.toDTO(this.userRepo.findFirstById(id));
    }

    public UserDTO addUser(UserDTO userDTO) {
        Role role = this.roleRepo.findByName(userDTO.getRole_name());
        User user = this.userConverter.toEntity(userDTO, role);
        User savedUser = (User)this.userRepo.save(user);
        return this.userConverter.toDTO(savedUser);
    }

    public List<Role> getAllRoles() {
        return this.roleRepo.findAll();
    }

    public List<UserDTO> getAllStaff() {
        List<User> staffs = this.userRepo.findByRole();
        return (List)staffs.stream().map((staff) -> {
            return this.userConverter.toDTO(staff);
        }).collect(Collectors.toList());
    }

    public List<UserDTO> getAllCustomers() {
        List<User> customers = this.userRepo.findCustomers();
        return (List)customers.stream().map((customer) -> {
            return this.userConverter.toDTO(customer);
        }).collect(Collectors.toList());
    }

    public void deleteUser(int id) {
        this.userRepo.deleteById(id);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        User tmp = this.userRepo.findFirstById(userDTO.getId());
        if (tmp == null) {
            return null;
        } else {
            Role role = this.roleRepo.findFirstByRoleId(userDTO.getRole_id());
            User user = this.userConverter.toEntity(userDTO, role);
            return this.userConverter.toDTO((User)this.userRepo.save(user));
        }
    }
}

//package com.example.ITSSBE.service.impl;
//
//import com.example.ITSSBE.converter.UserConverter;
//import com.example.ITSSBE.dto.UserDTO;
//import com.example.ITSSBE.entity.Role;
//import com.example.ITSSBE.entity.User;
//import com.example.ITSSBE.repository.IRoleRepo;
//import com.example.ITSSBE.repository.IUserRepo;
//import com.example.ITSSBE.service.IUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UserService implements IUserService {
//    @Autowired
//    private IUserRepo userRepo;
//    @Autowired
//    private UserConverter userConverter;
//    @Autowired
//    private IRoleRepo roleRepo;
//
//    public UserDTO getUserDTO(UserDTO userDTO) {
//        User user = userRepo.findByGmailAndPassword( userDTO.getGmail(), userDTO.getPassword());
//        if( user == null) return null;
//        return userConverter.toDTO(user);
//    }
//
//    public UserDTO getUserById(int id) {
//        return userConverter.toDTO( userRepo.findFirstById(id));
//    }
//
//
//    public UserDTO addUser(UserDTO userDTO) {
//        Role role = roleRepo.findByName(userDTO.getRole_name());
//        User user = userConverter.toEntity(userDTO, role);
//        User savedUser = userRepo.save(user);
//        return userConverter.toDTO(savedUser);
//    }
//    public List<Role> getAllRoles() {
//        return roleRepo.findAll();
//    }
//
//    public List<UserDTO> getAllStaff() {
//        List<User> staffs = userRepo.findByRole();
//        return staffs.stream().map(staff -> userConverter.toDTO(staff)).collect(Collectors.toList());
//    }
//
//    public List<UserDTO> getAllCustomers() {
//        List<User> customers = userRepo.findCustomers();
//        return customers.stream().map(customer -> userConverter.toDTO(customer)).collect(Collectors.toList());
//    }
//
//    public void deleteUser(int id) {
//        userRepo.deleteById(id);
//    }
//
//    public UserDTO updateUser(UserDTO userDTO) {
//        User tmp = userRepo.findFirstById(userDTO.getId());
//        if (tmp == null)
//            return null;
//        Role role = roleRepo.findFirstByRoleId(userDTO.getRole_id());
//        User user = userConverter.toEntity(userDTO, role);
//        return userConverter.toDTO(userRepo.save(user));
//    }
//}
