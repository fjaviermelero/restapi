package com.apimelero.apirest.services;

import com.apimelero.apirest.dto.MachineDto;

public interface MachineService extends CrudService<MachineDto, Long>{

    MachineDto findByProductionLineIdAndMachineId(Long idProdLine, Long idMachine);

}
