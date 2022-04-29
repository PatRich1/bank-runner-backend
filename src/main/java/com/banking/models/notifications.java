package com.banking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Notifications")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class notifications {

    @Column(name="CLIENT_ID")
    @NotNull
    private int clientId;

    @Column(name="CLIENT_Name")
    @NotNull
    private String clientName;

    @Column(name="CLIENT_EMAIL")
    @NotNull
    private String email;

    @Column(name="DESCRIPTION")
    @NotNull
    private String description;

    @Column(name="ACC_NUM")
    @NotNull
    private long accNum;

    @Column(name="AMOUNT")
    @NotNull
    private long amount;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

}
