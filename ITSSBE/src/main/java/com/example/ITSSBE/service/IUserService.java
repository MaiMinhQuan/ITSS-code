//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.service;

import com.example.ITSSBE.dto.UserDTO;
import com.example.ITSSBE.entity.Role;
import java.util.List;

public interface IUserService {
    UserDTO getUserDTO(UserDTO userDTO);

    UserDTO getUserById(int id);

    UserDTO addUser(UserDTO userDTO);

    List<Role> getAllRoles();

    List<UserDTO> getAllStaff();

    List<UserDTO> getAllCustomers();

    void deleteUser(int id);

    UserDTO updateUser(UserDTO userDTO);
}

//package com.example.ITSSBE.service;
//
//import com.example.ITSSBE.dto.UserDTO;
//import com.example.ITSSBE.entity.Role;
//
//import java.util.List;
//
//public interface IUserService {
//    UserDTO getUserDTO(UserDTO userDTO);
//    UserDTO getUserById(int id);
//    UserDTO addUser(UserDTO userDTO);
//    List<Role> getAllRoles();
//    List<UserDTO> getAllStaff();
//    List<UserDTO> getAllCustomers();
//    void deleteUser(int id);
//    UserDTO updateUser(UserDTO userDTO);
//}
