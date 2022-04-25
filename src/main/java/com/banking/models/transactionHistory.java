package com.banking.models;
import javax.persistence.*;


@Entity
@Table(name="TRANSACTION_HISTORY")
public class transactionHistory {

    @Id
    @Column(name = "TRANSACTION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transId;

    @Column(name = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date timestamp;

    @Column(name="TRANS_TYPE")
    private String transType;

    @Column(name="ACC_NUM")
    private long accNum;

    @Column(name="AMOUNT")
    private long amount;



}
