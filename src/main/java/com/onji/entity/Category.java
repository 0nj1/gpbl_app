package com.onji.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String value;

    @NotNull
    private Integer status;

    @NotNull
    private Integer userId;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
