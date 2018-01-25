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
@Table(name = "projectKpi")
public class ProjectKpi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Length(max = 256)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId")
    private Project project;

    @NotNull
    private Integer baselineFlag;

    @NotNull
    private Timestamp startDate;

    @NotNull
    private Timestamp endDate;

    private Double actualCostEfficiency;

    private Double planCostEfficiency;

    private Double actualFixCode;

    private Double planFixCode;

    private Double actualLeakage;

    private Double planLeakage;

    private Double actualCustomerSurvey;

    private Double planCustomerSurvey;

    private Double actualBugAfterReleaseNumber;

    private Double planBugAfterReleaseNumber;

    private Double actualBugAfterReleaseWeight;

    private Double planBugAfterReleaseWeight;

    private Double actualDefectRemoveEfficiency;

    private Double planDefectRemoveEfficiency;

    private Double actualDefectRate;

    private Double planDefectRate;

    private Double actualCodeProductivity;

    private Double planCodeProductivity;

    private Double actualTestCaseProductivity;

    private Double planTestCaseProductivity;

    private Double actualTestedProductivity;

    private Double planTestedProductivity;

    @NotNull
    private String description;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
