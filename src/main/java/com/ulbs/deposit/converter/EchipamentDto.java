package com.ulbs.deposit.converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EchipamentDto {

    private String id;

    private String numeEchipament;

    private Date dataAdaugare;

    private Date dataSchimbare;

    private String cladire;

    private String amplasare;

    public EchipamentDto(String numeEchipament, Date dataAdaugare, Date dataSchimbare, String amplasare) {
        this.numeEchipament = numeEchipament;
        this.dataAdaugare = dataAdaugare;
        this.dataSchimbare = dataSchimbare;
        this.amplasare = amplasare;

    }
}
