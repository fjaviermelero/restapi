package com.apimelero.apirest.converters;

import com.apimelero.apirest.dto.MachineDto;
import com.apimelero.apirest.model.MachineEntity;

public class ConverterMachineEntityToDto {

    public static MachineDto convertMachineEntityToDto(MachineEntity machineEntity){

        MachineDto machineDto = new MachineDto();

        machineDto.setName(machineEntity.getName());

        machineDto.setProductionLineId(machineEntity.getProductionLineEntity().getId());

        return machineDto;
    }

}
