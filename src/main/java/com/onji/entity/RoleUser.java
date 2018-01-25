package com.onji.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "role_users")
public class RoleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
