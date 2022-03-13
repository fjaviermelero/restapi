package com.apimelero.apirest.repositories;

import com.apimelero.apirest.model.MachineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends CrudRepository<MachineEntity, Long> {

}
