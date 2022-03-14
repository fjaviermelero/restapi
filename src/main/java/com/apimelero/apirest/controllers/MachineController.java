package com.apimelero.apirest.controllers;

import com.apimelero.apirest.dto.MachineDto;
import com.apimelero.apirest.services.MachineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MachineController {

    //Injected via Constructor
    MachineService machineService;

    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @GetMapping("/machines")
    List<MachineDto> allMachines(){
        List<MachineDto> foundMachineDtos = machineService.findAll();
        return foundMachineDtos;
    }

    @GetMapping("/machines/{id}")
    MachineDto getMachine(@PathVariable Long id){
        MachineDto foundMachineDto = machineService.findById(id);
        return foundMachineDto;
    }

    @PostMapping("/machines/add")
    MachineDto newMachine(@RequestBody MachineDto newMachineDto){
        return machineService.save(newMachineDto);
    }

    @DeleteMapping("/machines/{id}/delete")
    void deleteMachineById(@PathVariable Long id){
        machineService.deleteById(id);
    }
}
