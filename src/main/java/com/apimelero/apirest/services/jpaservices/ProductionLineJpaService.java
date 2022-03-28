package com.apimelero.apirest.services.jpaservices;

import com.apimelero.apirest.converters.ConverterMachineEntityToDto;
import com.apimelero.apirest.converters.ConverterProdLineEntityToDto;
import com.apimelero.apirest.dto.MachineDto;
import com.apimelero.apirest.dto.ProductionLineDto;
import com.apimelero.apirest.exceptions.NotFoundException;
import com.apimelero.apirest.model.MachineEntity;
import com.apimelero.apirest.model.ProductionLineEntity;
import com.apimelero.apirest.repositories.ProductionLineRepository;
import com.apimelero.apirest.services.ProductionLineService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.apimelero.apirest.converters.ConverterMachineEntityToDto.convertMachineEntityToDto;
import static com.apimelero.apirest.converters.ConverterProdLineDtoToEntity.convertProdLineDtoToEntity;
import static com.apimelero.apirest.converters.ConverterProdLineEntityToDto.convertProdLineEntityToDto;

@Service
public class ProductionLineJpaService implements ProductionLineService {

    ProductionLineRepository productionLineRepository;

    public ProductionLineJpaService(ProductionLineRepository productionLineRepository) {
        this.productionLineRepository = productionLineRepository;

    }

    @Override
    public List<ProductionLineDto> findAll() {

        List<ProductionLineEntity> prodLineEntities = new ArrayList<>();

        productionLineRepository.findAll().forEach(prodLineEntities::add);

        if (prodLineEntities.isEmpty())
            throw new NotFoundException();

        List <ProductionLineDto> prodLineDtos = prodLineEntities.stream()
                .map(ConverterProdLineEntityToDto::convertProdLineEntityToDto)
                .collect(Collectors.toList());

//        List<ProductionLineDto> prodLineDtos = new ArrayList<>();
//
//        for (ProductionLineEntity productionLineEntity: prodLineEntities){
//            prodLineDtos.add(convertProdLineEntityToDto(productionLineEntity));
//        }

        return prodLineDtos;
    }

    @Override
    public ProductionLineDto findById(Long id) {

        ProductionLineDto productionLineDto = productionLineRepository.findById(id)
                .map(ConverterProdLineEntityToDto::convertProdLineEntityToDto)
                .orElseThrow(NotFoundException::new);

        return productionLineDto;

//        if (productionLineRepository.findById(id).isPresent()) {
//
//        ProductionLineEntity foundProdLineEntity = productionLineRepository.findById(id).get();
//
//        ProductionLineDto productionLineDto = convertProdLineEntityToDto(foundProdLineEntity);
//
//        return productionLineDto;
//
//        }
//        else {
//            throw new NotFoundException();
//        }
    }

    @Override
    public ProductionLineDto save(ProductionLineDto productionLineDto) {

        ProductionLineEntity productionLineEntity = convertProdLineDtoToEntity(productionLineDto);

        productionLineRepository.save(productionLineEntity);

        return productionLineDto;
    }

    @Override
    public void deleteById(Long id) {

        productionLineRepository.deleteById(id);

    }
}
