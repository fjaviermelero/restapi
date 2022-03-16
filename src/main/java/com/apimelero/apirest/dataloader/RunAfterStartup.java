package com.apimelero.apirest.dataloader;

import com.apimelero.apirest.model.MachineEntity;
import com.apimelero.apirest.model.ProductionLineEntity;
import com.apimelero.apirest.repositories.MachineRepository;
import com.apimelero.apirest.repositories.ProductionLineRepository;
import com.apimelero.apirest.services.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class RunAfterStartup {

    @Autowired
    MachineService machineService;

    @Autowired
    MachineRepository machineRepository;

    @Autowired
    ProductionLineRepository productionLineRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {

        System.out.println("Application Initiated");

        ProductionLineEntity productionLineEntity1 = new ProductionLineEntity();
        productionLineEntity1.setName("Production Line 1");
        productionLineRepository.save(productionLineEntity1);

        ProductionLineEntity productionLineEntity2 = new ProductionLineEntity();
        productionLineEntity2.setName("Production Line 2");
        productionLineRepository.save(productionLineEntity2);

        ProductionLineEntity productionLineEntity3 = new ProductionLineEntity();
        productionLineEntity3.setName("Production Line 3");
        productionLineRepository.save(productionLineEntity3);

        MachineEntity machineEntity1 = new MachineEntity();
        machineEntity1.setName("Machine1");
        machineEntity1.setProductionLineEntity(productionLineEntity1);
        machineRepository.save(machineEntity1);

        MachineEntity machineEntity2 = new MachineEntity();
        machineEntity2.setName("Machine2");
        machineEntity2.setProductionLineEntity(productionLineEntity1);
        machineRepository.save(machineEntity2);

        MachineEntity machineEntity3 = new MachineEntity();
        machineEntity3.setName("Machine3");
        machineEntity3.setProductionLineEntity(productionLineEntity1);
        machineRepository.save(machineEntity3);

        MachineEntity machineEntity4 = new MachineEntity();
        machineEntity4.setName("Machine4");
        machineEntity4.setProductionLineEntity(productionLineEntity2);
        machineRepository.save(machineEntity4);

        MachineEntity machineEntity5 = new MachineEntity();
        machineEntity5.setName("Machine5");
        machineEntity5.setProductionLineEntity(productionLineEntity2);
        machineRepository.save(machineEntity5);

    }

}


