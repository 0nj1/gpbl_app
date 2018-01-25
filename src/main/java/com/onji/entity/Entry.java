package com.onji.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "entries")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private Integer projectId;

    @NotNull
    private Integer integratedEntryId;

    @NotNull
    private Integer ticketId;

    @NotNull
    private Integer userId;


    private Integer actualHour;

    private Integer ActivityId;

    private Timestamp spentAt;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
