package com.banking.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="SAVINGS_ACCTS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class savingsAccountInfo {


    @Column(name="CLIENT_ID")
    @NotNull
    private int clientId;

    @Column(name="ROUT_NUM")
    @NotNull
    private long routNum;

    @Column(name="SAV_ACC_NUM",unique = true)
    @NotNull
    private long savAccNum;

    @Column(name="SAV_ACC_BAL")
    @NotNull
    private long savAccBal;

    @Id
    @Column(name="dummy_PK")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dummy_PK;

}
