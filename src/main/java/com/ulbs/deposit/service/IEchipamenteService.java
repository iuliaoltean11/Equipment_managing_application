package com.ulbs.deposit.service;

import com.ulbs.deposit.entity.Echipament;

import java.util.List;

public interface IEchipamenteService {
    List<Echipament> getAllEchipamente();

    Boolean addNewEchipamente(Echipament echipament);

    List<Echipament> searchEchipamente(String keyword);

    Echipament getEchipamentById(Long id);

    void deleteEchipament(Long id);
}
