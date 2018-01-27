package com.onji.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "project_report")
public class ProjectReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Length(max = 256)
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Length(max = 256)
    private String projectName;

    @Length(max = 128)
    private String year;

    @NotNull
    private Integer month;

    @NotNull
    private Integer testedTc;

    @NotNull
    private Integer loc;

    @NotNull
    private Integer status;

    @NotNull
    private Integer task;

    @NotNull
    private Double weightedBug;

    @NotNull
    private Double weightedUatBug;

    @NotNull
    private Double actualHour;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
