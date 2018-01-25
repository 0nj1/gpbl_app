package com.onji.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "master_data")
public class MasterData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Length(max = 256)
    private String name;

    @NotNull
    private Integer value;

    @NotNull
    @Length(max = 256)
    private String masterDataKey;

    //TODO: add status

    private Timestamp createdAt;

    private Timestamp updatedAt;

}
