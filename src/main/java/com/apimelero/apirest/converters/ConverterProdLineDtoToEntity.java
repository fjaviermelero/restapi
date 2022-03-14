package com.apimelero.apirest.converters;

import com.apimelero.apirest.dto.MachineDto;
import com.apimelero.apirest.dto.ProductionLineDto;
import com.apimelero.apirest.model.ProductionLineEntity;

import static com.apimelero.apirest.converters.ConverterMachineDtoToEntity.convertMachineDtoToEntity;

public class ConverterProdLineDtoToEntity {

    public static ProductionLineEntity convertProdLineDtoToEntity (ProductionLineDto productionLineDto){

        ProductionLineEntity productionLineEntity = new ProductionLineEntity();

        productionLineEntity.setName(productionLineDto.getName());

        for (MachineDto machineDto : productionLineDto.getMachines()){
            productionLineEntity.getMachineEntities().add(convertMachineDtoToEntity(machineDto));
        }

        return productionLineEntity;

    }
}
