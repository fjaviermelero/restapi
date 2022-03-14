package com.apimelero.apirest.converters;

import com.apimelero.apirest.dto.MachineDto;
import com.apimelero.apirest.dto.ProductionLineDto;
import com.apimelero.apirest.model.MachineEntity;
import com.apimelero.apirest.model.ProductionLineEntity;

import static com.apimelero.apirest.converters.ConverterMachineDtoToEntity.convertMachineDtoToEntity;
import static com.apimelero.apirest.converters.ConverterMachineEntityToDto.convertMachineEntityToDto;

public class ConverterProdLineEntityToDto {

    public static ProductionLineDto convertProdLineEntityToDto (ProductionLineEntity productionLineEntity){

        ProductionLineDto productionLineDto = new ProductionLineDto();

        productionLineDto.setName(productionLineEntity.getName());

        for (MachineEntity machineEntity: productionLineEntity.getMachineEntities()){

            productionLineDto.getMachines().add(convertMachineEntityToDto(machineEntity));

        }

        return productionLineDto;

    }

}
