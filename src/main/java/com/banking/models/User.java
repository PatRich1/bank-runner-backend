package com.banking.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Table(name="CLIENT_PROFILE")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CLIENT_ID")
    private int id;
    @NotNull
    @Column(name="F_NAME")
    private String fname;
    @NotNull
    @Column(name="M_INIT")
    private String middleInit;
    @NotNull
    @Column(name="L_NAME")
    private String lname;
    @NotNull
    @Column(name="PHONE")
    private String phone;
    @NotNull
    @Column(name="STREET")
    private String street;
    @NotNull
    @Column(name="CITY")
    private String city;
    @NotNull
    @Column(name="STATE")
    private String state;
    @NotNull
    @Column(name="ZIP")
    private String zip;

    @NotNull
    @Column(name="SS_NUM")
    private String ssNum;
    @NotNull
    @Column(name="U_NAME")
    private String uname;
    @NotNull
    @Column(name="EMAIL")
    private String email;

    @NotNull
    @Column(name="PASS")
    private String pass;

    @NotNull
    @Column(name = "role")
    private String role;
}
