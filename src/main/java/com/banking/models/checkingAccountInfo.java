package com.banking.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="CHECKING_ACCTS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class checkingAccountInfo {


    @Column(name="CLIENT_ID")
    @NotNull
    private int clientId;

    @Column(name="ROUT_NUM")
    @NotNull
    private long routNum;

    @Column(name="CHK_ACC_NUM",unique = true)
    @NotNull
    private long chkAccNum;

    @Column(name="CHK_ACC_BAL")
    @NotNull
    private long chkAccBal;

    @Id
    @Column(name="dummy_PK")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dummy_PK;


}
