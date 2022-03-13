package com.apimelero.apirest.repositories;

import com.apimelero.apirest.model.ProductionLineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionLineRepository extends CrudRepository<ProductionLineEntity, Long> {
}
