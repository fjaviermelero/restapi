package com.apimelero.apirest.dto;

import lombok.Data;

@Data
public class MachineDto {

        private String name;

        private Long productionLineId;

}

////Using a record would be a good option for a DTO class
//public record MachineDto (String name, Long productionLineId){}
