package com.apimelero.apirest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Machines")
@Getter
@Setter
public class MachineEntity extends BasicEntity{

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "production_line_id")
    private ProductionLineEntity productionLineEntity;

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
