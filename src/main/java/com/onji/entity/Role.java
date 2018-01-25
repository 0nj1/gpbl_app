package com.onji.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Length(max = 256)
    private String slug;

    @Length(max = 256)
    private String name;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
