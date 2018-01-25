package com.onji.entity;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;

    private String password;

    private String permissions;

    private String position;

    private String memberCode;

    private Integer departmentId;

    private Timestamp lastLogin;

    private String firstName;

    private String lastName;

    private Integer sourceId;

    private Integer relatedId;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
