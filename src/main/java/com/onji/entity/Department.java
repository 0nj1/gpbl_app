package com.onji.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private Integer parentId;

    @NotNull
    @Length(max = 256)
    private String name;

    @NotNull
    private Integer managerId;

    // TODO: add status

    @NotNull
    private String description;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
