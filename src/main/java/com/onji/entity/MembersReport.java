package com.onji.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "members_report")
public class MembersReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @NotNull
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Length(max = 128)
    private String email;

    @Length(max = 256)
    private String name;

    @Length(max = 256)
    private String userName;

    @Length(max = 128)
    private String position;

    @Length(max = 128)
    private String year;

    @NotNull
    private Integer month;

    @NotNull
    private Double workload;

    @NotNull
    private Integer task;

    @NotNull
    private Double kloc;

}
