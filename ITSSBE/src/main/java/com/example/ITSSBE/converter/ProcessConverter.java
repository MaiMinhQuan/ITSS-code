//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.converter;

import com.example.ITSSBE.dto.ProcessDTO;
import com.example.ITSSBE.entity.Process;
import com.example.ITSSBE.entity.Register;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ProcessConverter() {
    }

    public ProcessDTO toDTO(Process process) {
        ProcessDTO processDTO = (ProcessDTO)this.modelMapper.map(process, ProcessDTO.class);
        processDTO.setRegister_id(process.getRegister().getId());
        return processDTO;
    }

    public Process toEntity(ProcessDTO processDTO, Register register) {
        Process process = (Process)this.modelMapper.map(processDTO, Process.class);
        process.setRegister(register);
        return process;
    }
}

//package com.example.ITSSBE.converter;
//
//import com.example.ITSSBE.dto.ProcessDTO;
//import com.example.ITSSBE.entity.Process;
//import com.example.ITSSBE.entity.Register;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ProcessConverter {
//    @Autowired
//    private ModelMapper modelMapper;
//    public ProcessDTO toDTO( Process process){
//        ProcessDTO processDTO = modelMapper.map(process, ProcessDTO.class);
//        processDTO.setRegister_id(process.getRegister().getId());
//        return processDTO;
//    }
//
//    public Process toEntity(ProcessDTO processDTO, Register register) {
//        Process process = modelMapper.map(processDTO, Process.class);
//        process.setRegister(register);
//        return process;
//    }
//}
