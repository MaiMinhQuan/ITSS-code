//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.service.impl;

import com.example.ITSSBE.converter.RegisterConverter;
import com.example.ITSSBE.dto.RegisterDTO;
import com.example.ITSSBE.entity.Package;
import com.example.ITSSBE.entity.Register;
import com.example.ITSSBE.entity.User;
import com.example.ITSSBE.repository.IPackageRepo;
import com.example.ITSSBE.repository.IProcessRepo;
import com.example.ITSSBE.repository.IRegisterRepo;
import com.example.ITSSBE.repository.IUserRepo;
import com.example.ITSSBE.service.IRegisterService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements IRegisterService {
    @Autowired
    private IRegisterRepo registerRepo;
    @Autowired
    private RegisterConverter registerConverter;
    @Autowired
    private IPackageRepo packageRepo;
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private IProcessRepo processRepo;

    public RegisterService() {
    }

    public List<RegisterDTO> getRegisters() {
        List<Register> registers = this.registerRepo.findAll();
        System.out.println(registers.size());
        return (List)registers.stream().map((register) -> {
            return this.registerConverter.toDTO(register);
        }).collect(Collectors.toList());
    }

    public RegisterDTO addRegister(RegisterDTO registerDTO) {
        Package pa = this.packageRepo.findById(registerDTO.getMy_package_id());
        User register_by = this.userRepo.findFirstById(registerDTO.getRegister_by_id());
        User trainer = this.userRepo.findFirstById(registerDTO.getTrainer_id());
        User customer = this.userRepo.findFirstById(registerDTO.getCustomer_id());
        if (pa != null && trainer != null && customer != null && register_by != null) {
            Register register = (Register)this.registerRepo.save(this.registerConverter.toEntity(registerDTO, pa, register_by, trainer, customer));
            return this.registerConverter.toDTO(register);
        } else {
            System.out.println("null");
            return null;
        }
    }

    public RegisterDTO changeRegister(RegisterDTO registerDTO, int id) {
        Register register = this.registerRepo.findFirstById(id);
        Package pa = this.packageRepo.findById(registerDTO.getMy_package_id());
        User register_by = this.userRepo.findFirstById(registerDTO.getRegister_by_id());
        User trainer = this.userRepo.findFirstById(registerDTO.getTrainer_id());
        User customer = this.userRepo.findFirstById(registerDTO.getCustomer_id());
        register.setMy_package(pa);
        register.setRegister_by(register_by);
        register.setTrainer(trainer);
        register.setCustomer(customer);
        Register savedRegister = (Register)this.registerRepo.save(register);
        return this.registerConverter.toDTO(savedRegister);
    }

    public RegisterDTO getRegister(int id) {
        Register register = this.registerRepo.findFirstById(id);
        return this.registerConverter.toDTO(register);
    }

    public void deleteRegister(int id) {
        Register register = this.registerRepo.findFirstById(id);
        this.registerRepo.deleteById(register.getId());
    }

    public List<RegisterDTO> getRegisterByCustomerId(int customerId) {
        List<Register> registers = this.registerRepo.findByCustomerId(customerId);
        return (List)registers.stream().map((register) -> {
            return this.registerConverter.toDTO(register);
        }).collect(Collectors.toList());
    }
}

//package com.example.ITSSBE.service.impl;
//
//import com.example.ITSSBE.converter.RegisterConverter;
//import com.example.ITSSBE.dto.RegisterDTO;
//import com.example.ITSSBE.entity.Package;
//import com.example.ITSSBE.entity.Register;
//import com.example.ITSSBE.entity.User;
//import com.example.ITSSBE.repository.IPackageRepo;
//import com.example.ITSSBE.repository.IProcessRepo;
//import com.example.ITSSBE.repository.IRegisterRepo;
//import com.example.ITSSBE.repository.IUserRepo;
//import com.example.ITSSBE.service.IRegisterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class RegisterService implements IRegisterService {
//    @Autowired
//    private IRegisterRepo registerRepo;
//    @Autowired
//    private RegisterConverter registerConverter;
//    @Autowired
//    private IPackageRepo packageRepo;
//    @Autowired
//    private IUserRepo userRepo;
//    @Autowired
//    private IProcessRepo processRepo;
//    public List<RegisterDTO> getRegisters() {
//        List<Register> registers = registerRepo.findAll();
//        System.out.println(registers.size());
//        return registers.stream().map( register -> registerConverter.toDTO(register)).collect(Collectors.toList());
//    }
//
//    public RegisterDTO addRegister(RegisterDTO registerDTO) {
//        Package pa = packageRepo.findById(registerDTO.getMy_package_id());
//        User register_by = userRepo.findFirstById(registerDTO.getRegister_by_id());
//        User trainer = userRepo.findFirstById(registerDTO.getTrainer_id());
//        User customer = userRepo.findFirstById(registerDTO.getCustomer_id());
//        if( pa == null || trainer == null || customer == null || register_by == null){
//            System.out.println("null nhe anh em");
//            return null;
//        }
//        Register register = registerRepo.save( registerConverter.toEntity(registerDTO, pa, register_by, trainer, customer));
//        return registerConverter.toDTO(register);
//    }
//
//    public RegisterDTO changeRegister(RegisterDTO registerDTO, int id) {
//        Register register = registerRepo.findFirstById(id);
//        Package pa = packageRepo.findById(registerDTO.getMy_package_id());
//        User register_by = userRepo.findFirstById(registerDTO.getRegister_by_id());
//        User trainer = userRepo.findFirstById(registerDTO.getTrainer_id());
//        User customer = userRepo.findFirstById(registerDTO.getCustomer_id());
//        register.setMy_package(pa);
//        register.setRegister_by(register_by);
//        register.setTrainer(trainer);
//        register.setCustomer(customer);
//        Register savedRegister = registerRepo.save(register);
//        return registerConverter.toDTO(savedRegister);
//    }
//
//    public RegisterDTO getRegister(int id) {
//        Register register = registerRepo.findFirstById(id);
//        return registerConverter.toDTO(register);
//    }
//
//    public void deleteRegister(int id) {
//        Register register = registerRepo.findFirstById(id);
//        registerRepo.deleteById(register.getId());
//    }
//
//    public List<RegisterDTO> getRegisterByCustomerId(int customerId) {
//        List<Register> registers = registerRepo.findByCustomerId(customerId);
//        return registers.stream().map(register-> registerConverter.toDTO(register)).collect(Collectors.toList());
//    }
//}
