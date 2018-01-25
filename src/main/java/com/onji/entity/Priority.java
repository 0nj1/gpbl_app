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
@Table(name = "priority")
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private Integer key;

    @Length(max = 256)
    private String name;

    @NotNull
    private Integer sourceId;

    @NotNull
    private Integer integratedPriorityId;

    @NotNull
    private Integer relatedId;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
