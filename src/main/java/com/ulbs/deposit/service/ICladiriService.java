package com.ulbs.deposit.service;

import com.ulbs.deposit.entity.Cladiri;

import java.util.List;

public interface ICladiriService {
    List<Cladiri> getAllCladiri();
    Boolean addNewCladire(Cladiri cladire);

    Cladiri getCladireByName(String name);

    void deleteCladire(Long id);

}
