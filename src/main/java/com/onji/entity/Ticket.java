package com.onji.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "integrated_ticket_id")
	private Integer integrated_ticket_id;

    @Column(name = "integrated_parent_id")
	private Integer integrated_parent_id;

    @Column(name = "source_id")
	private Integer source_id;

    @Column(name = "ticket_type_id")
	private Integer ticket_type_id;

    @Column(name = "status_id")
	private Integer status_id;

    @Column(name = "title")
	private String title;

    @Column(name = "bug_weight_id")
    private Integer bug_weight_id;

    @Column(name = "root_cause_id")
    private Integer root_cause_id;

    @Column(name = "priority_id")
    private Integer priority_id;

    @Column(name = "bug_type_id")
    private Integer bug_type_id;





}
