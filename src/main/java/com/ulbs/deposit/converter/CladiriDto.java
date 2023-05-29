package com.ulbs.deposit.converter;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CladiriDto {

    private Long id;

    private String numeCladire;

    private Integer nrmaxEtaje;

    public CladiriDto(String numeCladire, Integer nrmaxEtaje) {
        this.numeCladire = numeCladire;
        this.nrmaxEtaje = nrmaxEtaje;
    }
}
