//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.converter;

import com.example.ITSSBE.dto.UserDTO;
import com.example.ITSSBE.entity.Role;
import com.example.ITSSBE.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    @Autowired
    private ModelMapper modelMapper;

    public UserConverter() {
    }

    public User toEntity(UserDTO userDTO, Role role) {
        User user = (User)this.modelMapper.map(userDTO, User.class);
        user.setRole(role);
        return user;
    }

    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        } else {
            UserDTO userDTO = (UserDTO)this.modelMapper.map(user, UserDTO.class);
            userDTO.setRole_id(user.getRole().getId());
            userDTO.setRole_name(user.getRole().getName());
            return userDTO;
        }
    }
}

//package com.example.ITSSBE.converter;
//
//import com.example.ITSSBE.dto.UserDTO;
//import com.example.ITSSBE.entity.Role;
//import com.example.ITSSBE.entity.User;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserConverter {
//    @Autowired
//    private ModelMapper modelMapper;
//    public User toEntity(UserDTO userDTO, Role role){
//        User user = modelMapper.map(userDTO, User.class);
//        user.setRole(role);
//        return user;
//    }
//    public UserDTO toDTO(User user){
//        if( user == null)
//            return null;
//        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
//        userDTO.setRole_id(user.getRole().getId());
//        userDTO.setRole_name(user.getRole().getName());
//        return userDTO;
//    }
//}
