package com.banking.models;


import org.springframework.lang.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name="CLIENT_PROFILE")
public class clientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CLIENT_ID")
    private int clientId;
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

    public long getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @NotNull
    public String getFname() {
        return fname;
    }

    public void setFname(@NotNull String fname) {
        this.fname = fname;
    }

    public String getMiddleInit() {
        return middleInit;
    }

    public void setMiddleInit(String middleInit) {
        this.middleInit = middleInit;
    }

    @NotNull
    public String getLname() {
        return lname;
    }

    public void setLname(@NotNull String lname) {
        this.lname = lname;
    }

    @NotNull
    public String getPhone() {
        return phone;
    }

    public void setPhone(@NotNull String phone) {
        this.phone = phone;
    }

    @NotNull
    public String getStreet() {
        return street;
    }

    public void setStreet(@NotNull String street) {
        this.street = street;
    }

    @NotNull
    public String getCity() {
        return city;
    }

    public void setCity(@NotNull String city) {
        this.city = city;
    }

    @NotNull
    public String getState() {
        return state;
    }

    public void setState(@NotNull String state) {
        this.state = state;
    }

    @NotNull
    public String getZip() {
        return zip;
    }

    public void setZip(@NotNull String zip) {
        this.zip = zip;
    }

    @NotNull
    public String getSsNum() {
        return ssNum;
    }

    public void setSsNum(@NotNull String ssNum) {
        this.ssNum = ssNum;
    }

    @NotNull
    public String getUname() {
        return uname;
    }

    public void setUname(@NotNull String uname) {
        this.uname = uname;
    }

    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    @NotNull
    public String getPass() {
        return pass;
    }

    public void setPass(@NotNull String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof clientProfile)) return false;
        clientProfile that = (clientProfile) o;
        return getClientId() == that.getClientId() && getMiddleInit() == that.getMiddleInit() && getFname().equals(that.getFname()) && getLname().equals(that.getLname()) && getPhone().equals(that.getPhone()) && getStreet().equals(that.getStreet()) && getCity().equals(that.getCity()) && getState().equals(that.getState()) && getZip().equals(that.getZip()) && getSsNum().equals(that.getSsNum()) && getUname().equals(that.getUname()) && getEmail().equals(that.getEmail()) && getPass().equals(that.getPass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId(), getFname(), getMiddleInit(), getLname(), getPhone(), getStreet(), getCity(), getState(), getZip(), getSsNum(), getUname(), getEmail(), getPass());
    }

    @Override
    public String toString() {
        return "clientProfile{" +
                "clientId=" + clientId +
                ", fname='" + fname + '\'' +
                ", middleInit=" + middleInit +
                ", lname='" + lname + '\'' +
                ", phone='" + phone + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", ssNum='" + ssNum + '\'' +
                ", uname='" + uname + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    public clientProfile() {
    }

    public clientProfile
    (int clientId, @NotNull String fname, String middleInit,
     @NotNull String lname, @NotNull String phone, @NotNull String street,
     @NotNull String city, @NotNull String state, @NotNull String zip,
     @NotNull String ssNum, @NotNull String uname, @NotNull String email,
     @NotNull String pass)
    {
        this.clientId = clientId;
        this.fname = fname;
        this.middleInit = middleInit;
        this.lname = lname;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.ssNum = ssNum;
        this.uname = uname;
        this.email = email;
        this.pass = pass;
    }


}
