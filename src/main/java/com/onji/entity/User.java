package com.onji.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;

    private String permissions;

    private String position;

    private String memberCode;

    private Integer departmentId;

    private Timestamp lastLogin;

    private Integer sourceId;

    private Integer relatedId;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
