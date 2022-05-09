package com.banking.models;




import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Objects;


@Entity
@Table(name="loan_application")
public class loanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="app_id")
    private int app_id;

    @NotNull
    @Column(name= "first_name")
    private String fname;


    @Column(name = "initial")
    private String midInitial;

    @NotNull
    @Column(name = "last_name")
    private String lname;

    @NotNull
    @Column(name = "DOB")
    private String DOB;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "marital_status")
    private String maritalStatus;

    @NotNull
    @Column(name = "street")
    private String street;


    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "state")
    private String state;

    @NotNull
    @Column(name = "zip")
    private String zip;

    @NotNull
    @Column(name = "ss_num")
    private String ssNum;

    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "loan_amount")
    private int loanAmount;

    @NotNull
    @Column(name = "loan_purpose")
    private String loanPurpose;

    @NotNull
    @Column(name = "salary")
    private int salary;

    @Column(name = "decision_description", length = 750)
    private String description;

    @Column(name = "status")
    private String status;

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

    public String getMidInitial() {
        return midInitial;
    }

    public void setMidInitial(String midInitial) {
        this.midInitial = midInitial;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getSsNum() {
        return ssNum;
    }

    public void setSsNum(String ssNum) {
        this.ssNum = ssNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(String loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof loanApplication)) return false;
        loanApplication that = (loanApplication) o;
        return getApp_id() == that.getApp_id() && getLoanAmount() == that.getLoanAmount() && getSalary() == that.getSalary() && Objects.equals(getFname(), that.getFname()) && Objects.equals(getMidInitial(), that.getMidInitial()) && Objects.equals(getLname(), that.getLname()) && Objects.equals(getDOB(), that.getDOB()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getMaritalStatus(), that.getMaritalStatus()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getCity(), that.getCity()) && Objects.equals(getState(), that.getState()) && Objects.equals(getZip(), that.getZip()) && Objects.equals(getSsNum(), that.getSsNum()) && Objects.equals(getPhone(), that.getPhone()) && Objects.equals(getLoanPurpose(), that.getLoanPurpose()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getApp_id(), getFname(), getMidInitial(), getLname(), getDOB(), getEmail(), getMaritalStatus(), getStreet(), getCity(), getState(), getZip(), getSsNum(), getPhone(), getLoanAmount(), getLoanPurpose(), getSalary(), getDescription(), getStatus());
    }

    @Override
    public String toString() {
        return "loanApplication{" +
                "app_id=" + app_id +
                ", fname='" + fname + '\'' +
                ", midInitial='" + midInitial + '\'' +
                ", lname='" + lname + '\'' +
                ", DOB='" + DOB + '\'' +
                ", email='" + email + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", ssNum='" + ssNum + '\'' +
                ", phone='" + phone + '\'' +
                ", loanAmount=" + loanAmount +
                ", loanPurpose='" + loanPurpose + '\'' +
                ", salary=" + salary +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
