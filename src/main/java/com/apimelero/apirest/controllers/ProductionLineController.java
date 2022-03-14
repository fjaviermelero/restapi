package com.apimelero.apirest.controllers;

import com.apimelero.apirest.dto.MachineDto;
import com.apimelero.apirest.dto.ProductionLineDto;
import com.apimelero.apirest.services.ProductionLineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductionLineController {

    ProductionLineService productionLineService;

    public ProductionLineController(ProductionLineService productionLineService) {
        this.productionLineService = productionLineService;
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

    @PostMapping("/productionlines/add")
    ProductionLineDto saveProdLine(@RequestBody ProductionLineDto productionLineDto){
        return productionLineService.save(productionLineDto);
    }

    @DeleteMapping("/productionlines/{id}/delete")
    void deleteMachineById (@PathVariable Long id){
        productionLineService.deleteById(id);
    }
}
