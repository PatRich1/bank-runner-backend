package com.banking.models;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.Objects;



@Entity
@Table(name="manager_creds")
public class managerCredentials{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manager_id")
    private int app_id;

    @NotNull
    @Column(name = "first_name")
    private String fname;

    @NotNull
    @Column(name = "last_name")
    private String lname;

    @NotNull
    @Column(name = "username")
    private String uname;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;


}