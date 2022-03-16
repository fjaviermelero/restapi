package com.apimelero.apirest.services.jpaservices;

import com.apimelero.apirest.exceptions.NotFoundException;
import com.apimelero.apirest.dto.MachineDto;
import com.apimelero.apirest.exceptions.ProductionLineNotExistingException;
import com.apimelero.apirest.model.MachineEntity;
import com.apimelero.apirest.repositories.MachineRepository;
import com.apimelero.apirest.repositories.ProductionLineRepository;
import com.apimelero.apirest.services.MachineService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

import static com.apimelero.apirest.converters.ConverterMachineDtoToEntity.convertMachineDtoToEntity;
import static com.apimelero.apirest.converters.ConverterMachineEntityToDto.convertMachineEntityToDto;

@Service
public class MachineJpaService implements MachineService {

    //Injected via Constructor
    private MachineRepository machineRepository;

    private ProductionLineRepository productionLineRepository;

    public MachineJpaService(MachineRepository machineRepository, ProductionLineRepository productionLineRepository) {
        this.machineRepository = machineRepository;
        this.productionLineRepository = productionLineRepository;
    }

    @Override
    public List<MachineDto> findAll() {
        //Save data from repo
        List<MachineEntity> machineEntities = new ArrayList<>();
        machineRepository.findAll().forEach(machineEntities::add);

        //Create Dtos list
        List<MachineDto> machineDtos = new ArrayList<>();
        //Save entities from repo to Dtos and transform
        for (MachineEntity machineEntity : machineEntities){
            machineDtos.add(convertMachineEntityToDto(machineEntity));
        }

        //Give back to Controller
        if (machineDtos.isEmpty()){
            throw new NotFoundException();
        } else {
            return machineDtos;
        }
    }

    @Override
    public MachineDto findById(Long aLong) {

        MachineEntity machineEntity = machineRepository.findById(aLong).orElseThrow(NotFoundException::new);

        return convertMachineEntityToDto(machineEntity);

//        //Refactored
//        if (machineRepository.findById(aLong).isPresent()) {
//
//            MachineEntity machineEntity = machineRepository.findById(aLong).get();
//
//            MachineDto machineDto = convertMachineEntityToDto(machineEntity);
//
//            return machineDto;
//        }
//
//        else {
//            throw new NotFoundException();
//        }
    }

    @Override
    public MachineDto save(MachineDto machineDto) {

        if (productionLineRepository.existsById(machineDto.getProductionLineId())) {

            MachineEntity machineEntity = convertMachineDtoToEntity(machineDto);
            machineRepository.save(machineEntity);
            return machineDto;
        }
        else{
            throw new ProductionLineNotExistingException();
        }
    }

    @Override
    public void deleteById(Long id) {
        machineRepository.deleteById(id);
    }

}
