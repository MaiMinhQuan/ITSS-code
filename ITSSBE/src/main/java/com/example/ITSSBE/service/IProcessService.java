//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.ITSSBE.service;

import com.example.ITSSBE.dto.ProcessDTO;
import java.util.List;

public interface IProcessService {
    List<ProcessDTO> getAllProcess();

    ProcessDTO addProcess(ProcessDTO processDTO);

    List<ProcessDTO> getProcessByRegisterId(int id);
}

//package com.example.ITSSBE.service;
//
//import com.example.ITSSBE.dto.ProcessDTO;
//
//import java.util.List;
//
//public interface IProcessService {
//    List<ProcessDTO> getAllProcess();
//    ProcessDTO addProcess(ProcessDTO processDTO);
//    List<ProcessDTO> getProcessByRegisterId(int id);
//}
