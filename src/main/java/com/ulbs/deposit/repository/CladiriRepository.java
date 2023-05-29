package com.ulbs.deposit.repository;

import com.ulbs.deposit.entity.Cladiri;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CladiriRepository extends CrudRepository<Cladiri, Long> {
    Cladiri findCladiriByNumeCladire(String numeCladire);
}
