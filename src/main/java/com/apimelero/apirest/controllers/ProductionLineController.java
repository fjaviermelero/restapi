package com.apimelero.apirest.controllers;

import com.apimelero.apirest.dto.MachineDto;
import com.apimelero.apirest.dto.ProductionLineDto;
import com.apimelero.apirest.exceptions.NotFoundException;
import com.apimelero.apirest.repositories.MachineRepository;
import com.apimelero.apirest.services.MachineService;
import com.apimelero.apirest.services.ProductionLineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class ProductionLineController {

    ProductionLineService productionLineService;
    MachineService machineService;

    public ProductionLineController(ProductionLineService productionLineService, MachineService machineService) {
        this.productionLineService = productionLineService;
        this.machineService = machineService;
    }

    @GetMapping("/productionlines")
    List<ProductionLineDto> allProdLines(){
        List<ProductionLineDto> foundProdLineDtos = productionLineService.findAll();
        return foundProdLineDtos;
    }

    @GetMapping("/productionlines/{id}")
    ProductionLineDto getProdLine(@PathVariable Long id){
        ProductionLineDto foundProdLineDto = productionLineService.findById(id);
        return foundProdLineDto;
    }

    @GetMapping("/productionlines/{idProdLine}/machines/{idMachine}")
    MachineDto getMachineFromProdLine(@PathVariable Long idProdLine, @PathVariable Long idMachine){

        return machineService.findByProductionLineIdAndMachineId(idProdLine, idMachine);

    }

    @PostMapping("/productionlines/add")
    ProductionLineDto saveProdLine(@RequestBody ProductionLineDto productionLineDto){
        return productionLineService.save(productionLineDto);
    }

    @DeleteMapping("/productionlines/{id}/delete")
    void deleteMachineById (@PathVariable Long id){
        productionLineService.deleteById(id);
    }
}
