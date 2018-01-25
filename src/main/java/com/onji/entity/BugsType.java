package com.onji.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "bugs_type")
public class BugsType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private Integer key;

    @NotNull
    private String name;

    @NotNull
    private Integer sourceId;

    @NotNull
    private Integer relatedId;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
