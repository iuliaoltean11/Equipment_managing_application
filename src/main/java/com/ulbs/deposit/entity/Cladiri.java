package com.ulbs.deposit.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cladiri")
public class Cladiri {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "nume_cladire",nullable = false)
    private String numeCladire;

    @Column(name = "nr_max_etaj",nullable = false)
    private Integer nrmaxEtaje;
}
