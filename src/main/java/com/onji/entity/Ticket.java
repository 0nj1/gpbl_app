package com.onji.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
	private Integer integratedTicketId;

    @NotNull
	private Integer integratedParentId;

    @NotNull
	private Integer sourceId;

    //TODO: add ticket type

    //TODO: add status

    @NotNull
	private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bug_weight_id")
    private BugsWeight bugsWeight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bug_type_id")
    private BugsType bugsType;
    
}
