package com.onji.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "project_versions")
public class ProjectVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private Integer integratedVersionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @NotNull
    private Integer sourceId;

    @NotNull
    private Integer relatedId;

    @Length(max = 256)
    private String name;

    @NotNull
    private Integer status;

    @NotNull
    private String description;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
