package com.onji.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "ticket_type")
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private Integer key;

    @Length(max = 256)
    private String name;

    @NotNull
    private Integer sourceId;

    @NotNull
    private Integer relatedId;

    @NotNull
    private Integer integratedTicketTypeId;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
