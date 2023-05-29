package com.ulbs.deposit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "echipament")
public class Echipament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "nume_echipament",nullable = false)
    private String numeEchipament;

    @Column(name="data_adaugare",nullable = false)
    private Date dataAdaugare;

    @Column(name = "data schimbare",nullable = false)
    private Date dataSchimbare;

    @Column(name = "etaj_si_sala",nullable = false)
    private String amplasare;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cladire")
    private Cladiri cladire;
}
