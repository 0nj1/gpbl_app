package com.onji.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer sourceId;

    private Integer relatedId;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private Timestamp deletedAt;
}
