package com.apimelero.apirest.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ProductionLines")
@Getter
@Setter
public class ProductionLineEntity extends BasicEntity{

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productionLineEntity")
    private List<MachineEntity> machineEntities = new ArrayList<>();

    @Override
    public String toString() {
        return "Production Line{" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
