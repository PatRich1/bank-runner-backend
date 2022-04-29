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

    public managerCredentials(int app_id, String fname, String lname, String uname, String email, String password) {
        this.app_id = app_id;
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.email = email;
        this.password = password;
    }

    public managerCredentials() {
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof managerCredentials)) return false;
        managerCredentials that = (managerCredentials) o;
        return getApp_id() == that.getApp_id() && Objects.equals(getFname(), that.getFname()) && Objects.equals(getLname(), that.getLname()) && Objects.equals(getUname(), that.getUname()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getApp_id(), getFname(), getLname(), getUname(), getEmail(), getPassword());
    }


    @Override
    public String toString() {
        return "managerCredentials{" +
                "app_id=" + app_id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", uname='" + uname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}