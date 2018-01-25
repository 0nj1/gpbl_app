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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    private Integer actualHour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @NotNull
    private Timestamp spentAt;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
