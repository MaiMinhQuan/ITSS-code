//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.service.impl;

import com.example.ITSSBE.converter.ProcessConverter;
import com.example.ITSSBE.dto.ProcessDTO;
import com.example.ITSSBE.entity.Process;
import com.example.ITSSBE.entity.Register;
import com.example.ITSSBE.repository.IProcessRepo;
import com.example.ITSSBE.repository.IRegisterRepo;
import com.example.ITSSBE.service.IProcessService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessService implements IProcessService {
    @Autowired
    private IProcessRepo processRepo;
    @Autowired
    private IRegisterRepo registerRepo;
    @Autowired
    private ProcessConverter processConverter;

    public ProcessService() {
    }

    public List<ProcessDTO> getAllProcess() {
        List<Process> processes = this.processRepo.findAll();
        return (List)processes.stream().map((process) -> {
            return this.processConverter.toDTO(process);
        }).collect(Collectors.toList());
    }

    public ProcessDTO addProcess(ProcessDTO processDTO) {
        Register register = this.registerRepo.findFirstById(processDTO.getRegister_id());
        Process process = this.processConverter.toEntity(processDTO, register);
        Process savedProcess = (Process)this.processRepo.save(process);
        return this.processConverter.toDTO(savedProcess);
    }

    public List<ProcessDTO> getProcessByRegisterId(int id) {
        List<Process> processes = this.processRepo.getByRegisterId(id);
        return (List)processes.stream().map((process) -> {
            return this.processConverter.toDTO(process);
        }).collect(Collectors.toList());
    }
}

//package com.example.ITSSBE.service.impl;
//
//import com.example.ITSSBE.converter.ProcessConverter;
//import com.example.ITSSBE.dto.ProcessDTO;
//import com.example.ITSSBE.entity.Process;
//import com.example.ITSSBE.entity.Register;
//import com.example.ITSSBE.repository.IProcessRepo;
//import com.example.ITSSBE.repository.IRegisterRepo;
//import com.example.ITSSBE.service.IProcessService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class ProcessService implements IProcessService {
//    @Autowired
//    private IProcessRepo processRepo;
//    @Autowired
//    private IRegisterRepo registerRepo;
//    @Autowired
//    private ProcessConverter processConverter;
//
//    public List<ProcessDTO> getAllProcess() {
//        List<Process> processes = processRepo.findAll();
//        return processes.stream().map(process -> processConverter.toDTO(process)).collect(Collectors.toList());
//
//    }
//
//    public ProcessDTO addProcess(ProcessDTO processDTO) {
//        Register register = registerRepo.findFirstById(processDTO.getRegister_id());
//        Process process = processConverter.toEntity( processDTO, register);
//        Process savedProcess = processRepo.save(process);
//        return processConverter.toDTO(savedProcess);
//    }
//
//    public List<ProcessDTO> getProcessByRegisterId(int id) {
//        List<Process> processes = processRepo.getByRegisterId(id);
//        return processes.stream().map( process -> processConverter.toDTO(process)).collect(Collectors.toList());
//    }
//}
