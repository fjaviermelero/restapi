package com.apimelero.apirest.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BasicEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increment for the ID
    private long id;

}
