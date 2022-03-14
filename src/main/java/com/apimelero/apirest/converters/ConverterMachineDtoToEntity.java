package com.apimelero.apirest.converters;

import com.apimelero.apirest.dto.MachineDto;
import com.apimelero.apirest.model.MachineEntity;
import com.apimelero.apirest.model.ProductionLineEntity;

public class ConverterMachineDtoToEntity {

    public static MachineEntity convertMachineDtoToEntity(MachineDto machineDto){

        MachineEntity machineEntity = new MachineEntity();

        machineEntity.setName(machineDto.getName());

        ProductionLineEntity productionLineEntity = new ProductionLineEntity();

        productionLineEntity.setId(machineDto.getProductionLineId());

        machineEntity.setProductionLineEntity(productionLineEntity);

        return machineEntity;
    }

}
