package com.apimelero.apirest.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductionLineDto {

    private String name;

    private List<MachineDto> machines = new ArrayList<>();

}
