package com.onji.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String projectId;

    @NotNull
    private String projectKey;

    @NotNull
    private Integer sourceId;

    @Length(max = 256)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    private Timestamp actualStartDate;

    private Timestamp actualEndDate;

    @NotNull
    private Integer languageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    private Timestamp createdAt;

    @NotNull
    private Timestamp updatedAt;

    @NotNull
    private Timestamp deletedAt;
}
