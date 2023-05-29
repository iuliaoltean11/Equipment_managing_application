package com.ulbs.deposit.repository;

import com.ulbs.deposit.entity.Echipament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EchipamentRepository extends CrudRepository<Echipament, Long> {
    List<Echipament> findAll();

}
