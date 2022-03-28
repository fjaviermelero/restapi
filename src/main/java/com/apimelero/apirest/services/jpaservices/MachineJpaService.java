package com.apimelero.apirest.services.jpaservices;

import com.apimelero.apirest.converters.ConverterMachineEntityToDto;
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
import java.util.stream.Collectors;

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

        List<MachineEntity> machineEntities = new ArrayList<>();

        machineRepository.findAll().forEach(machineEntities::add);

        if (machineEntities.isEmpty())
            throw new NotFoundException();

        List<MachineDto> machineDtos = machineEntities.stream()
                .map(ConverterMachineEntityToDto::convertMachineEntityToDto)
                .collect(Collectors.toList());

//        List<MachineDto> machineDtos = new ArrayList<>();
//
//        for (MachineEntity machineEntity : machineEntities){
//            machineDtos.add(convertMachineEntityToDto(machineEntity));
//        }

        return machineDtos;
    }

    @Override
    public MachineDto findById(Long id) {
        //Get machine from repo

        MachineDto machineDto = machineRepository.findById(id)
                .map(ConverterMachineEntityToDto::convertMachineEntityToDto)
                .orElseThrow(NotFoundException::new);

        return machineDto;

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
